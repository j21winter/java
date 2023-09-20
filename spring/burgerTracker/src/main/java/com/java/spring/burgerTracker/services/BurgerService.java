package com.java.spring.burgerTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.spring.burgerTracker.models.Burger;
import com.java.spring.burgerTracker.repository.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	
	public BurgerService( BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	//Returns all burgers
	public List<Burger>allBurgers(){
		return burgerRepository.findAll();
	}
	
	// finds burgers if they exist
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		}
		return null;

	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
	}
	
	
	
	
}
