package org.factoriaf5.proyecto;


import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.proyecto.models.Task;
import org.factoriaf5.proyecto.repositories.TaskRepository;
import org.factoriaf5.proyecto.services.TaskService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void testCreateNewTask() {
        Task task = new Task("Tarea 1", false);
        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.createNewTask(task);
        assertEquals(task, result);
    }

    @Test
    public void testGetAllTask() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Tarea 1", false));
        tasks.add(new Task("Tarea 2", false));
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTask();
        assertEquals(tasks, result);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testFindTaskById() {
        Task task = new Task("Tarea 1", false);
        task.setId(1L);
        when(taskRepository.getById(1L)).thenReturn(task);

        Task result = taskService.findTaskById(1L);
        assertEquals(task, result);
    }

    @Test
    public void testFindAllCompletedTask() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Tarea 1", true));
        tasks.add(new Task("Tarea 2", true));
        when(taskRepository.findByCompletedTrue()).thenReturn(tasks);

        List<Task> result = taskService.findAllCompletedTask();
        assertEquals(tasks, result);
    }

    @Test
    public void testFindAllInCompleteTask() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Tarea 1", false));
        tasks.add(new Task("Tarea 2", false));
        when(taskRepository.findByCompletedFalse()).thenReturn(tasks);

        List<Task> result = taskService.findAllInCompleteTask();
        assertEquals(tasks, result);
    }


    @Test
    public void testUpdateTask() {
        Task task = new Task("Tarea 1", false);
        task.setId(1L);
        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.updateTask(task);
        assertEquals(task, result);
    }


}