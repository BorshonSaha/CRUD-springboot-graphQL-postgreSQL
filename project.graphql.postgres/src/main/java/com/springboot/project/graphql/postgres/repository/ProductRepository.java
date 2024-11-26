package com.springboot.project.graphql.postgres.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.project.graphql.postgres.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	public List<Product> findByCategory(String category);
	public Optional<Product> findById(int id);
}
