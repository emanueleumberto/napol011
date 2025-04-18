package com.example.IntroSpring.runners;

import com.example.IntroSpring.classes.User;
import com.example.IntroSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class UserRunner implements CommandLineRunner {

    @Autowired private UserService userService;

    /*@Autowired
    public UserRunner(UserService userService) {
        this.userService = userService;
    }*/

    /*@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    @Override
    public void run(String... args) throws Exception {
        System.out.println("UserRunner...");

        //UserService userService = new UserService();
        User u = userService.createUserAdmin();
        System.out.println(u);

    }

}
