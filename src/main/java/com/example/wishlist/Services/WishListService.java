package com.example.wishlist.Services;

import com.example.wishlist.repositories.UserHandler;

public class WishListService {

    UserHandler userHandler = new UserHandler();

    public void createUser(String email, String password, String name){
        userHandler.createUser(email, password, name);
    }

}
