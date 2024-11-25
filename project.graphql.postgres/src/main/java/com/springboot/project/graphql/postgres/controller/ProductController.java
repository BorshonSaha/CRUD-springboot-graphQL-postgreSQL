package com.springboot.project.graphql.postgres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.springboot.project.graphql.postgres.model.Product;
import com.springboot.project.graphql.postgres.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@QueryMapping
	public List<Product> getProducts() {
		return service.getProducts();
	}
	
	@QueryMapping
	public List<Product> getProductsByCategory(@Argument String category) {
		return service.getProductsByCategory(category);
	}
	
	@MutationMapping
	public Product updateStock(@Argument int id,@Argument int stock) {
		return service.updateStock(id, stock);
	}
	
	@MutationMapping
	public Product recieveNewShipment(@Argument int id,@Argument int quantity) {
		return service.recieveNewShipment(id, quantity);
	}
	
	@MutationMapping
	public Product addProduct(@Argument String name, @Argument String category, 
	                          @Argument float price, @Argument int stock) {
	    return service.addProduct(name, category, price, stock);
	}
	
	@MutationMapping
	public String deleteProduct(@Argument int id) {
	    service.deleteProduct(id);
	    return "Product with id " + id + " has been deleted successfully.";
	}
}
