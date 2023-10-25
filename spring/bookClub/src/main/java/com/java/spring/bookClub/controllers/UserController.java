package com.java.spring.bookClub.controllers;


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

import com.java.spring.bookClub.models.Book;
import com.java.spring.bookClub.models.LoginUser;
import com.java.spring.bookClub.models.User;
import com.java.spring.bookClub.services.BookService;
import com.java.spring.bookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String loginPage(
			@ModelAttribute("newUser") User newUser, 
			@ModelAttribute("loginUser") LoginUser loginUser 
			) {
		return "loginPage.jsp";
	}

//	REGISTER USER//	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model, 
			HttpSession session) {
		
		User user = userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "loginPage.jsp";		
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/books";
		
	}
	
//	LOGIN USER
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result,
			Model model, 
			HttpSession session) {
		
		User user = userService.login(loginUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "loginPage.jsp";		
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/books";
		
	}
	
//	DASHBOARD FOR LOGGED IN USERS
//	PROTECTED WITH SESSION
	@GetMapping("/books")
	public String dashboard(
			HttpSession session,
			Model model
			
			) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		model.addAttribute("books", bookService.findAll());
		
		return "dashboard.jsp";
	}
	
//	LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	ADD A NEW BOOK
	@GetMapping("/books/new")
	public String newBooks(
			@ModelAttribute("book") Book book
			) {
		
		return "newBook.jsp";
	}
	
	@PostMapping("/books/save")
	public String createBook(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		
		bookService.save(book);
		
		return "redirect:/books";
	}
	
//	VIEW A BOOK
	@GetMapping("/books/{id}")
	public String viewBook(
			@PathVariable("id") Long id, 
			Model model
			) {
		model.addAttribute("book", bookService.findById(id));
		return "viewBook.jsp";
	}
	
//	DELETE A BOOK
	@DeleteMapping("/books/{id}/delete")
	public String deleteBook(
			@PathVariable("id") Long id
			) {
		
		bookService.deleteBook(id);
		
		return "redirect:/books";
	}

//	UPDATE BOOK
	@GetMapping("/books/{id}/update")
	public String editBook(
			@PathVariable("id") Long id,
			Model model) {
		
		model.addAttribute("book", bookService.findById(id));
		
		return "editBook.jsp";
	}
	
	@PutMapping("/books/{bookId}/update")
	public String updateBook(
			@PathVariable("bookId") Long bookId,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			HttpSession session
			) {
		
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		
//		Book existingBook = bookService.findById("bookId");
		Long userId = (Long)session.getAttribute("userId");
		User user = userService.findById(userId);
		
		book.setId(bookId);
		book.setUser(user);
		
		
		
		bookService.updateBook(book);
		
		
		return "redirect:/books/{bookId}";
	}
	
	@GetMapping("/books/{bookId}/borrow")
	public String borrowBook(
			@PathVariable("bookId") Long bookId,
			HttpSession session
			) {
		
		Book book = bookService.findById(bookId);
		book.setBorrower(userService.findById((Long)session.getAttribute("userId")));
		bookService.updateBook(book);
		
		return "redirect:/books";
	}
	
	@GetMapping("/books/{bookId}/return")
	public String returnBook(
			@PathVariable("bookId") Long bookId
			) {
		Book book = bookService.findById(bookId);
		book.setBorrower(null);
		bookService.updateBook(book);

		return "redirect:/books";
	}
	
}

