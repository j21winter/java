package com.java.spring.examAttempt1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.examAttempt1.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
//	!!!!!!!!!!!!!! READ !!!!!!!!!!!!!!!!!!

	List<User> findAll();
	
	Optional<User> findByEmail(String email);
}
