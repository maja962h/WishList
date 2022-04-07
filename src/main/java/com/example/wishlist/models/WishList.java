package com.example.wishlist.models;

public class WishList {

    private String name;
    private String userEmail;
    private int Id;

    public WishList(int id, String name, String userEmail) {
        this.Id = id;
        this.name = name;
        this.userEmail = userEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
