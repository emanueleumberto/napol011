package com.example.EsercizioGestioneProdotti.repositories;

import com.example.EsercizioGestioneProdotti.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
