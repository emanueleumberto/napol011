package com.example.EsercizioGestioneProdotti.repositories;

import com.example.EsercizioGestioneProdotti.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // exists by username
    public boolean existsByUsername(String username);
    // exists by email
    public boolean existsByEmail(String email);
}
