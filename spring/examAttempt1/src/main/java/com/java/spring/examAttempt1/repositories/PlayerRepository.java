package com.java.spring.examAttempt1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.examAttempt1.models.Player;
import com.java.spring.examAttempt1.models.Team;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>{
	
//	!!!!!!!!!!!!!! READ !!!!!!!!!!!!!!!!!!

	List<Player> findAll();
	
	List<Player> findAllByTeam(Team team);
}
