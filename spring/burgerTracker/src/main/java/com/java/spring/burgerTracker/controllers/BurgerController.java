package com.java.spring.burgerTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.spring.burgerTracker.models.Burger;
import com.java.spring.burgerTracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	
	// Instantiate service file for functionality
	@Autowired
	BurgerService burgerService;
	
	//Routes
	@GetMapping("/")
	public String dashboard(@ModelAttribute("burger") Burger burger,Model model) {
		model.addAttribute("burgers", burgerService.allBurgers() );
		
		return "dashboard.jsp";
	}
	
	@PostMapping("/formSubmit")
	public String createBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("burgers", burgerService.allBurgers() );
			
			return "dashboard.jsp";
		} else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}
	}
	

}
