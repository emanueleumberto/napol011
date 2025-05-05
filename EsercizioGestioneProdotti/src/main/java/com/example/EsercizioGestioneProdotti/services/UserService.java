package com.example.EsercizioGestioneProdotti.services;

import com.example.EsercizioGestioneProdotti.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User saveUser(User user);
    public void deleteUser(Long id);

}
