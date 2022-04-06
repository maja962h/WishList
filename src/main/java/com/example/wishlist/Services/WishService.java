package com.example.wishlist.Services;

import com.example.wishlist.models.Wish;
import com.example.wishlist.repositories.WishHandler;

public class WishService {

    WishHandler wishHandler = new WishHandler();

    public void createWish(Wish wish){
        wishHandler.createWish(wish);
    }
}
