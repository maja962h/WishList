package com.example.wishlist.models;

public class WishList {

    private String name;
    private String userEmail;
    private int id;

    public WishList(int id, String name, String userEmail) {
        this.id = id;
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
