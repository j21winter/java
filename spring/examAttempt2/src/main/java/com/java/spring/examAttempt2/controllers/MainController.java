package com.java.spring.examAttempt2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.examAttempt2.models.LoginUser;
import com.java.spring.examAttempt2.models.Song;
import com.java.spring.examAttempt2.models.User;
import com.java.spring.examAttempt2.services.SongService;
import com.java.spring.examAttempt2.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

// !!!!!!!!!!!!!!! CONNECTED FILES !!!!!!!!!!!!!!!!!

	@Autowired
	private UserService userService;
	
	@Autowired
	private SongService songService;
	
// !!!!!!!!!!!!!!! LOGIN AND REGISTRATION !!!!!!!!!!!!!!!!!

//LOGIN PAGE
	@GetMapping("/")
	public String loginPage(
			Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		
		return "login.jsp";
	}
	
//REGISTRATION
	
	@PostMapping("/user/register")
	public String registerUser(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {
//		Call register
		User user = userService.registerUser(newUser, result);
	
//		Check for errors
		if(result.hasErrors()) {
//			Return page with errors
			model.addAttribute("loginUser", new LoginUser());
			return "login.jsp";
		}
		
//		Set userId to session
		session.setAttribute("userId", user.getId());
		
//		redirect to the home page
		return "redirect:/home";
	}
	
//		LOGIN
	@PostMapping("/user/login")
	public String login(
			@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		User user = userService.login(loginUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/home";
	}
	
//		LOGOUT
	@GetMapping("/logout")
	public String logout(
			HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}

// !!!!!!!!!!!!!!! PAGE ROUTES !!!!!!!!!!!!!!!!!
// !!!!!!!!!!!!!!! GET MAPPING >>>>>>>>>>>>>>>>>

//DASHBOARD
	@GetMapping("/home")
	public String home(
			HttpSession session,
			Model model) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
//		find logged in user and attach to model
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		
//		SEND IN LIST OF All songs
		model.addAttribute("allSongs", songService.findAll());
		
		return "home.jsp";
	}

//NEW SONG
	@GetMapping("/songs/new")
	public String songsNew(
			@ModelAttribute("song") Song song,
			HttpSession session ) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		return "newSong.jsp";
	}

//EDIT SONG
	@GetMapping("/songs/{id}/edit")
	public String editSong(
			HttpSession session,
			@PathVariable("id") Long id, 
			Model model) {

//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long)session.getAttribute("userId");
		User user = userService.findById(userId);
		Song song = songService.findById(id);
		Boolean isCollaborator = false;
		
		if(song.getCollaborators().contains(user)) {
			isCollaborator = true;
		}
		model.addAttribute("isCollaborator", isCollaborator);
		model.addAttribute("song", song);
		

		return "editSong.jsp";
	}

//SHOW SONG
	@GetMapping("/songs/{id}/show")
	public String showSong(
			HttpSession session,
			@PathVariable("id") Long id, 
			Model model) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
				
		model.addAttribute("song", songService.findById(id));
		
		return "showSong.jsp";
	}
	
// !!!!!!!!!!!!!!! POST MAPPING >>>>>>>>>>>>>>>>>

//ADD SONG
	@PostMapping("/songs/new")
	public String createSong(
			@Valid @ModelAttribute("song") Song song,
			BindingResult result, 
			HttpSession session) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		song.setUser(user);
		
//		call the register method
		songService.saveSong(song, result);
		
//		check for errors
		if(result.hasErrors()) {
			return "newSong.jsp";
		}
		
		return "redirect:/home";
	}
	
// !!!!!!!!!!!!!!! PUT MAPPING >>>>>>>>>>>>>>>>>
//UPDATE SONG
	@PutMapping("/songs/{id}")
	public String updateSong(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("song") Song song,
			BindingResult result,
			HttpSession session,
			Model model) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		Song existingSong = songService.findById(id);
		
		song.setUser(user);
		song.setId(id);
		List<User> collaborators = existingSong.getCollaborators();
		
		song.setCollaborators(collaborators);
		
		songService.updateSong(song, result);
		
//		check for errors
		if(result.hasErrors()) {			
			return "editSong.jsp";
		}
		
		return "redirect:/songs/{id}/show";
	}
	
//COLLABORATE SONG
	@PutMapping("/songs/{id}/collaborate")
	public String collabSong(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("song") Song song,
			BindingResult result,
			@RequestParam("addLyrics") String addLyrics,
			HttpSession session,
			Model model) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
			
//		find the song version that is exiting in the db
		Song existingSong = songService.findById(id);
		
//		assign variables to the song object
//		set the id from path variable
		song.setId(id);
		
//		set the user
		song.setUser(existingSong.getUser());
		
//		set the new lyrics
//			concatenate the new lyrics with the old lyrics
		String newLyrics = existingSong.getLyrics() + " " + addLyrics;
		song.setLyrics(newLyrics);
		
//		set relationships
		List<User> collaborators = existingSong.getCollaborators();
		song.setCollaborators(collaborators);
		song.setCollaborationNumber(existingSong.getCollaborationNumber() + 1);

//		Calling songUpdate
		songService.updateSong(song, result);
		
		
//		check for errors
		if(result.hasErrors()) {			
			Boolean isCollaborator = true;
			
			model.addAttribute("isCollaborator", isCollaborator);
			model.addAttribute("song", song);
			return "editSong.jsp";
		}

		return "redirect:/songs/{id}/show";
	}

// !!!!!!!!!!!!!!! DELETE MAPPING >>>>>>>>>>>>>>>>>
	
	@DeleteMapping("/songs/{id}")
	public String deleteSong(
			@PathVariable("id") Long id,
			HttpSession session) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Song song = songService.findById(id);
//		nullify relationships
		song.setUser(null);
		songService.updateSongSimple(song);
		
		for(User user : song.getCollaborators()) {
			user.getCollaborations().remove(song);
			userService.updateUser(user);
		}
		
		
		songService.deleteSong(id);
		
		return "redirect:/home";
	}

// !!!!!!!!!!!!!!! REQUEST MAPPING >>>>>>>>>>>>>>>>>
	
//ADD COLLABORATOR
	@RequestMapping("/songs/{songId}/contribute")
	public String addCollaborator(
			@PathVariable("songId")Long songId, 
			HttpSession session) {
		
//		check if user is logged in.
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = ((Long)session.getAttribute("userId"));
		User user = userService.findById(userId);
		Song song = songService.findById(songId);
		
		if(song.getCollaborators().contains(user)) {
			return "redirect:/songs/{songId}/edit";
		}
		if(user == song.getUser()) {
			return "redirect:/songs/{songId}/edit";
		}
		

		user.getCollaborations().add(song);

		userService.updateUser(user);
		
		return "redirect:/songs/{songId}/edit";
		
	}

}
