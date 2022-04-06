package com.example.wishlist.controllers;

import com.example.wishlist.Services.UserService;
import com.example.wishlist.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {
    UserService userService = new UserService();

    @PostMapping("/logOn")
    public String logOn(WebRequest dataFromForm){
        String email = dataFromForm.getParameter("email");
        String password = dataFromForm.getParameter("password");

        if(userService.validateLogin(email, password) == true){
            return "redirect:/userOptions";
        }
        return "redirect:/logIn";
    }


    @PostMapping("/createUser")
    public String userCreation(WebRequest dataFromForm){

        String email = dataFromForm.getParameter("email");
        String name = dataFromForm.getParameter("name");
        String password = dataFromForm.getParameter("password");

        User tempUser = new User(email, password ,name);

        userService.createUser(tempUser);

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
