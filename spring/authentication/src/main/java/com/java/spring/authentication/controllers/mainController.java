package com.java.spring.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.spring.authentication.models.LoginUser;
import com.java.spring.authentication.models.User;
import com.java.spring.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class mainController {
	
	@Autowired
	private UserService userService;
	
//	LOGIN/REGISTRATION ROUTE
	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User user,
			@ModelAttribute("newLogin") LoginUser loginUser
			){
		
		return "login.jsp";
	}
	
//	DASHBOARD ROUTE
	@GetMapping("/home")
	public String home(
			Model model, 
			HttpSession session
			) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = userService.findById((Long)session.getAttribute("userId"));
		
		model.addAttribute("user", user);
		
		return "home.jsp";
	}
	
	@PostMapping("/user/register")
	public String registerUser(
			@Valid @ModelAttribute("newUser") User user,
			BindingResult result,
			Model model, 
			HttpSession session) {
		
		User newUser = userService.register(user, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
			}
		
		session.setAttribute("userId", newUser.getId());
		return "redirect:/home";
		
	}
	
	@PostMapping("user/login")
	public String loginUser(
			@Valid @ModelAttribute("newLogin") LoginUser loginUser,
			Model model, 
			BindingResult result,
			HttpSession session) {
		
		User loggedInUser = userService.login(loginUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
			session.setAttribute("userId", loggedInUser.getId());
			return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
