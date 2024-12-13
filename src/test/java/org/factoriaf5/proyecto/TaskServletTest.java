package org.factoriaf5.proyecto;

import java.io.IOException;

import org.factoriaf5.proyecto.connection.TaskServlet;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TaskServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @Test
    public void testDoGet() throws ServletException, IOException {
        when(request.getRequestDispatcher("tasks.jsp")).thenReturn(dispatcher);

        TaskServlet servlet = new TaskServlet();

        servlet.doGet(request, response);

        verify(dispatcher).forward(request, response);
    }
}