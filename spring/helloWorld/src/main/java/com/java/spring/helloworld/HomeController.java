package com.java.spring.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Class Annotations are cool too! ";
	}
}
 