package com.example.introSpringDemo.runners;

import com.example.introSpringDemo.classes.User;
import com.example.introSpringDemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRunner implements CommandLineRunner {

    private List<User> listaUtenti;
    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User admin = userService.createAdminUser();
        User user1 = userService.createCustomUser("Mario", "Rossi",
                                            "Roma", 45, "m.rossi@example.com");
        User user2 = userService.createCustomUser("Giuseppe", "Verdi",
                                            "Milano", 21, "g.verdi@example.com");
        User fake1 = userService.createFakeUser();
        User fake2 = userService.createFakeUser();

        listaUtenti = List.of(admin, user1, user2, fake1, fake2);
        listaUtenti.forEach(System.out::println);

    }


}
