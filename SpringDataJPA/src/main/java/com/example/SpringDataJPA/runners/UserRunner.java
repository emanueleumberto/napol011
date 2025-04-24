package com.example.SpringDataJPA.runners;

import com.example.SpringDataJPA.models.User;
import com.example.SpringDataJPA.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {
        //User u1 = userService.createAdminUser();
        //User u2 = userService.createFakeUser();
        //User u3 = userService.createCustomUser("Mario", "Rossi", "Roma", 24, "m.rossi@example.com");

        //System.out.println(u1);
        //System.out.println(u2);
        //System.out.println(u3);

        //userService.saveUser(u1);
        //userService.saveUser(u2);
        //userService.saveUser(u3);

        //User u = userService.findUser(2);
        //u.setEmail("q.costa@email.it");
        //userService.saveUser(u);
        //System.out.println(u);

        //userService.removeUser(u);

        //userService.findAll().forEach(System.out::println);

    }
}
