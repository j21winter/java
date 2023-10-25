package com.java.spring.examAttempt2.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.java.spring.examAttempt2.models.LoginUser;
import com.java.spring.examAttempt2.models.User;
import com.java.spring.examAttempt2.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepo;
	
//!!!!!!!!!! CREATE !!!!!!!!!!!!
//REGISTER
	public User registerUser(User user, BindingResult result) {
		
//		Check if email is unique
		Optional<User> optionalUser = userRepo.findByEmail(user.getEmail());
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "notUnique", "Email alread in use please try loggin in or select new email.");
		}
		
//		Check if passwords match
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("Password", "matchFail", "Passwords do not match.");
		}
		
//		Check against errors
		if(result.hasErrors()) {
//			return null
			return null;
		}
		
//		Hash the password
		String HashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

//		Set the password	
		user.setPassword(HashedPassword);	
		
//		Save the user
		return userRepo.save(user);
	}

//LOGIN
	public User login(LoginUser loginUser, BindingResult result) {
		
//		Check if user email exists
		Optional<User> optionalUser = userRepo.findByEmail(loginUser.getEmail());
		if(optionalUser.isEmpty()) {
			result.rejectValue("email", "invalidLogin", "Invalid login credentials");
			return null;
		}
		
//		Instantiate user
		User user = optionalUser.get();
		
//		Hash the loginUser password and check that it matches the user password of the user if they were found
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "invalidLogin", "Invalid password");
		}
		
		if(result.hasErrors()) return null;
		
		return user;
		
	}

//!!!!!!!!!! READ !!!!!!!!!!!!
//FIND ALL USERS
	public List<User> findAll(){
		return userRepo.findAll();
	}

//FIND BY ID
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		
		if(optionalUser.isEmpty()) {
			return null;
		}
		return optionalUser.get();
	}

//!!!!!!!!!! UPDATE !!!!!!!!!!!!
//UPDATE USER
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
//!!!!!!!!!! DELETE !!!!!!!!!!!!
//DELETE USER
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
}
