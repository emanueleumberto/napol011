package com.example.EsercizioGestioneProdotti.controllers;

import com.example.EsercizioGestioneProdotti.models.Order;
import com.example.EsercizioGestioneProdotti.models.User;
import com.example.EsercizioGestioneProdotti.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        // POST /orders → Crea un ordine per un utente.
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        // GET /orders/{id} → Ottiene i dettagli di un ordine.
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long id) {
        // PUT /orders/{id}/cancel → Annulla un ordine.
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable Long userId) {
        // GET /orders/user/{userId} → Restituisce gli ordini di un utente.
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

}
