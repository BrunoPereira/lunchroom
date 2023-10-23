package com.lunchroom.orders.service;

import java.util.List;
import java.util.Optional;

import com.lunchroom.orders.model.Orders;

public interface OrdersService {
    
    Orders save(Orders order, String employee);

    List<Orders> findAll();

    List<Orders> findAllByEmployee(String employee);

    Optional<Orders> findById(Long id, String employee);

    Orders update(Orders order, String employee);

    void deleteById(Long id, String employee);

}
