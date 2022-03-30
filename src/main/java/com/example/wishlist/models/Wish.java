package com.example.wishlist.models;

public class Wish {

    private String description;
    private String wishName;
    private int price;

    public Wish(String description, String wishName, int price) {
        this.description = description;
        this.wishName = wishName;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
