package com.example.wishlist.controllers;

import com.example.wishlist.Services.WishListService;
import com.example.wishlist.models.WishList;
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
    public String wishListCreation(WebRequest dataFromForm){


        int wishlistID = -1;
        String name = dataFromForm.getParameter("name");
        String email = dataFromForm.getParameter("email");

        WishList tempWishList = new WishList(wishlistID, name, email);

        wishListService.createWishList(tempWishList);

        return "redirect:/addWish";
    }

    @PostMapping("/deleteWishlist")
    public String deleteWishlist(WebRequest dataFromForm){

        int wishlistID = Integer.parseInt(dataFromForm.getParameter("wishlistID"));

        wishListService.deleteWishlist(wishlistID);

        return "redirect:/userOptions";
    }
}
