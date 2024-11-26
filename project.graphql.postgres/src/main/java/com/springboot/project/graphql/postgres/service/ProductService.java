package com.springboot.project.graphql.postgres.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import com.springboot.project.graphql.postgres.model.Product;
import com.springboot.project.graphql.postgres.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> getProducts() {
		return repository.findAll();
	}
//	Get product by category
	public List<Product> getProductsByCategory(String category) {
		return repository.findByCategory(category);
	}
	
//	sales team: Update stock of a product
	public Product updateStock(int id, int stock) {
		Product existingProduct = repository.findById(id)
				.orElseThrow(()-> new RuntimeException("Product not found with id: "+id));
		existingProduct.setStock(stock);
		return repository.save(existingProduct);
	}
	
//	warehouse: receive new shipment
	public Product recieveNewShipment(int id, int quantity) {
		Product existingProduct = repository.findById(id);
		existingProduct.setStock(existingProduct.getStock() + quantity);
		return repository.save(existingProduct);
	}

//	Add product
	public Product addProduct(String name, String category, float price, int stock) {
	    Product newProduct = new Product();
	    newProduct.setName(name);
	    newProduct.setCategory(category);
	    newProduct.setPrice(price);
	    newProduct.setStock(stock);
	    return repository.save(newProduct);
	}

//  Delete product
	public void deleteProduct(int id) {
	    Product existingProduct = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	    repository.delete(existingProduct);
	}
	

//	search by name
	public List<Product> searchByName(String name) {
		List<Product> existingProduct = repository.findAll();
		return existingProduct.stream()
	            .filter(product -> product.getName() != null &&
	                               product.getName().toLowerCase().contains(name.toLowerCase()))
	            .collect(Collectors.toList());
	}

}
