package com.example.SpringWebRest.services;

import com.example.SpringWebRest.models.User;
import com.example.SpringWebRest.repositories.UserDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired @Qualifier("createUser") ObjectProvider<User> userObjectProvider;
    @Autowired @Qualifier("createFakeUser") ObjectProvider<User> userFakeObjectProvider;
    @Autowired UserDAORepository userDAORepository;

    @Override
    public User createUser(String firstname, String lastname, String city, Integer age, String email, String password) {
        User user = userObjectProvider.getObject();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setCity(city);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    @Override
    public User createFakeUser() {
        return userFakeObjectProvider.getObject();
    }

    @Override
    public User saveUser(User user) {
        userDAORepository.save(user);
        return user;
    }

    @Override
    public User findUser(long id) {
        return userDAORepository.findById(id).get();
    }

    @Override
    public String removeUser(User user) {
        userDAORepository.delete(user);
        return "User " + user.getFirstname() + " " + user.getLastname() +" deleted!";
    }

    @Override
    public String removeUserById(Long id) {
        userDAORepository.deleteById(id);
        return "User deleted!";
    }

    @Override
    public List<User> findAll() {
        return userDAORepository.findAll();
    }

    @Override
    public User checkEmail(String email) {
        return userDAORepository.findByEmail(email);
    }
}
