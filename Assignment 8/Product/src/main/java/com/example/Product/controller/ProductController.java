package com.example.Product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product.model.Product;
import com.example.Product.repo.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {



@Autowired
private ProductRepository repo;

//get all
@GetMapping
public List<Product> getAll() {
    return repo.findAll();
}

//get by id
@GetMapping("/{id}")
public Optional<Product> getOne(@PathVariable int id){
    return repo.findById(id);
}

//insert
@PostMapping
public ResponseEntity<String> add(@Valid @RequestBody Product product) {
    repo.save(product);
    return ResponseEntity.ok("Product added");
}

//update by id
@PutMapping("/{id}")
public ResponseEntity<String> update(@PathVariable int id, @Valid @RequestBody Product product) {
    if (!repo.existsById(id)) return ResponseEntity.notFound().build();
    product.setId(id);
    repo.save(product);
    return ResponseEntity.ok("Product updated");
}

//delete by id
@DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable int id) {
    if (!repo.existsById(id)) return ResponseEntity.notFound().build();
    repo.deleteById(id);
    return ResponseEntity.ok("Product deleted");
}

}
