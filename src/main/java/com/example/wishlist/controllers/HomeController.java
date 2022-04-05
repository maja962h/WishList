package com.example.wishlist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/logIn")
    public String logIn(){
        return "logIn";
    }

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @GetMapping("/forgotPassword")
    public String forgotPassword(){
        return "forgotPassword";
    }

    @GetMapping("/createWishlist")
    public String wishList(){
        return "createWishlist";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        return "updateUser";
    }

    @GetMapping("/userOptions")
    public String userOptions(){
        return "userOptions";
    }

    @GetMapping("/deleteWishlist")
    public String deleteWishlist(){
        return "deleteWishlist";
    }

}
