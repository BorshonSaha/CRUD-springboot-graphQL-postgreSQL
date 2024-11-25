package com.springboot.project.graphql.postgres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	private float price;
	private int stock;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String category, float price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Product orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
