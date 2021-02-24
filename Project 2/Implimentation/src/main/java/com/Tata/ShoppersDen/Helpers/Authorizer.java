package com.Tata.ShoppersDen.Helpers;

import com.Tata.ShoppersDen.Dao.DatabaseAccess;
import com.Tata.ShoppersDen.Dao.DatabaseAccessImpl;
import com.Tata.ShoppersDen.Entity.Admin;
import com.Tata.ShoppersDen.Entity.Cart;
import com.Tata.ShoppersDen.Entity.Person;
import com.Tata.ShoppersDen.Entity.User;

import java.sql.SQLException;

public final class Authorizer {
    private final DatabaseAccess databaseAccess;

    public Authorizer() throws SQLException {
        databaseAccess = new DatabaseAccessImpl();
        databaseAccess.checkAllTables();
    }

    private Admin setAdminPrivileges(Admin admin) {
        if(admin == null)
            return null;
        try {
            admin.setDatabaseAccess(new DatabaseAccessImpl());
            return admin;
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

    private User setUserPrivileges(User user){
        if(null == user)
            return null;
        try{
            user.setDatabaseAccess(new DatabaseAccessImpl());
            user.setCart(new Cart());
            return user;
        }
        catch (SQLException error){
            error.printStackTrace();
            return null;
        }
    }

    public User addNewUser(String email,String name,long phoneNo,String passWord,String address, String secondAddress,String secretQuestion,String userId) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPhoneNo(phoneNo);
        user.setPassWord(PasswordEncryptor.cryptWithMD5(passWord));
        user.setAddress(address);
        user.setSecondAddress(secondAddress);
        user.setSecretQuestion(secretQuestion);
        user.setUserId(userId);
        try {
            user = databaseAccess.addNewUser(user);
            return setUserPrivileges(user);
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

    public Admin addNewAdmin(String adminId,String adminName,String adminPass){
        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setAdminPassword(PasswordEncryptor.cryptWithMD5(adminPass));
        try {
            return setAdminPrivileges(databaseAccess.addNewAdmin(admin));
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }

    public Person getPersonDetails(String name,String password){
        try{
            password = PasswordEncryptor.cryptWithMD5(password);
            Person person = databaseAccess.getPersonDetails(name,password);
            if(person == null)
                return null;
            if(person instanceof User)
                return setUserPrivileges((User) person);
            return setAdminPrivileges((Admin) person);
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return null;
    }
}
