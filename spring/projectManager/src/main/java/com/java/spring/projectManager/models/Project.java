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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty( message = "Title name must not be empty")
	@Size(min = 3, max = 50, message = "Title name must be between 3-50 characters")
	private String title;
	
	@NotEmpty( message = "Description name must not be empty")
	@Size(min = 3, max = 255, message = "Description name must be between 3-255 characters")
	private String description;
	
	@NotNull
	@Future(message = "Due Date must not be in the past!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="team_lead_id")
	private User teamLead;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "project_members",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> projectMembers;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	@PrePersist
	protected void onCreate() {
	this.createdAt = new Date();
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@PreUpdate
	protected void onUpdate() {
	this.updatedAt = new Date();
	}

	public Project() {}

//	public Project(String title, String description, Date dueDate, User teamLead) {
//		this.title = title;
//		this.description = description;
//		this.dueDate = dueDate;
//		this.teamLead = teamLead;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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

	public User getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(User teamLead) {
		this.teamLead = teamLead;
	}

	public List<User> getProjectMembers() {
		return projectMembers;
	}

	public void setProjectMembers(List<User> projectMembers) {
		this.projectMembers = projectMembers;
	}
    	
    	
    	
}
