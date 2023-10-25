package com.java.spring.projectManager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty( message = "First name must not be empty")
	@Size(min = 3, max = 50, message = "First name must be between 3-50 characters")
	private String firstName;
	
	@NotEmpty( message = "Last name must not be empty")
	@Size(min = 3, max = 50, message = "Last name must be between 3-50 characters")
	private String lastName;
	
	@NotEmpty( message = "Email must not be empty")
	@Email( message = "Enter a valid email.")
	private String email;
	
	@NotEmpty ( message = "Password must not be empty")
	@Size(min = 8, max = 255, message = "Password name must be between 8-255 characters")
	private String password;
	
	@NotEmpty ( message = "Password must not be empty")
	@Transient
	@Size(min = 8, max = 255, message = "Password name must be between 8-255 characters")
	private String confirm;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy = "teamLead", fetch = FetchType.LAZY)
	private List<Project> leadProjects;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "project_members",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> memberOnProjects;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  	private List<Task> Task;
	
	@PrePersist
	protected void onCreate() {
	this.createdAt = new Date();
	}

    	@PreUpdate
    	protected void onUpdate() {
    	this.updatedAt = new Date();
    	}
    	
    	public User() {}

	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	
	

	public List<Task> getTask() {
		return Task;
	}

	public void setTask(List<Task> task) {
		Task = task;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Project> getLeadProjects() {
		return leadProjects;
	}

	public void setLeadProjects(List<Project> leadProjects) {
		this.leadProjects = leadProjects;
	}

	public List<Project> getMemberOnProjects() {
		return memberOnProjects;
	}

	public void setMemberOnProjects(List<Project> memberOnProjects) {
		this.memberOnProjects = memberOnProjects;
	}

	
    	
    	
}
