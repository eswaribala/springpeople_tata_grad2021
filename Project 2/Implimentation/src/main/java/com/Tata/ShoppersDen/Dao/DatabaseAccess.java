package com.Tata.ShoppersDen.Dao;

import com.Tata.ShoppersDen.Entity.*;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseAccess {
    boolean addCategory(Category category) throws SQLException;

    boolean addProduct(Product product) throws SQLException;

    List<Product> getAllProducts() throws SQLException ;

    List<Product> getCategoryProducts(String categoryId) throws SQLException;

    User addNewUser(User user) throws SQLException;

    Admin addNewAdmin(Admin admin) throws SQLException;

    Person getPersonDetails(String UserName, String password) throws SQLException;

    void checkAllTables() throws SQLException;

    boolean completeTransaction(Transaction transaction);

    List<Transaction> getAllTransaction();

    void removeCategory(Category category) throws SQLException;

    public void removeProduct(Product product) throws SQLException;

    boolean clearAllData();
}
