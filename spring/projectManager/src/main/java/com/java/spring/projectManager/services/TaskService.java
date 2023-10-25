package com.java.spring.projectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.projectManager.models.Project;
import com.java.spring.projectManager.models.Task;
import com.java.spring.projectManager.respositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	public List<Task> findAll(){
		return taskRepo.findAll();
	}
	
	public List<Task> findAllByProject(Project project){
		return taskRepo.findAllByProject(project);
	}
	
	public Task createTask(Task task) {
		return taskRepo.save(task);	
		}
	
	public Task findById(Long id) {
		
		Optional<Task> optTask = taskRepo.findById(id);
		
		if(optTask.isEmpty()) {
			return null;
		}
		
		return optTask.get();
	}
	
	public Task updateTask(Task task) {
		return taskRepo.save(task);
	}
}
