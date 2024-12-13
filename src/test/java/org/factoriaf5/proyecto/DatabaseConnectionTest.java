package org.factoriaf5.proyecto;

import org.factoriaf5.proyecto.connection.DatabaseConnection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    @Test
    public void testGetConnection() {
        @SuppressWarnings("unused")
        String url = "jdbc:mysql://localhost:3306/todolist";
        @SuppressWarnings("unused")
        String user = "root";
        String password = "1234";

        try (Connection connection = DatabaseConnection.getConnection()) {
    
            assertNotNull(connection);
        } catch (SQLException e) {
            fail("Error al obtener la conexión: " + e.getMessage());
        }
    }

    @Test
    public void testGetConnectionInvalidURL() {
        DatabaseConnection.URL = "jdbc:mysql://invalid-url:3306/todolist";

        try (Connection connection = DatabaseConnection.getConnection()) {
            fail("Se esperaba una SQLException");
        } catch (SQLException e) {
            assertNotNull(e);
        } finally {
            DatabaseConnection.URL = "jdbc:mysql://localhost:3306/todolist";
        }
    }

    @Test
    public void testGetConnectionInvalidUser() {
        DatabaseConnection.USER = "invalid-user";

        try (Connection connection = DatabaseConnection.getConnection()) {
            fail("Se esperaba una SQLException");
        } catch (SQLException e) {
            assertNotNull(e);
        } finally {
            DatabaseConnection.USER = "root";
        }
    }

    @Test
    public void testGetConnectionInvalidPassword() {
        DatabaseConnection.PASSWORD = "invalid-password";

        try (Connection connection = DatabaseConnection.getConnection()) {
            fail("Se esperaba una SQLException");
        } catch (SQLException e) {
            assertNotNull(e);
        } finally {
            DatabaseConnection.PASSWORD = "1234";
        }
    }
}