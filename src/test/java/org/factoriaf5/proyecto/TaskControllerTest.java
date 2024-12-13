package org.factoriaf5.proyecto;

import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.proyecto.controllers.TaskController;
import org.factoriaf5.proyecto.models.Task;
import org.factoriaf5.proyecto.services.TaskService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    private Task task;

    @BeforeEach
    public void setup() {
        task = new Task("Tarea 1", false);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGetAllTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        when(taskService.getAllTask()).thenReturn(tasks);

        ResponseEntity<List<Task>> response = taskController.getAllTasks();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(tasks, response.getBody());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGetAllCompletedTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        when(taskService.findAllCompletedTask()).thenReturn(tasks);

        ResponseEntity<List<Task>> response = taskController.getAllCompletedTasks();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(tasks, response.getBody());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGetAllIncompleteTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        when(taskService.findAllInCompleteTask()).thenReturn(tasks);

        ResponseEntity<List<Task>> response = taskController.getAllIncompleteTasks();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(tasks, response.getBody());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testCreateTask() {
        when(taskService.createNewTask(task)).thenReturn(task);

        ResponseEntity<Task> response = taskController.createTask(task);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(task, response.getBody());
    }
    @SuppressWarnings("deprecation")
    @Test
    public void testUpdateTask() {
        when(taskService.updateTask(task)).thenReturn(task);

        ResponseEntity<Task> response = taskController.updateTask(task);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(task, response.getBody());
    }
}