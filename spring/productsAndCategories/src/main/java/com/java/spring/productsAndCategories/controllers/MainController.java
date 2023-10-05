package com.java.spring.productsAndCategories.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.productsAndCategories.models.Category;
import com.java.spring.productsAndCategories.models.Product;
import com.java.spring.productsAndCategories.services.CategoryService;
import com.java.spring.productsAndCategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private CategoryService catService;
	
	@GetMapping("/home")
	public String home(
			Model model
			) {
		model.addAttribute("products", prodService.findAll());
		model.addAttribute("categories", catService.findAll());

		return "home.jsp";
	}
	
	
//	CREATE NEW PRODUCT
	@GetMapping("/product/new")
	public String newProduct(
			@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/product/new")
	public String saveProduct(
			@Valid @ModelAttribute("product") Product product,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "newProduct.jsp";	
		}
		
		prodService.save(product);
		return "redirect:/home";
	}
	
//	CREATE NEW CATEGORY
	@GetMapping("/category/new")
	public String newCategory(
			@ModelAttribute("category") Category catergory) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/category/new")
	public String saveCategory(
			@Valid @ModelAttribute("category") Category category,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "newCategory.jsp";	
		}
		
		catService.save(category);
		
		return "redirect:/home";
	}

//	SHOW PRODUCT
	@GetMapping("/product/{id}")
	public String showProduct(
			@PathVariable("id") Long id,
			Model model) {
		
//		Send current product
		Product product = prodService.findById(id);
		model.addAttribute("product", product);
		
//		send categories that it is assigned to 
		List<Category> assignedCategories = catService.findCategoriesByProducts(product);
		model.addAttribute("assignedCategories", assignedCategories );
		
//		send categories it is not assigned to. 
		List<Category> unassignedCategories = catService.findCategoryOptions(product);
		model.addAttribute("unassignedCategories", unassignedCategories );
		
		return "showProduct.jsp";
	}
	
	
//	ADD CATEGORY TO PRODUCT
	@PostMapping("/product/{productId}")
	public String addCategoryToProduct(
			@PathVariable("productId") Long productId,
			@RequestParam("categoryId") Long categoryId
			) {
		
		prodService.addCategory(productId, categoryId);
		
		return "redirect:/product/{productId}";
	}
	
	
//	SHOW CATEGORY
	@GetMapping("/category/{id}")
	public String showCategory(
			@PathVariable("id") Long id,
			Model model) {
		
//		Send current product
		Category category = catService.findById(id);
		model.addAttribute("category", category);
		
//		send products that it is assigned to 
		List<Product> assignedProducts = prodService.findProductsByCategories(category);
		model.addAttribute("assignedProducts", assignedProducts );
		
//		send products it is not assigned to. 
		List<Product> unassignedProducts = prodService.findProductOptions(category);
		model.addAttribute("unassignedProducts", unassignedProducts );
		
		return "showCategory.jsp";
	}
	
//	ADD PRODUCT TO CATEGORY
	@PostMapping("/category/{categoryId}")
	public String addProductToCategory(
			@PathVariable("categoryId") Long categoryId,
			@RequestParam("productId") Long productId
			) {
		
		prodService.addCategory(productId, categoryId);	
		
		return "redirect:/category/{categoryId}";
	}
	
}
