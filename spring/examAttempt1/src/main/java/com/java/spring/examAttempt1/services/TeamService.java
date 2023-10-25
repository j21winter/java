package com.java.spring.examAttempt1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.java.spring.examAttempt1.models.Team;
import com.java.spring.examAttempt1.repositories.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepo;


//	!!!!!!!!!!!!!! CREATE !!!!!!!!!!!!!!!!!!

//CREATE NEW TEAM (CREATE)
	public Team saveTeam(Team team, BindingResult result) {
		
//		Check if the team name has been taken
		Optional<Team> optionalTeam = teamRepo.findByName(team.getName());
		
//		add error message
		if(optionalTeam.isPresent()) {
			result.rejectValue("name", "NotUnique", "Team Name already in use please choose a unique Team name!");
		}
//		check for errors
		if(result.hasErrors()) {
			return null;
		}
		
//		save the team
		return teamRepo.save(team);
	}

//	!!!!!!!!!!!!!! READ !!!!!!!!!!!!!!!!!!
	
//FIND ALL
	public List<Team> findAll(){
		return teamRepo.findAll();
	}
//FIND BY ID (READ)
	public Team findById(Long id) {
		Optional<Team> optionalTeam = teamRepo.findById(id);
		
		if(optionalTeam.isEmpty()) {
			return null;
		}
		
		return optionalTeam.get();
	}

	
//	!!!!!!!!!!!!!! UPDATE !!!!!!!!!!!!!!!!!!
	
//UPDATE TEAM
	public Team updateTeam(Team team, BindingResult result) {
		
//		Check if the team name has been taken
		Optional<Team> optionalTeam = teamRepo.findByName(team.getName());
		
		if(optionalTeam.isPresent()) {
			Team existingTeam = optionalTeam.get();
			if(!team.getId().equals(existingTeam.getId())) {
				result.rejectValue("name", "NotUnique", "Team Name already in use please choose a unique Team name!");
			}
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		return teamRepo.save(team);
	}

//UPDATE SIMPLE
	public Team updateTeamSimple(Team team) {
		return teamRepo.save(team);
	}
	
//	!!!!!!!!!!!!!! DELETE !!!!!!!!!!!!!!!!!!

//DELETE BY ID
	public void deleteTeam(Long id) {
		teamRepo.deleteById(id);
	}
}
