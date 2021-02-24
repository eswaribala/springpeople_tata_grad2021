package com.Tata.ShoppersDen.Helpers;

import com.Tata.ShoppersDen.Dao.DatabaseAccess;
import com.Tata.ShoppersDen.Dao.DatabaseAccessImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestDatabaseConnections {

    private static Connection connection;

    @BeforeAll
    static void connectToDataBase() throws SQLException {
        connection = PostgresConnector.connect();
    }

    @AfterAll
    static void closeDataBaseConnection() throws SQLException{
        connection.close();
    }

    @Test
    void checkDataBaseConnection(){
        assertNotEquals(connection,null);
    }

}