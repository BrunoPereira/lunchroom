package com.lunchroom.orders.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunchroom.orders.model.Orders;
import com.lunchroom.orders.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class RestControler {

    @Autowired
    private OrdersService orderService;

    @GetMapping
    public ResponseEntity<List<Orders>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Orders>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody Orders orders) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orders));
    }

    @PutMapping
    public ResponseEntity<Orders> update(@RequestBody Orders orders) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.update(orders));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> delete(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
