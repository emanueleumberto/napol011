package com.example.SpringWebMVC.runners;

import com.example.SpringWebMVC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {

        // Controllo se nel database ci sono utenti registrati
        // Nel caso in cui non ci sono ne crea 10
        if(userService.findAll().size() == 0) {
            userService.saveUser(
                    userService.createUser(
                            "Mario",
                            "Rossi",
                            "Roma",
                            "m.rossi@example.com",
                            "Pa$$w0rd!"
                    ));
            for (int i = 0; i < 9; i++) {
                userService.saveUser(userService.createFakeUser());
            }
        }

    }
}
