package com.java.spring.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.spring.saveTravels.models.Expense;
import com.java.spring.saveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> findAll(){
		return expenseRepository.findAll();
		
	}
	
	public void createExpense(Expense expense) {
		expenseRepository.save(expense);
	}
	
	public void updateExpense(Expense expense) {
		expenseRepository.save(expense);
	}
	
	public Expense findById(Long id) {
				
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		
		return null;
	}
	
	public void deleteById(Long id) {
		expenseRepository.deleteById(id);
	}
}
