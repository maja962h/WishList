package com.example.wishlist.controllers;

import com.example.wishlist.Services.WishListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class WishListController {
    WishListService wishListService = new WishListService();

    @GetMapping("/getOneUsersWishlist")
    public String getSingleEmail(Model m){
        //String email = dataFromForm.getParameter("email");
        m.addAttribute("singleWishlist", wishListService.fetchOneUsersWishlist());
        return "viewWishlist";
    }

    @PostMapping("/createWishlist")
    public String test2(WebRequest dataFromForm){

        String name = dataFromForm.getParameter("name");
        String email = dataFromForm.getParameter("email");


        wishListService.createWishList(name, email);

        return "redirect:/updateWishList";
    }

    @PostMapping("/deleteWishlist")
    public String deleteWishlist(WebRequest dataFromForm){

        int wishlistID = Integer.parseInt(dataFromForm.getParameter("wishlistID"));

        wishListService.deleteWishlist(wishlistID);

        return "redirect:/userOptions";
    }
}
