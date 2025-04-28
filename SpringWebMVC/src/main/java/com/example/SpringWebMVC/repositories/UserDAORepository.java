package com.example.SpringWebMVC.repositories;

import com.example.SpringWebMVC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAORepository extends JpaRepository<User, Long> {
    public User findByEmailAndPassword(String email, String password);
}
