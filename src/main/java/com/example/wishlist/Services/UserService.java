package com.example.wishlist.Services;

import com.example.wishlist.repositories.UserHandler;

public class UserService {

    UserHandler userHandler = new UserHandler();

    public void createUser(String email, String password, String name){
        userHandler.createUser(email, password, name);
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
