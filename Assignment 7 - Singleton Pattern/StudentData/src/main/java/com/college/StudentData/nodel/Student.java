package com.college.StudentData.nodel;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Student {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;


@NotBlank(message = "Name is required")
@Size(max = 50)
private String name;


@NotBlank(message = "Email is required")
@Email(message = "Email should be valid")
private String email;


public Student() {}


public Student(String name, String email) {
this.name = name;
this.email = email;
}


// Getters and Setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }


public String getName() { return name; }
public void setName(String name) { this.name = name; }


public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }
}
