package com.example.wishlist.models;

import java.util.ArrayList;

public class WishList {

    private ArrayList<Wish> wishes = new ArrayList<>();
    private int wishListId;
    private String name;
    private User wishListOwner;

    public WishList(ArrayList<Wish> wishes, int wishId, String name, User wishListOwner) {
        this.wishes = wishes;
        this.wishListId = wishId;
        this.name = name;
        this.wishListOwner = wishListOwner;
    }

    public ArrayList<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(ArrayList<Wish> wishes) {
        this.wishes = wishes;
    }

    public int getWishListId() {
        return wishListId;
    }

    public void setWishListId(int wishListId) {
        this.wishListId = wishListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getWishListOwner() {
        return wishListOwner;
    }

    public void setWishListOwner(User wishListOwner) {
        this.wishListOwner = wishListOwner;
    }
}
