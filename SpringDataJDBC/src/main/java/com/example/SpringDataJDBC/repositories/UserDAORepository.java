package com.example.SpringDataJDBC.repositories;

import com.example.SpringDataJDBC.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAORepository {

    // CRUD
    public void insertUser(User user);  // Create
    public User getUser(long id);       // Read
    public void updateUser(User user);  // Update
    public void removeUser(User user);  // Delete

    public List<User> getAllUser();
}
