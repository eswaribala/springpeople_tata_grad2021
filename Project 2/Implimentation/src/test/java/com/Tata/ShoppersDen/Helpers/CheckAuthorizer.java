package com.Tata.ShoppersDen.Helpers;

import com.Tata.ShoppersDen.Dao.DatabaseAccess;
import com.Tata.ShoppersDen.Dao.DatabaseAccessImpl;
import com.Tata.ShoppersDen.Entity.Admin;
import com.Tata.ShoppersDen.Entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class CheckAuthorizer {
    private static DatabaseAccess databaseAccess;
    private static Authorizer authorizer;

    @BeforeAll
    static void connectToDataBase() throws SQLException {
        databaseAccess = new DatabaseAccessImpl();
        databaseAccess.clearAllData();
        authorizer = new Authorizer();
    }

    @Test
    public void checkAdditionOfUsers(){
        User user = authorizer.addNewUser("unknown123@gmail.com","unknown",1234567890,"unknown@123","#1234","#1234","Nothing??","unknownUser@123");
        if(user == null)
            user = (User) authorizer.getPersonDetails("unknownUser@123","unknown@123");
        assertNotEquals(null,user);
        User temp = authorizer.addNewUser("unknown123@gmail.com","unknown",1234567890,"unknown@123","#1234","#1234","Nothing??","unknownUser@123");
        assertEquals(null,temp);
        user = (User) authorizer.getPersonDetails("unknownUser@123","unknown@123");
        assertNotEquals(user,null);
        user = (User) authorizer.getPersonDetails("unknownUser@123","unknown@1234");
        assertEquals(user,null);
    }

    @Test
    public void checkAdditionOfAdmins(){
        Admin admin = authorizer.addNewAdmin("Hemanth@910","Hemanth","Hemanth@910");
        if(admin == null)
            admin = (Admin) authorizer.getPersonDetails("Hemanth@910","Hemanth@910");
        assertNotEquals(admin,null);
        Admin temp = authorizer.addNewAdmin("Hemanth@910","Hemanth","Hemanth@910");
        assertEquals(temp,null);
        admin = (Admin)  authorizer.getPersonDetails("Hemanth@910","Hemanth@910");
        assertNotEquals(admin,null);
        admin = (Admin)  authorizer.getPersonDetails("Hemanth@910","Hemanth@9100");
        assertEquals(admin,null);
    }

    @AfterAll
    static void closeDataBaseConnection() throws SQLException{
        databaseAccess = null;
        authorizer = null;
    }
}
