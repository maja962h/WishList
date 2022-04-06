package com.example.wishlist.controllers;

import com.example.wishlist.Services.WishListService;
import com.example.wishlist.Services.WishService;
import com.example.wishlist.models.Wish;
import com.example.wishlist.models.WishList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class WishListController {
    WishListService wishListService = new WishListService();
    WishService wishService = new WishService();



    @GetMapping("/viewWishlist")
    public String getSingleEmail(Model m, WebRequest dataFromForm){
        String email = dataFromForm.getParameter("email");
        System.out.println(m.addAttribute("singleWishlist", wishListService.fetchOneUsersWishlist(email)));
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

    @PostMapping("/updateWishListName")
    public String updateWishlistName(WebRequest dataFromForm){

        String name = dataFromForm.getParameter("name");
        int wishlistId = Integer.parseInt(dataFromForm.getParameter("wishlistID"));

        wishListService.updateWishlistName(name, wishlistId);

        return "redirect:/updateWishList";
    }

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
