package com.example.wishlist.models;

import java.util.ArrayList;

public class WishList {

    private ArrayList<Wish> wishes = new ArrayList<>();
    private String name;
    private String userEmail;

    public WishList(String name, String userEmail) {
        this.name = name;
        this.userEmail = userEmail;
    }

    public ArrayList<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(ArrayList<Wish> wishes) {
        this.wishes = wishes;
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
