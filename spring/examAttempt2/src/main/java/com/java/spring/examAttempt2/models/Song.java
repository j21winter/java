package com.java.spring.examAttempt2.models;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="songs")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty( message = "Title name must not be empty")
	@Size(min = 3, max = 50, message = "Title name must be between 3-50 characters")
	private String title;
	
	@NotEmpty( message = "Genre name must not be empty")
	@Size(min = 3, max = 50, message = "Genre name must be between 3-50 characters")
	private String genre;
	
	@NotEmpty( message = "Lyrics name must not be empty")
	@Size(min = 3, message = "Lyrics name must be more than 3 characters")
	private String lyrics;
	
	private Integer collaborationNumber = 0;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "collaborators",
			joinColumns = @JoinColumn(name = "song_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> collaborators;
	
	
	@PrePersist
	protected void onCreate() {
	this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
	this.updatedAt = new Date();
	}
	
	public Song() {}

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(List<User> collaborators) {
		this.collaborators = collaborators;
	}

	public Integer getCollaborationNumber() {
		return collaborationNumber;
	}

	public void setCollaborationNumber(Integer collaborationNumber) {
		this.collaborationNumber = collaborationNumber;
	}

	

	
	
	
}
