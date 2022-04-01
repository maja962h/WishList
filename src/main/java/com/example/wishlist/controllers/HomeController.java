package com.example.wishlist.controllers;

import com.example.wishlist.Services.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class HomeController {

    WishListService wishListService = new WishListService();

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

    @GetMapping("/wishList")
    public String wishList(){
        return "createWishlist";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm){

        String email = dataFromForm.getParameter("email");
        String name = dataFromForm.getParameter("name");
        String password = dataFromForm.getParameter("password");

        wishListService.createUser(email, password, name);

        return "redirect:/signUp";
    }

    @PostMapping("/test2")
    public String test2(WebRequest dataFromForm){

        String name = dataFromForm.getParameter("name");
        String email = dataFromForm.getParameter("email");


        wishListService.createWishList(name, email);

        return "redirect:/updateWishList";
    }
}
