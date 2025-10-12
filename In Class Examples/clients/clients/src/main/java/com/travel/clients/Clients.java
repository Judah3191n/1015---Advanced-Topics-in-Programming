package com.travel.clients;

import java.util.jar.Attributes.Name;

public class Clients {
    
private String Name;
private String Email;
private String Phone;


    public Clients(String name,String email, String phone ) {
this.Name = name;
this.Email = email;
this.Phone = phone;

    }
public Clients() {


    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }



}
