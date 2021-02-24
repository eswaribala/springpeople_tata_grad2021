package com.Tata.ShoppersDen.Dao;

import com.Tata.ShoppersDen.Entity.*;
import com.Tata.ShoppersDen.Helpers.Pair;
import com.Tata.ShoppersDen.Helpers.PostgresConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DatabaseAccessImpl implements DatabaseAccess{
    private final Connection connection;
    private final ResourceBundle resourceBundle;

    public DatabaseAccessImpl() throws SQLException {
        connection = PostgresConnector.connect();
        connection.setAutoCommit(false);
        resourceBundle = ResourceBundle.getBundle("db");
    }

    private void checkTable(String table) throws SQLException {
        PreparedStatement check = connection.prepareStatement(resourceBundle.getString(table));
        check.execute();
        connection.commit();
    }

    private boolean checkValue(String checkStatement,String... Values) throws SQLException {
        PreparedStatement checkProduct = connection.prepareStatement(resourceBundle.getString(checkStatement));
        for(int i=0;i<Values.length;++i)
            checkProduct.setString(i+1,Values[i]);
        System.out.println(checkProduct);
        ResultSet resultSet = checkProduct.executeQuery();
        return resultSet.next();
    }

    @Override
    public boolean addCategory(Category category) throws SQLException {

        if(checkValue("checkCategoryValue", category.getCategoryId()))
            return false;
        PreparedStatement insert = connection.prepareStatement(resourceBundle.getString("insertIntoCategory"));
        insert.setString(1,category.getCategoryId());
        insert.setString(2,category.getCategoryName());
        System.out.println(insert);
        insert.execute();
        connection.commit();
        return true;
    }

    @Override
    public boolean addProduct(Product product) throws SQLException {
        addCategory(product);
        if(checkValue("checkProductValue", product.getProductId()))
            return false;
        PreparedStatement insert = connection.prepareStatement(resourceBundle.getString("insertIntoProduct"));
        insert.setString(1,product.getProductId());
        insert.setString(2, product.getProductDesc());
        insert.setString(3, product.getProductName());
        insert.setFloat(4,product.getPrice());
        insert.setInt(5,product.getQuantity());
        insert.setString(6,product.getCategoryId());
        insert.setDate(7,Date.valueOf(product.getExpDate()));
        insert.setString(8,product.getImageUrl() == null ? "NULL" : product.getImageUrl());
        try{
            insert.execute();
            connection.commit();
            return true;
        }
        catch (SQLException error) {
            error.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        PreparedStatement product_list = connection.prepareStatement(resourceBundle.getString("getAllProducts"));
        ResultSet resultSet = product_list.executeQuery();
        while(resultSet.next()) {
            Product product = new Product();
            product.setCategoryId(resultSet.getString("category_id"));
            product.setProductId(resultSet.getString("product_id"));
            product.setProductName(resultSet.getString("product_name"));
            product.setProductDesc(resultSet.getString("product_desc"));
            product.setPrice(resultSet.getInt("price"));
            product.setQuantity(resultSet.getInt("quantity"));
            product.setExpDate(resultSet.getDate("date").toLocalDate());
            product.setImageUrl(resultSet.getString("img_url"));
            product.setCategoryName(resultSet.getString("category_name"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getCategoryProducts(String categoryId) throws SQLException {
        List<Product> products = getAllProducts();
        return products.stream().filter(T -> T.getCategoryId().compareTo(categoryId) == 0).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public User addNewUser(User user) throws SQLException {
        if(checkValue("checkUserValue",user.getEmail(),user.getUserId()))
            return null;
        PreparedStatement insert = connection.prepareStatement(resourceBundle.getString("insertIntoUser"));
        insert.setLong(4,user.getPhoneNo());
        insert.setString(1,user.getAddress());
        insert.setString(2,user.getEmail());
        insert.setString(3,user.getName());
        insert.setString(5,user.getPassWord());
        insert.setString(6,user.getSecondAddress());
        insert.setString(7,user.getSecretQuestion());
        insert.setString(8,user.getUserId());
        insert.execute();
        connection.commit();
        return user;
    }

    @Override
    public Admin addNewAdmin(Admin admin) throws SQLException {
        if(checkValue("checkAdminValue",admin.getAdminId()))
            return null;
        PreparedStatement insert = connection.prepareStatement(resourceBundle.getString("insertIntoAdmin"));
        insert.setString(1,admin.getAdminId());
        insert.setString(2,admin.getAdminName());
        insert.setString(3, admin.getAdminPassword());
        insert.execute();
        connection.commit();
        return admin;
    }

    @Override
    public Person getPersonDetails(String name, String password) throws SQLException {
        PreparedStatement checkUser = connection.prepareStatement(resourceBundle.getString("checkUserLoginDetails"));
        checkUser.setString(1,name);
        checkUser.setString(2,password);
        ResultSet resultSet = checkUser.executeQuery();
        if(resultSet.next()){
            User user = new User();
            user.setUserId(resultSet.getString("user_id"));
            user.setSecretQuestion(resultSet.getString("secret_question"));
            user.setSecondAddress(resultSet.getString("second_address"));
            user.setPassWord(resultSet.getString("password"));
            user.setPhoneNo(resultSet.getLong("phone"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setAddress(resultSet.getString("address"));
            return user;
        }

        PreparedStatement checkAdmin = connection.prepareStatement(resourceBundle.getString("checkAdminLoginDetails"));
        checkAdmin.setString(1,name);
        checkAdmin.setString(2,password);
        resultSet = checkAdmin.executeQuery();
        if(resultSet.next()){
            Admin admin = new Admin();
            admin.setAdminId(resultSet.getString("admin_id"));
            admin.setAdminPassword(resultSet.getString("password"));
            admin.setAdminName(resultSet.getString("admin_name"));
            return admin;
        }
        return null;
    }

    @Override
    public void checkAllTables() throws SQLException {
        checkTable("checkCategory");
        checkTable("checkProduct");
        checkTable("checkUser");
        checkTable("checkAdmin");
        checkTable("checkTransactions");
    }

    @Override
    public boolean completeTransaction(Transaction transaction) {
        try {
            PreparedStatement insert = connection.prepareStatement(resourceBundle.getString("insertIntoTransactions"));
            insert.setDate(1,Date.valueOf(transaction.getTransactionDate()));
            PreparedStatement updateQuantity = connection.prepareStatement(resourceBundle.getString("updateQuantity"));
            for(String key : transaction.getProduct().keySet()){
                int quantity = transaction.getProduct().get(key).snd;
                insert.setString(2,key);
                insert.setFloat(3,transaction.getProduct().get(key).fst);
                insert.setInt(4,quantity);
                insert.setString(5,transaction.getUser());
                System.out.println(insert);
                insert.execute();
                updateQuantity.setInt(1,quantity);
                updateQuantity.setString(2,key);
                updateQuantity.execute();
            }
            connection.commit();
            return true;
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }

    public List<Transaction> getAllTransaction(){
        try{
            PreparedStatement getData = connection.prepareStatement(resourceBundle.getString("getAllTransactions"));
            ResultSet resultSet = getData.executeQuery();
            List<Transaction> transactions = new ArrayList<>();
            while(resultSet.next()){
                Transaction transaction = new Transaction();
                transaction.setUser(resultSet.getString("user_id"));
                transaction.setTransactionDate(resultSet.getDate("trans_date").toLocalDate());
                transaction.setProduct(new HashMap<>());
                transaction.getProduct().put(resultSet.getString("product_id"),new Pair<>(resultSet.getFloat("price"),resultSet.getInt("quantity")));
            }
            return transactions;
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeCategory(Category category) throws SQLException {
        PreparedStatement delete = connection.prepareStatement(resourceBundle.getString("deleteCategory"));
        delete.setString(1,category.getCategoryId());
        delete.executeUpdate();
        connection.commit();
    }

    public void removeProduct(Product product) throws SQLException {
        PreparedStatement delete = connection.prepareStatement(resourceBundle.getString("deleteProduct"));
        delete.setString(1, product.getProductId());
        System.out.println(delete);
        delete.executeUpdate();
        connection.commit();
    }

    public boolean clearAllData(){
        try {
            Statement clear = connection.createStatement();
            clear.executeUpdate(resourceBundle.getString("clearAllData"));
            connection.commit();
            return true;
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }
}
