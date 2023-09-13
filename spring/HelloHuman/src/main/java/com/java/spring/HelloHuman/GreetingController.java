package com.java.spring.HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	@RequestMapping("/")
	public String greeting(
			@RequestParam(value = "firstName", required=false) String firstName,
			@RequestParam(value = "lastName", required=false) String lastName,  
			@RequestParam(value = "times", required=false) String times) {
		int amount = 1;
		String message = "";
		if (times != null) {
			try {
				amount = Integer.parseInt(times);
				System.out.println(amount);
			}catch(Exception e){
				System.out.println(e);
				amount = 1;
			}
		}
		
		if(firstName == null && lastName == null) {
				return "Hello Human, ";				
		}
		if(firstName == null) {
			
			for(int i = 0; i < amount; i++) {
				System.out.println(lastName);
				message += "Hello " + lastName + ", ";
				System.out.println(message);
			}
		}
		if(lastName == null) {
			for(int i = 0; i < amount; i++) {
				System.out.println(firstName);
				message += "Hello " + firstName + ", ";
				System.out.println(message);
			}
		}
		else {
			for(int i = 0; i < amount; i++) {
				System.out.println(firstName);
				System.out.println(lastName);
				message += "Hello " + firstName + " " + lastName + ", ";
				System.out.println(message);
			}
		}
		return message;
	}
	
}
