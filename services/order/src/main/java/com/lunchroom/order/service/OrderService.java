package com.lunchroom.order.service;

import java.util.List;
import java.util.Optional;

import com.lunchroom.order.model.Order;

public interface OrderService {
    
    Order save(Order order);

    List<Order> findAll();

    Optional<Order> findById(Long id);

    Order update(Order order);

    void deleteById(Long id);

}
