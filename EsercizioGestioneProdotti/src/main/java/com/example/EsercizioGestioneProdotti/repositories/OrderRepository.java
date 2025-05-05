package com.example.EsercizioGestioneProdotti.repositories;

import com.example.EsercizioGestioneProdotti.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
