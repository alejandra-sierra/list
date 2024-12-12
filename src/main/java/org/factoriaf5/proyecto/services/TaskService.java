package org.factoriaf5.proyecto.services;


import java.util.List; 

import org.factoriaf5.proyecto.models.Task; 
import org.factoriaf5.proyecto.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

@Service
public class TaskService { 
	@Autowired
	private TaskRepository taskRepository; 
	
	public Task createNewTask(Task task) { 
		return taskRepository.save(task); 
	} 
	
	public List<Task> getAllTask() { 
		return taskRepository.findAll(); 
	} 
	
	@SuppressWarnings("deprecation")
    public Task findTaskById(Long id) { 
		return taskRepository.getById(id); 
	} 
	
	public List<Task> findAllCompletedTask() { 
		return taskRepository.findByCompletedTrue(); 
	} 
	
	public List<Task> findAllInCompleteTask() { 
		return taskRepository.findByCompletedFalse(); 
	} 
	
	public void deleteTask(Task task ) { 
		taskRepository.deleteById(task.getId()); 
	} 
	
	public Task updateTask(Task task) { 
		return taskRepository.save(task); 
	} 
} 
