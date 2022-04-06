package com.example.wishlist.Services;

import com.example.wishlist.models.User;
import com.example.wishlist.repositories.UserHandler;

public class UserService {

    UserHandler userHandler = new UserHandler();

    public void createUser(User user){
        userHandler.createUser(user);
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

    public String validateLogin(String email, String password){
        if(userHandler.validateLoginInformation(email, password) == true){
            return "redirect:/userOptions";
        }
        return "redirect:/logIn";
    }

}
