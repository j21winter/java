package com.java.spring.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.productsAndCategories.models.Category;
import com.java.spring.productsAndCategories.models.Product;
import com.java.spring.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryService catService;
	
	public List<Product> findAll() {
		return productRepo.findAll();
	}
	
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	public Product findById(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public List<Product> findProductsByCategories(Category category){
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> findProductOptions(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public Product addCategory(Long productId, Long catId) {
		
		Category thisCategory = catService.findById(catId);
		
		Product thisProduct = findById(productId);
		
		thisProduct.getCategories().add(thisCategory);
		
		return productRepo.save(thisProduct);
	}
}
