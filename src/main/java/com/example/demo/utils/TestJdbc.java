package com.example.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * TestJdbc
 */
public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/topics?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "password";

        try {
            System.out.println("Conneting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}