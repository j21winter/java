package com.java.spring.burgerTracker.services;

import java.util.List;

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
	
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}

}
