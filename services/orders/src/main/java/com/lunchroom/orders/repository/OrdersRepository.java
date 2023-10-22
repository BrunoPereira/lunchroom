package com.lunchroom.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunchroom.orders.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}