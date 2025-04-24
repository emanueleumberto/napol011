package com.example.SpringDataJPA.services;

import com.example.SpringDataJPA.models.User;
import com.example.SpringDataJPA.repositories.UserDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired UserDAORepository userDB;
    @Autowired @Qualifier("customUser") ObjectProvider<User> customUserObjectProvider;
    @Autowired @Qualifier("fakeUser") ObjectProvider<User> fakeUserObjectProvider;
    @Autowired @Qualifier("adminUser") ObjectProvider<User> adminUserObjectProvider;

    public User createCustomUser(String firstname, String lastname, String city, int age, String email) {
        User user = customUserObjectProvider.getObject();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }

    public User createFakeUser() {
        return fakeUserObjectProvider.getObject();
    }

    public User createAdminUser() {
        return adminUserObjectProvider.getObject();
    }

    // JPA Method

    public void saveUser(User user) {
        userDB.save(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() +" salvato nel DB!");
    }

    public User findUser(long id) {
        return userDB.findById(id).get();
    }

    public void removeUser(User user) {
        userDB.delete(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() +" eliminato dal DB!");
    }

    public List<User> findAll() {
        return userDB.findAll();
    }

}
