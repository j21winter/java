package com.java.spring.burgerTracker.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.java.spring.burgerTracker.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
	
	// This method searches all Burgers in our DB
	List<Burger> findAll();
}
