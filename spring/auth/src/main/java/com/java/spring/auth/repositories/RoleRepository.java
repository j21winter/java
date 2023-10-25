package com.java.spring.auth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.java.spring.auth.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	List<Role> findAll();
	
	List<Role> findByName(String name);
}
