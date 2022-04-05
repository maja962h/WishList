package com.example.wishlist.Services;

import com.example.wishlist.repositories.WishListHandler;

import java.util.ArrayList;

public class WishListService {


    WishListHandler wishListHandler = new WishListHandler();


    public void createWishList(String name, String email){
        wishListHandler.createWishList(name, email);
    }


    public void deleteWishlist(int wishlistID){
        wishListHandler.deleteWishList(wishlistID);
    }

    public ArrayList<String> fetchOneUsersWishlist (){
        return wishListHandler.fetchOneUsersWishlist();
    }

}
