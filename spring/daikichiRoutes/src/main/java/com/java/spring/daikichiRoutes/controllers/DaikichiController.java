package com.java.spring.daikichiRoutes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/daikichi")
public class DaikichiController {
	@GetMapping("")
	public String welcome() {
		return "Welcome";
	}
	
	@GetMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors! ";
	}
	
	@GetMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas! ";
	}
	
	@GetMapping("/travel/{location}")
	public String travel(@PathVariable("location") String location) {
		return "Congratulations. You will soon travel to " + location;
	}
	
	@GetMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") String number) {
		int numberInt = Integer.parseInt(number);
		if(numberInt % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
}
