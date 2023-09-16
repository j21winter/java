package com.java.spring.omikujiForm.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session) {
		if(session.getAttribute("number") == null) {
			return "index.jsp";
		}
		return "show.jsp";
		}
	
	@PostMapping("/submitForm")
	public String submit(
			@RequestParam(value="number") String number,
			@RequestParam(value="city") String city,
			@RequestParam(value="personName") String personName,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="somethingNice") String somethingNice,
			HttpSession session) {
	
		HashMap<String, String> data = new HashMap<String, String>();
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("personName", personName);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("somethingNice", somethingNice);
		
		return "redirect:/omikuji/show";
	}
}
