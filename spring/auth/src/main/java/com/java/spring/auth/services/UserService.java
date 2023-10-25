package com.java.spring.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.spring.auth.models.User;
import com.java.spring.auth.repositories.RoleRepository;
import com.java.spring.auth.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
//	1
	public void saveWithUserRole(User user) {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		userRepo.save(user);
	}
	
//	2
	public void saveWithUserAdminRole(User user) {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
		userRepo.save(user);
	}
	
//	3
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
}
