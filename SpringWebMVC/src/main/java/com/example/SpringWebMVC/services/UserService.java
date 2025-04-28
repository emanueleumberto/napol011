package com.example.SpringWebMVC.services;

import com.example.SpringWebMVC.model.User;
import com.example.SpringWebMVC.repositories.UserDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired @Qualifier("createUser") ObjectProvider<User> userObjectProvider;
    @Autowired @Qualifier("createFakeUser") ObjectProvider<User> userFakeObjectProvider;
    @Autowired UserDAORepository db;

    public User createUser(String firstname, String lastname, String city, String email, String password) {
        User user = userObjectProvider.getObject();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setCity(city);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    public User createFakeUser() {
        return userFakeObjectProvider.getObject();
    }

    public void saveUser(User user) {
        db.save(user);
        System.out.println("User " + user.getFirstname() + " " + user.getLastname() + " created!!!");
    }

    public User findUser(long id) {
        return db.findById(id).get();
    }

    public List<User> findAll() {
        return db.findAll();
    }

    public User checkUser(String email, String password) {
        return db.findByEmailAndPassword(email, password);
    }

}
