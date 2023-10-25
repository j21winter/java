package com.java.spring.examAttempt1.controllers;

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

import com.java.spring.examAttempt1.models.LoginUser;
import com.java.spring.examAttempt1.models.Player;
import com.java.spring.examAttempt1.models.Team;
import com.java.spring.examAttempt1.models.User;
import com.java.spring.examAttempt1.services.PlayerService;
import com.java.spring.examAttempt1.services.TeamService;
import com.java.spring.examAttempt1.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
// !!!!!!!!!!!!!!! CONNECTED FILES !!!!!!!!!!!!!!!!!

	@Autowired
	private UserService userService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private PlayerService playerService;

// !!!!!!!!!!!!!!! LOGIN AND REGISTRATION !!!!!!!!!!!!!!!!!

//LOGIN PAGE
	@GetMapping("/")
	public String loginPage(
			Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		
		return "login.jsp";
	}
	
//REGISTRATION
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
	
// !!!!!!!!!!!!!!! PAGE ROUTES !!!!!!!!!!!!!!!!!

// !!!!!!!!!!!!!!! GET MAPPING !!!!!!!!!!!!!!!!!
	
//DASHBOARD
	@GetMapping("/home")
	public String home(
			HttpSession session,
			Model model) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
//		find logged in user and attach to model
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		
//		SEND IN LIST OF All TEAMS
		model.addAttribute("allTeams", teamService.findAll());
		
		return "home.jsp";
	}
	
//ADD A NEW TEAM
	@GetMapping("/teams/new")
	public String newTeam(
			@ModelAttribute("team") Team team,
			HttpSession session
			) {
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		return "newTeam.jsp";
	}

//EDIT TEAM
	@GetMapping("/teams/{teamId}/edit")
	public String editTeam(
			@PathVariable("teamId") Long teamId,
			Model model,
			HttpSession session) {
		
//				check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Team team = teamService.findById(teamId);
		model.addAttribute("team", team);
		
		return "editTeam.jsp";
	}

//SHOW TEAM
	@GetMapping("/teams/{teamId}/show")
	public String showTeam(
			@PathVariable("teamId") Long teamId,
			@ModelAttribute("player") Player player,
			Model model, 
			HttpSession session) {
//			check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		
		model.addAttribute(user);
		
		Team team = teamService.findById(teamId);
		model.addAttribute(team);
		
		return "showTeam.jsp";
	}

// !!!!!!!!!!!!!!! POST MAPPING !!!!!!!!!!!!!!!!!
	
//ADD TEAM
	@PostMapping("/teams/new")
	public String saveTeam(
			@Valid @ModelAttribute("team") Team team,
			BindingResult result,
			HttpSession session) {
		
//			check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
//			Assign the user to the team
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		team.setUser(user);
		
//			Set the team level to a number
		team.setSkillLevel(Integer.valueOf(team.getSkillLevel()));
		
//			Call the save method
		teamService.saveTeam(team, result);
		
//			Check for errors
		if(result.hasErrors()) {
			return "newTeam.jsp";		
		}
		
		
		return "redirect:/home";
	}
	
//ADD PLAYER
	@PostMapping("/team/{teamId}/addPlayer")
	public String addPlayer(
			@Valid @ModelAttribute("player") Player player,
			BindingResult result,
			@PathVariable("teamId") Long teamId,
			HttpSession session,
			Model model
			) {
		

//			check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		Team team = teamService.findById(teamId);
		
		if(result.hasErrors()) {
			model.addAttribute(user);
			model.addAttribute(team);
			return "showTeam.jsp";
			}
		

		if(userId != team.getUser().getId() ) {
			return "redirect:/teams/{teamId}/show";
		}
		
		
		player.setTeam(team);
		

		playerService.savePlayer(player, result);
		

		if(result.hasErrors()) {
			model.addAttribute(user);
			model.addAttribute(team);
			return "showTeam.jsp";
			}
		
		return "redirect:/teams/{teamId}/show";
	}

// !!!!!!!!!!!!!!! PUT MAPPING !!!!!!!!!!!!!!!!!

//UPDATE TEAM
	@PutMapping("/teams/{id}")
	public String updateTeam(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("team") Team team,
			BindingResult result,
			HttpSession session,
			Model model) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
//		Assign the user to the team
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		team.setUser(user);
		
//		Set the team level to a number
		team.setSkillLevel(Integer.valueOf(team.getSkillLevel()));
		
//		Call the save method
		teamService.updateTeam(team, result);
		
//		Check for errors
		if(result.hasErrors()) {
			model.addAttribute("team", team);
			return "editTeam.jsp";		
		}
		
		return "redirect:/teams/{id}/show";
	}

// !!!!!!!!!!!!!!! DELETE MAPPING !!!!!!!!!!!!!!!!!

//DELETE PLAYER
	@DeleteMapping("/players/{playerId}/{teamId}")
	public String removePlayer(
			@PathVariable("playerId") Long playerId,
			HttpSession session) {
		
	//	check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Player player = playerService.findById(playerId);
		
		
		player.setTeam(null);
		
		playerService.updatePlayer(player);
		
		playerService.deletePlayer(player);
		
	
		return "redirect:/teams/{teamId}/show";
	}
	
//DELETE TEAM
	@DeleteMapping("/teams/{id}")
	public String deleteTeam(
			@PathVariable("id") Long id
			) {
		
		Team team = teamService.findById(id);
		
		for(Player player : team.getPlayers()) {
			player.setTeam(null);
		}
		
		team.setUser(null);
		
		teamService.updateTeamSimple(team);
		
		teamService.deleteTeam(id);
		return "redirect:/home";
	}
	
	
}
