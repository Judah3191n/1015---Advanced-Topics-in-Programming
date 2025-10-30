package com.system.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UserController {
  
   
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@Valid UserForm userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        model.addAttribute("message", "Form submitted successfully!");
        return "success";
    }
}












