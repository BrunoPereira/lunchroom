package com.lunchroom.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunchroom.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}