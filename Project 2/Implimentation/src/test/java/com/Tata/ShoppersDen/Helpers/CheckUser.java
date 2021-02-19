package com.Tata.ShoppersDen.Helpers;

import com.Tata.ShoppersDen.Dao.DatabaseAccess;
import com.Tata.ShoppersDen.Dao.DatabaseAccessImpl;
import com.Tata.ShoppersDen.Entity.Admin;
import com.Tata.ShoppersDen.Entity.Product;
import com.Tata.ShoppersDen.Entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckUser{

    private static Authorizer authorizer;
    private static DatabaseAccess databaseAccess;

    @BeforeAll
    static void connectToDataBase() throws SQLException {
        authorizer = new Authorizer();
        databaseAccess = new DatabaseAccessImpl();
        databaseAccess.clearAllData();
    }

    @AfterAll
    static void closeDataBaseConnection() throws SQLException{
        authorizer = null;
        databaseAccess = null;
    }

    private static Stream<Arguments> ProvideProducts(){
        List<Product> products = new ArrayList<>();
        for(int i=0;i<10;++i){
            Product product = new Product();
            product.setCategoryName("Random Category");
            product.setCategoryId("Cate-1234" + new Random().nextInt(1000));
            product.setProductName("Random Product");
            product.setProductId("Product-1234" + new Random().nextInt(1000));
            product.setProductDesc("Random Description");
            product.setImageUrl(null);
            product.setQuantity(new Random().nextInt(10000));
            product.setExpDate(LocalDate.now());
            product.setPrice(new Random().nextInt(10000) + new Random().nextFloat());
            products.add(product);
        }
        return products.stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("ProvideProducts")
    void checkDataBaseConnection(Product product) throws SQLException {
        Admin admin = authorizer.addNewAdmin("Hemanth@910","Hemanth","Hemanth@910");
        if(admin == null)
            admin = (Admin) authorizer.getPersonDetails("Hemanth@910","Hemanth@910");
        admin.addProduct(product);
        User user = authorizer.addNewUser("unknown123@gmail.com","unknown",1234567890,"unknown@123","#1234","#1234","Nothing??","unknownUser@123");
        if(user == null)
            user = (User) authorizer.getPersonDetails("unknownUser@123","unknown@123");
        List<Product> products = user.getAllProducts();
        assertTrue(products.size()>0);
        
        admin.deleteProduct(product);
        admin.deleteCategory(product);

        products = user.getAllProducts();
        System.out.println(products);

        assertTrue(products.size() == 0);
    }
}
