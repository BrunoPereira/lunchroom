package com.lunchroom.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunchroom.orders.model.Orders;
import com.lunchroom.orders.repository.OrdersRepository;

import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders save(Orders order, String employee) {
        order.setCreated(new Date());
        order.setUpdated(new Date());
        return ordersRepository.save(order);
    }

    @Override
    public List<Orders> findAllByEmployee(String employee) {
        return ordersRepository.findAll();
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id, String employee) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders update(Orders order, String employee) {
        return ordersRepository.save(order);
    }

    @Override
    public void deleteById(Long id, String employee) {
        ordersRepository.deleteById(id);
    }
}