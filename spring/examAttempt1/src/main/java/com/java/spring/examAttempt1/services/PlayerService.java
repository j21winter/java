package com.java.spring.examAttempt1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.java.spring.examAttempt1.models.Player;
import com.java.spring.examAttempt1.models.Team;
import com.java.spring.examAttempt1.repositories.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepo;

//	!!!!!!!!!!!!!! CREATE !!!!!!!!!!!!!!!!!!

//SAVE NEW PLAYER
public Player savePlayer(Player player, BindingResult result) {
		
		Team team = player.getTeam();
		List<Player> players = team.getPlayers();
		System.out.println(players.size());

		if(players.size() >= 9 ) {
			result.rejectValue("team", "size", "Team is full. Team can only have 9 players maximum!");
			return null;
		}
		
		return playerRepo.save(player);
	}
//	!!!!!!!!!!!!!! READ !!!!!!!!!!!!!!!!!!
	
//FIND ALL
	public List<Player> findAll(){
		return playerRepo.findAll();
	}
	
//FIND BY TEAM	
	public List<Player> findAllByTeam(Team team){
		return playerRepo.findAllByTeam(team);
	}
	
//FIND BY ID
	public Player findById(Long Id) {
		Optional<Player> optinalPlayer = playerRepo.findById(Id);
		
		if(optinalPlayer.isEmpty()) {
			return null;
		}
		return optinalPlayer.get();
	}
	
//	!!!!!!!!!!!!!! UPDATE !!!!!!!!!!!!!!!!!!
	
//UPDATE PLAYER	
	public Player updatePlayer(Player player) {
		return playerRepo.save(player);
	}
	
//	!!!!!!!!!!!!!! DELETE !!!!!!!!!!!!!!!!!!

//DELETE PLAYER	BY ID
	public void deletePlayer(Player player) {
		playerRepo.delete(player);
	}
	

}
