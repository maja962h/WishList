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

    @GetMapping("/updateUser")
    public String updateUser(){
        return "updateUser";
    }

    @PostMapping("/createUser")
    public String test(WebRequest dataFromForm){

        String email = dataFromForm.getParameter("email");
        String name = dataFromForm.getParameter("name");
        String password = dataFromForm.getParameter("password");

        wishListService.createUser(email, password, name);

        return "redirect:/signUp";
    }

    @PostMapping("/createWishlist")
    public String test2(WebRequest dataFromForm){

        String name = dataFromForm.getParameter("name");
        String email = dataFromForm.getParameter("email");


        wishListService.createWishList(name, email);

        return "redirect:/updateWishList";
    }

    @PostMapping("/updateUserName")
    public String updateUsername(WebRequest dataFromForm){

        String name = dataFromForm.getParameter("name");
        String email = dataFromForm.getParameter("email");

        wishListService.updateUserName(email, name);

        return "redirect:/updateUser";
    }

    @PostMapping("/updateUserPassword")
    public String updateUserPassword(WebRequest dataFromForm){

        String password = dataFromForm.getParameter("password");
        String email = dataFromForm.getParameter("email2");

        wishListService.updateUserPassword(email, password);

        return "redirect:/updateUser";
    }
}
