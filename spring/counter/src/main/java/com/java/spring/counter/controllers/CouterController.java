package com.java.spring.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class CouterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		// Increment the counter here once each visit
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		}else {
			session.setAttribute("count",((int) session.getAttribute("count") + 1));
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
	
	@RequestMapping("/counter2")
	public String counter2(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 2);
		}else {
			session.setAttribute("count",((int) session.getAttribute("count") + 2));
		}
		return "counter2.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);		
		return "redirect:/counter";
	}

}
