package com.Tata.ShoppersDen.Helpers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class CheckHelpers {

    private static Connection connection;

    @BeforeAll
    public static void getConnectionToDataBase() throws SQLException {
        connection = PostgresConnector.connect();
    }

    @Test
    public void checkPair(){
        Pair<Float,Integer> pr = new Pair<>(9.99F,1000);
        assertEquals(pr.fst,9.99F);
        assertEquals(pr.snd,1000);
        pr.setFst(100.00F);
        pr.setSnd(10000);
        assertNotEquals(pr.getFst(),9.99F);
        assertNotEquals(pr.getSnd(),1000);
    }

    private static Stream<Arguments> providePasswordEncryptorArguments(){
        return Stream.of(Arguments.of("Password@1234"),
                Arguments.of("Password@1235"),
                Arguments.of("Password@1236"),
                Arguments.of("Password@1237"),
                Arguments.of("Password@1238"));
    }

    @ParameterizedTest
    @MethodSource("providePasswordEncryptorArguments")
    public void checkPasswordEncryptor(String password){
        String encrypt = PasswordEncryptor.cryptWithMD5(password);
        assertNotEquals(encrypt,password);
        assertEquals(encrypt,PasswordEncryptor.cryptWithMD5(password));
        assertTrue(PasswordEncryptor.cryptWithMD5(password).compareTo(password) != 0);
    }

    @Test
    public void checkAuthorizer() throws SQLException {
        Authorizer authorizer = new Authorizer();
        assertNotEquals(authorizer,null);
    }

    @AfterAll
    public static void closeConnectionToDataBase() throws SQLException{
        connection.close();
    }

}
