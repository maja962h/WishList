package com.example.wishlist.models;

public class Wish {

    private String description;
    private String wishName;
    private int price;
    private int wishListID;

    public Wish(String wishName, int price, String description, int wishListID) {
        this.description = description;
        this.wishName = wishName;
        this.price = price;
        this.wishListID = wishListID;
    }

    public int getWishListID() {
        return wishListID;
    }

    public String getDescription() {
        return description;
    }

    public String getWishName() {
        return wishName;
    }

    public int getPrice() {
        return price;
    }
}
