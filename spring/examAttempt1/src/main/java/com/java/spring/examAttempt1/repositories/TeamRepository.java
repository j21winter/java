package com.java.spring.examAttempt1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.examAttempt1.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	
//	!!!!!!!!!!!!!! READ !!!!!!!!!!!!!!!!!!

	List<Team> findAll();
	
	Optional<Team> findByName(String name);
}
