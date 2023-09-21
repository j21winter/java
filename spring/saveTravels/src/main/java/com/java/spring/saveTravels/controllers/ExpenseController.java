package com.java.spring.saveTravels.controllers;

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

import com.java.spring.saveTravels.models.Expense;
import com.java.spring.saveTravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expense")
	public String expenseDashboard(
			Model model,
			@ModelAttribute("expense") Expense expense
			
			) {
//		Get all expenses and attach to the model so it can be used in a forEach to fill our table//
		model.addAttribute("allExpenses", expenseService.findAll());
		
		return "expenseDashboard.jsp";
	}
	
//	ADD A NEW Expense //
	@PostMapping("/expense")
	public String createNewExpense(
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model
			
			) {
		if(result.hasErrors()) {
			model.addAttribute("allExpenses", expenseService.findAll());
			return "expenseDashboard.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expense";	
	}	
	
//	Update an Expense
	@GetMapping("/expense/{id}/edit")
	public String expenseEdit(
			@PathVariable("id") Long id,
			@ModelAttribute("expense") Expense expense,
			Model model
			) {
		
		model.addAttribute("expense",expenseService.findById(id));
		
		return "expenseEdit.jsp";
	}
	
	
	@PutMapping("/expense/{id}")
	public String updateExpense(
//			@PathVariable("id") Long id,
			@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model
			) {
		
		if(result.hasErrors()) {
			model.addAttribute("expense",expense);
			
			return "expenseEdit.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/expense/" + expense.getId() + "/show";	
	}	
	
//	View an individual expense
	@GetMapping("/expense/{id}/show")
	public String expenseShow(
			@PathVariable("id") Long id,
			Model model
			) {
		
		model.addAttribute("expense", expenseService.findById(id));
		
		return "expenseShow.jsp";
	}
	
//	Delete an expense
	@DeleteMapping("/expense/{id}")
	public String destroyExpense(
			@PathVariable("id") Long id
			) {
		expenseService.deleteById(id);
		
		return "redirect:/expense";
	}
}
