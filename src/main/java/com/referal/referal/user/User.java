package com.referal.referal.user;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String id; // Changed to String for MongoDB compatibility
    private String email;
    private String password;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

