package com.example.wishlist.controllers;

import com.example.wishlist.Services.UserService;
import com.example.wishlist.Services.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class HomeController {
    UserService userService = new UserService();
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

    @PostMapping("/createUser")
    public String test(WebRequest dataFromForm){

        String email = dataFromForm.getParameter("email");
        String name = dataFromForm.getParameter("name");
        String password = dataFromForm.getParameter("password");

        userService.createUser(email, password, name);

        return "redirect:/userOptions";
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

        userService.updateUserName(email, name);

        return "redirect:/updateUser";
    }

    @PostMapping("/updateUserPassword")
    public String updateUserPassword(WebRequest dataFromForm){

        String password = dataFromForm.getParameter("password");
        String email = dataFromForm.getParameter("email2");

        userService.updateUserPassword(email, password);

        return "redirect:/updateUser";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(WebRequest dataFromForm){

        String email = dataFromForm.getParameter("email3");

        userService.deleteUser(email);

        return "redirect:/updateUser";
    }

    @PostMapping("/deleteWishlist")
    public String deleteWishlist(WebRequest dataFromForm){

        int wishlistID = Integer.parseInt(dataFromForm.getParameter("wishlistID"));

        wishListService.deleteWishlist(wishlistID);

        return "redirect:/userOptions";
    }
}
