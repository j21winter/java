package com.java.spring.examAttempt2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.java.spring.examAttempt2.models.Song;
import com.java.spring.examAttempt2.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepo;
	
//!!!!!!!!!! CREATE !!!!!!!!!!!!
	//CREATE NEW SONG (CREATE)
	public Song saveSong(Song song, BindingResult result) {
		
//		Check if the song title has been taken
		Optional<Song> optionalSong = songRepo.findByTitle(song.getTitle());
		
//		add error message
		if(optionalSong.isPresent()) {
			result.rejectValue("title", "NotUnique", "Title already in use please choose a unique title!");
		}
		
//		check for errors
		if(result.hasErrors()) {
			return null;
		}
		
//		save the team
		return songRepo.save(song);
	}
	
	
//!!!!!!!!!! READ !!!!!!!!!!!!
	//FIND ALL USERS
	public List<Song> findAll(){
		return songRepo.findAll();
	}
	
	//FIND BY ID
	public Song findById(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		
		if(optionalSong.isEmpty()) {
			return null;
		}
		return optionalSong.get();
	}

//!!!!!!!!!! UPDATE !!!!!!!!!!!!
	//UPDATE SONG
	public Song updateSong(Song song, BindingResult result) {
		
//		Check if the team name has been taken
		Optional<Song> optionalSong = songRepo.findByTitle(song.getTitle());
		
		if(optionalSong.isPresent()) {
			Song existingSong = optionalSong.get();
			if(!song.getId().equals(existingSong.getId())) {
				result.rejectValue("title", "NotUnique", "Title Name already in use please choose a unique Title!");
			}
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		return songRepo.save(song);
	}
	
//	UPDATE SIMPLE
	public Song updateSongSimple(Song song) {
		return songRepo.save(song);
	}

//!!!!!!!!!! DELETE !!!!!!!!!!!!
	//DELETE USER
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}



}
