package com.java.spring.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.productsAndCategories.models.Category;
import com.java.spring.productsAndCategories.models.Product;
import com.java.spring.productsAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	
	public List<Category> findAll(){
		return catRepo.findAll();
	}
	
	public Category save(Category  category) {
		return catRepo.save(category);
	}
	
	public List<Category> findCategoryOptions(Product product){
		return catRepo.findByProductsNotContains(product);
	}
	
	public List<Category> findCategoriesByProducts(Product product){
		return catRepo.findAllByProducts(product);
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = catRepo.findById(id);
		
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;
	}
	
//	public Category addProduct(Long catId, Long productId) {
//		
//		Category thisCategory = findById(catId);
//		
//		Product thisProduct = prodService.findById(productId);
//		
//		thisCategory.getProducts().add(thisProduct);
//		
//		return catRepo.save(thisCategory);
//	}
	
}
