package com.example.EsercizioGestioneProdotti.services;

import com.example.EsercizioGestioneProdotti.models.Order;
import com.example.EsercizioGestioneProdotti.models.User;

import java.util.List;

public interface OrderService {

    public List<Order> getOrdersByUser(Long id);
    public Order getOrderById(Long id);
    public Order saveOrder(Order order);
    public Order deleteOrder(Long id);

}
