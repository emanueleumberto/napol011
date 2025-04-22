package com.example.SpringDataJDBC.runners;

import com.example.SpringDataJDBC.models.User;
import com.example.SpringDataJDBC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {
        //User u1 = userService.createCustomUser("Mario", "Rossi", "Roma", 45, "m.rossi@example.com");
        //User u2 = userService.createFakeUser();

        //System.out.println(u1);
        //System.out.println(u2);

        // JDBC Method
        //userService.saveUser(u1);
        //userService.saveUser(u2);

        //User u = userService.findUser(2);
        //u.setEmail("s.santoro@example.com");
        //userService.updateUser(u);

        //User u = userService.findUser(1);
        //userService.removeUser(u);

        List<User> users = userService.findAllUser();
        users.forEach(System.out::println);
    }

}
