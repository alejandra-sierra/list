package org.factoriaf5.proyecto;

import org.factoriaf5.proyecto.models.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @Test
    public void testConstructor() {
        Task task = new Task("Tarea 1", false);
        assertEquals("Tarea 1", task.getTask());
        assertEquals(false, task.isCompleted());
    }

    @Test
    public void testGetTask() {
        Task task = new Task("Tarea 1", false);
        assertEquals("Tarea 1", task.getTask());
    }

    @Test
    public void testSetTask() {
        Task task = new Task("Tarea 1", false);
        task.setTask("Tarea 2");
        assertEquals("Tarea 2", task.getTask());
    }

    @Test
    public void testIsCompleted() {
        Task task = new Task("Tarea 1", false);
        assertEquals(false, task.isCompleted());
    }

    @Test
    public void testSetCompleted() {
        Task task = new Task("Tarea 1", false);
        task.setCompleted(true);
        assertEquals(true, task.isCompleted());
    }

    @Test
    public void testGetId() {
        Task task = new Task("Tarea 1", false);
        assertEquals(null, task.getId()); // El id se genera automáticamente en la base de datos
    }

    @Test
    public void testSetId() {
        Task task = new Task("Tarea 1", false);
        task.setId(1L);
        assertEquals(1L, task.getId());
    }
}