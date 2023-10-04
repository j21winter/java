package com.java.spring.bookClub.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class LoginUser {
	
	@NotEmpty(message="Email cannot be empty!")
	@Email
	private String email;
	
	@NotEmpty(message="Password cannot be empty!")
	@Size(min=8, max = 255, message="Password must be between 8-255 characters!")
	private String password;
	
	public LoginUser() {}

	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
