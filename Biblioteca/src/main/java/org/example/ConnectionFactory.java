package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory 
{
    private static final String URL =
            "jdbc:h2:~/biblioteca";

    private static final String USER = "sa";

    private static final String PASSWORD = "";

    public static Connection conectar() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }    
}
