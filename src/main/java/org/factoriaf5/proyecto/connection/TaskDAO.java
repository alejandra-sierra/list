package org.factoriaf5.proyecto.connection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.proyecto.models.Task;

public class TaskDAO {
    @SuppressWarnings("CallToPrintStackTrace")
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM tasks";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setTask(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void addTask(String description) {
        
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO tasks (description) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, description);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("CallToPrintStackTrace")

    public void updateTask(int id, boolean completed) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE tasks SET completed = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setBoolean(1, completed);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void deleteTask(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM tasks WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
