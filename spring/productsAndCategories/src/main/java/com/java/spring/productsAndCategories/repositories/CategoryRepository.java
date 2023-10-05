package com.java.spring.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.productsAndCategories.models.Category;
import com.java.spring.productsAndCategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	List<Category> findAllByProducts(Product product);
}
