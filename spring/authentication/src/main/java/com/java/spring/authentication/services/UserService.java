package com.java.spring.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.java.spring.authentication.models.LoginUser;
import com.java.spring.authentication.models.User;
import com.java.spring.authentication.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {

		//	CHECK IF EMAIL IS UNIQUE
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "The email you entered is already in use!");
			return null;
		}
		
		//	CHECK IF PASSWORDS MATCH
		if(!newUser.getPassword().equals(newUser.getConfirm())){
			result.rejectValue("confirm", "Matches", "The confirmed password must match Password!");
			return null;
		}
		
		// ABORT AND RETURN NULL IF ERRORS OCCUR
		if(result.hasErrors()) return null;
		
		// ELSE REGISTER THE USER
		String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		
		newUser.setPassword(hashedPassword);
		
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
		
//		CHECK IF EMAIL IS UNIQUE
			Optional<User> potentialUser = userRepo.findByEmail(loginUser.getEmail());
			if(potentialUser.isEmpty()) {
				result.rejectValue("email", "unique", "Invalid credentials");
				return null;
			}
			
			User user = potentialUser.get();
			
			//	CHECK IF PASSWORDS MATCH
			if (!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
				result.rejectValue("password", "noMatch", "Incorrect password.");
			}

			
			// ABORT AND RETURN NULL IF ERRORS OCCUR
			if(result.hasErrors()) return null;
			
			return user;
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isEmpty()) {
			return null;
		}
		return optionalUser.get();
	}
}
