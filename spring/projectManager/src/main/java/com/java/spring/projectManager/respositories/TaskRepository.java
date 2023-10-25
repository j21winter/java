package com.java.spring.projectManager.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.projectManager.models.Project;
import com.java.spring.projectManager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	
	List<Task> findAll();
	
	List<Task> findAllByProject(Project project);
	}
