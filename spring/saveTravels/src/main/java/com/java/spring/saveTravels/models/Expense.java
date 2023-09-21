package com.java.spring.saveTravels.models;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message = "Expense field cannot be blank!")
	@Size(min=3, max=100, message = "Vendor field must be between 3-100 characters!")
	private String expenseName;
	
	@NotNull (message = "Vendor field cannot be blank!")
	@Size(min=3, max=100, message = "Vendor field must be between 3-100 characters!")
	private String vendorName;
	
	@NotNull (message = "Amount field cannot be blank!")
	@DecimalMin(value="0.01", inclusive = true)
	private BigDecimal amount;
	
	@NotNull (message = "Vendor field cannot be blank!")
	@Size(min=3, max=300, message = "Vendor field must be between 3-300 characters!")
	private String description;
	
	@Column(updatable = false)
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
//	CONSTRCUTORS //
	public Expense() {
		
	}
	
	public Expense(
			String expenseName, 
			String vendorName, 
			BigDecimal amount, 
			String description
			) {
		this.expenseName = expenseName;
		this.vendorName = vendorName;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
}
