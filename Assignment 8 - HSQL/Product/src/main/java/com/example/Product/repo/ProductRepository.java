package com.example.Product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Product.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
