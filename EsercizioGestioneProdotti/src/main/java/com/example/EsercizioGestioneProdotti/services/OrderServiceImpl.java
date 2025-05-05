package com.example.EsercizioGestioneProdotti.services;

import com.example.EsercizioGestioneProdotti.enumerations.StatusOrder;
import com.example.EsercizioGestioneProdotti.models.Order;
import com.example.EsercizioGestioneProdotti.models.Product;
import com.example.EsercizioGestioneProdotti.repositories.OrderRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersByUser(Long id) {
        List<Order> orders = orderRepository.findAll();
        List<Order> userOrders = orders.stream().filter(o -> o.getUser().getId() == id).toList();
        return userOrders;
    }

    @Override
    public Order getOrderById(Long id) {
        if(!orderRepository.existsById(id)) {
            throw new EntityExistsException("Order_id not exists!!!");
        }
        return orderRepository.findById(id).get();
    }

    @Override
    public Order saveOrder(Order order) {

        double totalPrice = order.getProducts().stream()
                            .mapToDouble(p -> p.getPrice().doubleValue()).sum();
        order.setTotalPrice(BigDecimal.valueOf(totalPrice));
        order.setStatus(StatusOrder.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order deleteOrder(Long id) {
        Order order = getOrderById(id);
        order.setStatus(StatusOrder.CANCELLED);
        return orderRepository.save(order);
    }
}
