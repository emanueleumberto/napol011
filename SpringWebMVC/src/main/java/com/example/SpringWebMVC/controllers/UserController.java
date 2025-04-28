package com.example.SpringWebMVC.controllers;

import com.example.SpringWebMVC.model.User;
import com.example.SpringWebMVC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired UserService userService;

    // Esempio Login

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/gestione-login")
    public ModelAndView checkLogin(@RequestParam String email, @RequestParam String password) {
        User u = userService.checkUser(email, password);

        if(u != null) {
            ModelAndView model = new ModelAndView("detail");
            model.addObject("user", u);
            return model;
            //return "Controller page " + u.getFirstname() + " " + u.getLastname();
        } else {
            ModelAndView model = new ModelAndView("pageError");
            model.addObject("message", "Login failed!!");
            return model;
        }
    }

}
