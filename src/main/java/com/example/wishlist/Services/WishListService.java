package com.example.wishlist.Services;

import com.example.wishlist.models.WishList;
import com.example.wishlist.repositories.UserHandler;
import com.example.wishlist.repositories.WishListHandler;

import java.util.ArrayList;

public class WishListService {


    WishListHandler wishListHandler = new WishListHandler();


    public void createWishList(WishList wishList){
        wishListHandler.createWishList(wishList);
    }


    public void deleteWishlist(int wishlistID){
        wishListHandler.deleteWishList(wishlistID);
    }

    public ArrayList<String> fetchOneUsersWishlist (String email){

        return wishListHandler.fetchOneUsersWishlist(email);

    }

}
