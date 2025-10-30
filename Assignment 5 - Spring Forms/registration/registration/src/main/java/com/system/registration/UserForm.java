package com.system.registration;


import jakarta.validation.constraints.*;

public class UserForm {
    

    @NotNull
    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;


    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
    //@NotBlank(message = "Email is required")
    @Size(max = 100, message = "Email must be less than 100 characters")
    @Email(message = "it should be valid email")
    private String email;


    @Min(value = 18, message = "Age should be at least 18")
    @Max(value = 100, message = "Age should be at most 100")
    private int age;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
