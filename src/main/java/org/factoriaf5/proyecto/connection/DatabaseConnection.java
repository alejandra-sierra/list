package org.factoriaf5.proyecto.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/todolist";
    private static final String USER = "root";
    public static String PASSWORD = "1234";

    public static void main(String[] args) {
        try {
            @SuppressWarnings("unused")
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Unimplemented method 'getConnection'");
    }
}
