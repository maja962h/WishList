package com.example.wishlist.Services;

import com.example.wishlist.models.Wish;
import com.example.wishlist.repositories.WishHandler;

public class WishService {

    WishHandler wishHandler = new WishHandler();

    public void createWish(Wish wish){
        wishHandler.createWish(wish);
    }

    public void deleteWish(int wishID){
        wishHandler.deleteWish(wishID);
    }

    public void updateWishName(String name, int wishID){
        wishHandler.updateWishName(name, wishID);
    }

    public void updateWishDescription(String description, int wishID){
        wishHandler.updateWishDescription(description, wishID);
    }

    public void updateWishPrice(int price, int wishID){
        wishHandler.updateWishPrice(price, wishID);
    }
}
