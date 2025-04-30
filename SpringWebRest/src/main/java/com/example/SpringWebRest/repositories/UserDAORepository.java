package com.example.SpringWebRest.repositories;

import com.example.SpringWebRest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAORepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
