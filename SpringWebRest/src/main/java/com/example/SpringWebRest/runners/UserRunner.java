package com.example.SpringWebRest.runners;

import com.example.SpringWebRest.models.User;
import com.example.SpringWebRest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {
        if(userService.findAll().size() == 0) {
            initDB(10);
        }
    }

    private void initDB(int num) {
        for (int i = 0; i < num; i++) {
            userService.saveUser(userService.createFakeUser());
        }
        System.out.println("Users Database completed!");
    }
}
