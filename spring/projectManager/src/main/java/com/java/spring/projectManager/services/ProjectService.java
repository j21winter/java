package com.java.spring.projectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.projectManager.models.Project;
import com.java.spring.projectManager.models.User;
import com.java.spring.projectManager.respositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;
	
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}
	
	public List<Project> findPossibleProjects(User user){
		return projectRepo.findByProjectMembersNotContains(user);
	}
	
	public List<Project> findMyProjects(User user){
		return projectRepo.findAllByProjectMembers(user);
	}
	
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	public Project findById(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		
		if(optionalProject.isEmpty()) {
			return null;
		}
		
		return optionalProject.get();
	}
	
	public void deleteById(Long id) {
		projectRepo.deleteById(id);
	}
}
