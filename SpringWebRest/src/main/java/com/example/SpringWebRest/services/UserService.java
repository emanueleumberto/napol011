package com.example.SpringWebRest.services;

import com.example.SpringWebRest.models.User;

import java.util.List;

public interface UserService {

    public User createUser(String firstname, String lastname, String city,
                           Integer age, String email, String password);
    public User createFakeUser();

    // Crud Method
    public User saveUser(User user);
    public User findUser(long id);
    public String removeUser(User user);
    public String removeUserById(Long id);
    public List<User> findAll();

    public User checkEmail(String email);

}
