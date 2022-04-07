package com.example.wishlist.controllers;

import com.example.wishlist.Services.WishService;
import com.example.wishlist.models.Wish;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

public class WishController {

    private WishService wishService = new WishService();

    @PostMapping("/addWish")
    public String createWish(WebRequest dataFromForm) {

        String description = dataFromForm.getParameter("description");
        String name = dataFromForm.getParameter("name");
        int price = Integer.parseInt(dataFromForm.getParameter("price"));
        int wishListId = Integer.parseInt(dataFromForm.getParameter("wishlistID"));

        Wish tempWish = new Wish(name, price, description, wishListId);


        wishService.createWish(tempWish);

        return "redirect:/addWish";
    }

    @PostMapping("/removeWish")
    public String deleteWish(WebRequest dataFromForm){

        int wishID = Integer.parseInt(dataFromForm.getParameter("wishID"));

        wishService.deleteWish(wishID);

        return "redirect:/userOptions";
    }

    @PostMapping("/updateWishName")
    public String updateWishName(WebRequest dataFromForm){

        String name = dataFromForm.getParameter("name");
        int wishId = Integer.parseInt(dataFromForm.getParameter("wishID"));

        wishService.updateWishName(name, wishId);

        return "redirect:/editWish";
    }

    @PostMapping("/updateWishDescription")
    public String updateWishDescription(WebRequest dataFromForm){

        String description = dataFromForm.getParameter("wishDescription");
        int wishId = Integer.parseInt(dataFromForm.getParameter("wishID2"));

        wishService.updateWishDescription(description, wishId);

        return "redirect:/editWish";
    }

    @PostMapping("/updateWishPrice")
    public String updateWishPrice(WebRequest dataFromForm){

        int price = Integer.parseInt(dataFromForm.getParameter("wishPrice"));
        int wishId = Integer.parseInt(dataFromForm.getParameter("wishID3"));

        wishService.updateWishPrice(price, wishId);

        return "redirect:/editWish";
    }
}
