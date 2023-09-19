package com.java.spring.booksAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.spring.booksAPI.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{id}")
	public String getBook(Model model, @PathVariable("id")Long id) {
		
		model.addAttribute("book", bookService.findBook(id));
		
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String getall(Model model) {
		
		model.addAttribute("allBooks", bookService.allBooks());
		
		return "index.jsp";
	}
}
