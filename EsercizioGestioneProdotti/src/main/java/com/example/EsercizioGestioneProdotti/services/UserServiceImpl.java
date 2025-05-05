package com.example.EsercizioGestioneProdotti.services;

import com.example.EsercizioGestioneProdotti.models.User;
import com.example.EsercizioGestioneProdotti.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        // controllo se esiste già un username nel DB
        if(userRepository.existsByUsername(user.getUsername())) {
            throw new EntityExistsException("Username exists!!!");
        } else if(userRepository.existsByEmail(user.getEmail())) {
            throw new EntityExistsException("Email exists!!!");
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new EntityExistsException("User_id not exists!!!");
        }
        userRepository.deleteById(id);
    }
}
