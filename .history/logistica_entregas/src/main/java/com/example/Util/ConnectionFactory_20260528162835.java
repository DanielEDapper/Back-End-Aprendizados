package com.example.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
    private static String URL = "jdbc:mysql://localhost:3306/logistica_?useSSL=false&serverTimezone=UTC";
    private static String USER = "root";
    private static String PASSWORD = "mysqlPW";

    public static Connection conectar() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
