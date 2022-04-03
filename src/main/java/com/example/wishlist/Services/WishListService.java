package com.example.wishlist.Services;

import com.example.wishlist.repositories.UserHandler;
import com.example.wishlist.repositories.WishListHandler;

public class WishListService {

    UserHandler userHandler = new UserHandler();
    WishListHandler wishListHandler = new WishListHandler();

    public void createUser(String email, String password, String name){
        userHandler.createUser(email, password, name);
    }

    public void createWishList(String name, String email){
        wishListHandler.createWishList(name, email);
    }

    public void updateUserName(String email, String name){
        userHandler.updateUserName(email, name);
    }

    public void updateUserPassword(String email, String password){
        userHandler.updateUserPassword(email, password);
    }

    public void deleteUser(String email){
        userHandler.deleteUser(email);
    }

}
