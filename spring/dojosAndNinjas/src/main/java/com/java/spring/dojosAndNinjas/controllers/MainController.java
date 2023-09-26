package com.java.spring.dojosAndNinjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.spring.dojosAndNinjas.models.Dojo;
import com.java.spring.dojosAndNinjas.models.Ninja;
import com.java.spring.dojosAndNinjas.services.DojoService;
import com.java.spring.dojosAndNinjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	
	
	@GetMapping("/dojos/new")
	public String newDojo(
			@ModelAttribute("dojo") Dojo dojo,
			Model model) {
		
		model.addAttribute("dojos", dojoService.findAll());
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.findAll());
			
			return "newDojo.jsp";
		}
		
		dojoService.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@GetMapping ("/ninjas/new")
	public String newNinja(
			@ModelAttribute("ninja") Ninja ninja,
			Model model
			) {
		model.addAttribute("allDojos", dojoService.findAll());
		return "newNinja.jsp";
	}
	
	@PostMapping("ninjas")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			Model model,
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoService.findAll());
			return "newNinja.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(
			@PathVariable("id") Long id,
			Model model) {
		
		model.addAttribute("dojo", dojoService.findById(id));
		return "dojo.jsp";
	}
	
	
	
	
	

}
