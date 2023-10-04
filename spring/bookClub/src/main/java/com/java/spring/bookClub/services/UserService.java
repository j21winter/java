package com.java.spring.bookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.java.spring.bookClub.models.LoginUser;
import com.java.spring.bookClub.models.User;
import com.java.spring.bookClub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User register(User user, BindingResult result) {
		
//		CHECK FOR EMAIL 
		Optional<User> optionalUser = userRepo.findByEmail(user.getEmail());
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "inUse", "This email is already in use, please try loggin in!");
		}
		
//		CHECK PASSWORDS MATCH
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("confirm", "matchError", "Passwords do not match!");
		}
		
		if(result.hasErrors()) {
			return null;
		}
//		
//		HASH PASSWORD AND CALL REGISTER
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		
		return userRepo.save(user);
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
		
//		CHECK FOR EMAIL 
		Optional<User> optionalUser = userRepo.findByEmail(loginUser.getEmail());
		
		if(optionalUser.isEmpty()) {
			result.rejectValue("email", "notInUse", "Please enter a vaid email!");
			return null;
		}
		
		User user = optionalUser.get();
		
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "matcherror", "Invalid Password!");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		else { 
			return user;	
		}
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		
		if(optionalUser.isEmpty()) {
			return null;
		}
		
		return optionalUser.get();
	}
}
