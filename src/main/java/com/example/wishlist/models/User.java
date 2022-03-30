package com.example.wishlist.models;

public class User {

    private int Id;
    private String password;
    private String email;

    public User(int id, String password, String email) {
        Id = id;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
