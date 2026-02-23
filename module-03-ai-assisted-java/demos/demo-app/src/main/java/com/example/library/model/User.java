package com.example.library.model;

/**
 * Demo POJO for Module 3 — Demo 3 (refactoring).
 * Used by UserService.getActiveUserEmails. Synthetic example for course use only.
 */
public class User {

    private String name;
    private String email;
    private boolean active;

    public User(String name, String email, boolean active) {
        this.name = name;
        this.email = email;
        this.active = active;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public boolean isActive() { return active; }
}
