package com.lunchroom.orders.service;

import java.util.List;
import java.util.Optional;

import com.lunchroom.orders.model.Orders;

public interface OrdersService {
    
    Orders save(Orders order);

    List<Orders> findAll();

    Optional<Orders> findById(Long id);

    Orders update(Orders order);

    void deleteById(Long id);

}
