package com.example.introSpringDemo.services;

import com.example.introSpringDemo.classes.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired @Qualifier("adminUser") ObjectProvider<User> adminObjectProvider;
    @Autowired @Qualifier("customUser") ObjectProvider<User> customObjectProvider;
    @Autowired @Qualifier("fakeUser") ObjectProvider<User> fakeObjectProvider;

    public User createAdminUser() {
        return adminObjectProvider.getObject();
    }

    public User createFakeUser() {
        return fakeObjectProvider.getObject();
    }

    public User createCustomUser(String firstname, String lastname, String city, int age, String email) {
        User u = customObjectProvider.getObject();
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setCity(city);
        u.setAge(age);
        u.setEmail(email);
        return u;
    }

}
