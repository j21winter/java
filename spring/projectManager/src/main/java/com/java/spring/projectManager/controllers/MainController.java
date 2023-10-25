package com.java.spring.projectManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring.projectManager.models.LoginUser;
import com.java.spring.projectManager.models.Project;
import com.java.spring.projectManager.models.Task;
import com.java.spring.projectManager.models.User;
import com.java.spring.projectManager.services.ProjectService;
import com.java.spring.projectManager.services.TaskService;
import com.java.spring.projectManager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
//!!!!!!!!!!!! LOGIN & REG !!!!!!!!!!!!!!!
	
//	REGISTRATION
	@GetMapping("/")
	public String loginPage(
			Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		
		return "login.jsp";
	}
	
	@PostMapping("/user/register")
	public String registerUser(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		
//		Call register
		User user = userService.registerUser(newUser, result);
	
//		Check for errors
		if(result.hasErrors()) {
//			Return page with errors
			model.addAttribute("loginUser", new LoginUser());
			return "login.jsp";
		}
		
//		Set userId to session
		session.setAttribute("userId", user.getId());
		
//		redirect to the home page
		return "redirect:/home";
	}	
//	LOGIN
	
	@PostMapping("/user/login")
	public String login(
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		User user = userService.login(loginUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/home";
	}
	
//	LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
//	!!!!!!!!! DASHBOARD !!!!!!!!!!!!!!
	
//	Dashboard Route
	
	@GetMapping("/home")
	public String home(
			HttpSession session,
			Model model) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
//		find logged in user and attach to model
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		
//		SEND IN LIST OF PROJECTS THEY ARE NOT PART OF 
		model.addAttribute("possibleProjects", projectService.findPossibleProjects(user));
		
//		SEND IN LIST OF PROJECTS THEY ARE A PART OF
		model.addAttribute("myProjects", projectService.findMyProjects(user));
		
		return "home.jsp";
	}
	
//	ADD NEW PROJECT
	@GetMapping("/projects/new")
	public String newProject(
			@ModelAttribute("project") Project project,
			HttpSession session) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		
		return "newProject.jsp";
	}
	
	@PostMapping("/projects/new")
	public String saveProject(
			@Valid @ModelAttribute("project") Project project,
			BindingResult result,
			HttpSession session) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
//		check for errors
		if(result.hasErrors()) {
			return "newProject.jsp";
		}
		
		
//		find the user from session
		Long userId = ((Long) session.getAttribute("userId"));
		User user = userService.findById(userId);
		
//		set user as the project team lead
		project.setTeamLead(user);
//		save the project
		Project newProject = projectService.createProject(project);
		
//		Add the to user in the many to many relationship list
		user.getMemberOnProjects().add(newProject);
		
//		Save the changes to the project
		userService.updateUser(user);
//		
		
		return "redirect:/home";
	}
	
//	EDIT PROJECT
	@GetMapping("/projects/{id}/edit")
	public String editProject(
			@PathVariable("id") Long id,
			Model model){
		Project project = projectService.findById(id);
		model.addAttribute("project", project);
		return "editProject.jsp";
	}
	
	@PutMapping("/projects/{projectId}")
	public String updateProject(
			@PathVariable("projectId") Long projectId,
			@Valid @ModelAttribute("project") Project project, 
			BindingResult result,
			HttpSession session) {
		
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}

//		find the user in session 
		Long userId = ((Long) session.getAttribute("userId"));
		User user = userService.findById(userId);
		
//		check for errors
		if(result.hasErrors()) {
			return "newProject.jsp";
		}
		
//		set project variables
		Project existingProject = projectService.findById(projectId);
		
//		Set project id
		project.setId(projectId);
//		Set teamLead
		project.setTeamLead(user);
		
//		Set user connections to the project
		List<User> projectMembers = existingProject.getProjectMembers();
		for(User member:projectMembers) {
			member.getMemberOnProjects().add(project);		
		}
		
//		Update the project
		projectService.updateProject(project);
		
		return "redirect:/home";
		
	}
	
// 	DELETE PROJECT
	@DeleteMapping("/projects/{id}")
	public String deleteProject(
			@PathVariable("id")Long id, 
			HttpSession session) {
	
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
//		find project by id
		Project project = projectService.findById(id);
		
//		Nullify all relationships
		project.setTeamLead(null);
		for(User member:project.getProjectMembers()) {
			member.getMemberOnProjects().remove(project);
			userService.updateUser(member);
		}
		
		projectService.deleteById(id);
		
		return "redirect:/home";

	}
	
//	JOIN TEAM 
	@RequestMapping("/projects/{projectId}/join")
	public String joinTeam(
			@PathVariable("projectId") Long projectId,
			HttpSession session) {
		
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long)session.getAttribute("userId");
		User user = userService.findById(userId);
		
		Project project = projectService.findById(projectId);
		
//		project.getProjectMembers().add(user);
		user.getMemberOnProjects().add(project);
		
		userService.updateUser(user);
		
		return "redirect:/home";

		
	}
	
//	LEAVE TEAM 
	@RequestMapping("/projects/{projectId}/leave")
	public String leaveTeam(
		@PathVariable("projectId") Long projectId,
		HttpSession session) {
		
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long)session.getAttribute("userId");
		User user = userService.findById(userId);
		
		Project project = projectService.findById(projectId);
		
		user.getMemberOnProjects().remove(project);

		userService.updateUser(user);

		return "redirect:/home";

	}
	
//	SHOW TEAM
	@GetMapping("/projects/{id}/show")
	public String showTeam(
			@PathVariable("id") Long id,
			HttpSession session, 
			Model model,
			@ModelAttribute("task") Task task) {
		
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("project", projectService.findById(id));
		
		
		return "showProject.jsp";
	}

// REMOVE TEAM MEMBER
	@RequestMapping("/projects/{projectId}/remove/{memberId}")
	public String removePlayer(
			@PathVariable("projectId") Long projectId,
			@PathVariable("memberId") Long memberId,
			HttpSession session) {
	
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectService.findById(projectId);
		User member = userService.findById(memberId);
		
		member.getMemberOnProjects().remove(project);
		
		userService.updateUser(member);
		
		return "redirect:/projects/{projectId}/show";
	}

// ADD A TASK
	@PostMapping("/projects/{projectId}/add_task")
	public String addTask(
			@PathVariable("projectId") Long id,
			@Valid @ModelAttribute("Task") Task task, 
			BindingResult result, 
			Model model,
			HttpSession session) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectService.findById(id);
		
		if(result.hasErrors()) {
			model.addAttribute(project);
			return "showProject.jsp";
		}
		
		Long userId = (Long)session.getAttribute("userId");
		User user = userService.findById(userId);
		
		task.setUser(user);
		task.setProject(project);
		
		taskService.createTask(task);
		
		return "redirect:/projects/{projectId}/show";
	}

// COMPLETE A TASK
	@RequestMapping("/projects/{projectId}/task/{taskId}/complete")
	public String completeTask(
			@PathVariable("taskId") Long taskId,
			@PathVariable("projectId") Long projectId,
			HttpSession session,
			Model model) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Task task = taskService.findById(taskId);
		
		task.setComplete(true);
		
		taskService.updateTask(task);
		
		model.addAttribute("projectId", task.getProject().getId());
		
		System.out.println(model.getAttribute("projectId"));
		
		return "redirect:/projects/{projectId}/show";
	}
}
