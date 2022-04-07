package com.example.wishlist.Services;

import com.example.wishlist.models.WishList;
import com.example.wishlist.repositories.WishListHandler;
import java.util.ArrayList;

public class WishListService {

    private WishListHandler wishListHandler = new WishListHandler();

    public void createWishList(WishList wishList){
        wishListHandler.createWishList(wishList);
    }

    public void deleteWishlist(int wishlistID){
        wishListHandler.deleteWishList(wishlistID);
    }

    public void updateWishlistName(String name, int wishlistID){
        wishListHandler.updateWishListName(name, wishlistID);
    }

    public ArrayList<WishList> fetchOneUsersWishlist (){
        return wishListHandler.fetchOneUsersWishlist();
    }
}
