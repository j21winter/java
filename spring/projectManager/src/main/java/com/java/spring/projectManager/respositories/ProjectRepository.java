package com.java.spring.projectManager.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.java.spring.projectManager.models.Project;
import com.java.spring.projectManager.models.User;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
	
	List<Project> findByProjectMembersNotContains(User user);
	
	List<Project> findAllByProjectMembers(User user);
}
