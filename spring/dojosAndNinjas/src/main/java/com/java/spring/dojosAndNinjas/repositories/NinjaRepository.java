package com.java.spring.dojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.java.spring.dojosAndNinjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
