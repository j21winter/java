package com.java.spring.dojosAndNinjas.repositories;

import com.java.spring.dojosAndNinjas.models.Dojo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
	
	Optional<Dojo> findById(Long id);
}
