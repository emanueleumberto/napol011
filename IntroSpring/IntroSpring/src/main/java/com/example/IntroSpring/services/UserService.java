package com.example.IntroSpring.services;

import com.example.IntroSpring.classes.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired @Qualifier("adminUser") ObjectProvider<User> adminUserProvider;

    public User createUserAdmin() {
        return adminUserProvider.getObject();
    }

}
