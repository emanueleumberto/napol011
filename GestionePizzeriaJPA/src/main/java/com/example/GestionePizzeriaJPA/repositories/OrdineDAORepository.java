package com.example.GestionePizzeriaJPA.repositories;

import com.example.GestionePizzeriaJPA.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineDAORepository extends JpaRepository<Ordine, Long> {
}
