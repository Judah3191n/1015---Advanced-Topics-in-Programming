package com.example.Product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    @Size(max = 50)
    private String name;

    @NotNull
    private float price;

    private String category;

    public Product() {
    };

    public Product(String name, float price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Getters and Setters
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

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
