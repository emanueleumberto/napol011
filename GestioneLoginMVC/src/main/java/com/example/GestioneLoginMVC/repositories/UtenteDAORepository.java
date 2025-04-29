package com.example.GestioneLoginMVC.repositories;

import com.example.GestioneLoginMVC.models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteDAORepository extends JpaRepository<Utente, Long> {
    public Utente findByEmailAndPassword(String email, String password);
}
