package com.java.spring.burgerTracker.controllers;

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
import com.java.spring.burgerTracker.models.Burger;
import com.java.spring.burgerTracker.services.BurgerService;


import jakarta.validation.Valid;
//convert to restful routing conventions
@Controller
public class BurgerController {
	
	// Instantiate service file for functionality
	@Autowired
	private BurgerService burgerService;
	
	//Routes
	
	//Dashboard
	@GetMapping("/")
	public String dashboard(@ModelAttribute("burger") Burger burger,Model model) {
		model.addAttribute("burgers", burgerService.allBurgers() );
		
		return "dashboard.jsp";
	}
	
	//Adding a new burger
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
	
	// Edit burger page
	@GetMapping("/burger/show/{id}")
	public String editBurgerForm(@ModelAttribute("burger") Burger burger,Model model, @PathVariable("id") Long id) {
		model.addAttribute("burger", burgerService.findBurger(id));
		return "editBurger.jsp";
	}

	@PutMapping("/burger/{id}")
	public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("burgers", burgerService.allBurgers() );
			
			return "dashboard.jsp";
		} else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}

	}
	
	
	@DeleteMapping("/burger/{id}")
    public String destroy(@PathVariable("id") Long id) {
        burgerService.deleteBurger(id);
        return "redirect:/";
	}
}
