package com.Tata.ShoppersDen.Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PostgresConnector {

    public static Connection connect() throws SQLException{
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        String userName =   resourceBundle.getString("userName");
        String passWord =   resourceBundle.getString("passWord");
        String url      =   resourceBundle.getString("url");
        return DriverManager.getConnection(url,userName,passWord);
    }
}
