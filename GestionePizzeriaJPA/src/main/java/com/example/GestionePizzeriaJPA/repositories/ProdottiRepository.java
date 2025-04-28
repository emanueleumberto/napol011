package com.example.GestionePizzeriaJPA.repositories;

import com.example.GestionePizzeriaJPA.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottiRepository extends JpaRepository<Prodotto, Long> {
}
