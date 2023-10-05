package com.java.spring.productsAndCategories.models;

import java.math.BigDecimal;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name cannot be empty")
	@Size(min=3, max=255, message="Name must be between 3-255 characters")
	private String name;
	
	@NotEmpty(message="Description cannot be empty")
	@Size(min=3, max=255, message="Description must be between 3-255 characters")
	private String description;
	
	@NotNull (message = "Price field cannot be blank!")
	@DecimalMin(value="0.01", inclusive = true, message="Price cannot be less than 0.01")
	private BigDecimal price;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="prods_and_cats",
			joinColumns = @JoinColumn(name="product_id"),
			inverseJoinColumns = @JoinColumn(name="category_id")
			)
	private List<Category> categories;

	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }

    	@PreUpdate
    	protected void onUpdate() {
    	this.updatedAt = new Date();
    	}
    	
    	public Product() {}

	public Product(
			String name,
			String description,
			BigDecimal price) {
		
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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
