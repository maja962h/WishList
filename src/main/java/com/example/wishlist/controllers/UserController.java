package com.example.wishlist.controllers;

import com.example.wishlist.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {
    UserService userService = new UserService();

    @PostMapping("/createUser")
    public String test(WebRequest dataFromForm){

        String email = dataFromForm.getParameter("email");
        String name = dataFromForm.getParameter("name");
        String password = dataFromForm.getParameter("password");

        userService.createUser(email, password, name);

        return "redirect:/userOptions";
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
}
