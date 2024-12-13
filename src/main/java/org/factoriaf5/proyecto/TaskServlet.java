package org.factoriaf5.proyecto;
import java.io.IOException;
import java.util.List;

import org.factoriaf5.proyecto.models.Task;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TaskServlet extends HttpServlet {
    private final TaskDAO taskDAO = new TaskDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> tasks = taskDAO.getAllTasks();
        request.setAttribute("tasks", tasks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tasks.jsp");
        dispatcher.forward(request, response);
    }
}
