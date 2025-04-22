package com.example.SpringDataJDBC.services;

import com.example.SpringDataJDBC.models.User;
import com.example.SpringDataJDBC.repositories.UserDAOjdbc;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired UserDAOjdbc db;
    @Autowired @Qualifier("customUser") ObjectProvider<User> userObjectProvider;
    @Autowired @Qualifier("fakeUser") ObjectProvider<User> fakeUserObjectProvider;

    public User createCustomUser(String firstname, String lastname, String city, int age, String email) {
        User user = userObjectProvider.getObject();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setCity(city);
        user.setAge(age);
        user.setEmail(email);
        return user;
    }

    public User createFakeUser() {
        return fakeUserObjectProvider.getObject();
    }

    // JDBC
    public void saveUser(User user) {
        db.insertUser(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() + " salvato nel DB");
    }

    public User findUser(long id) {
        return db.getUser(id);
    }

    public void updateUser(User user) {
        db.updateUser(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() + " modificato nel DB");
    }

    public void removeUser(User user) {
        db.removeUser(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() + " eliminato dal DB");
    }

    public List<User> findAllUser() {
        return db.getAllUser();
    }

}
