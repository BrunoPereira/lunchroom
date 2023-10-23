package com.lunchroom.orders.controler;

import java.security.Principal;
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

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/orders")
public class RestControler {

    @Autowired
    private OrdersService orderService;

    @GetMapping
    public ResponseEntity<List<Orders>> findAll(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAllByEmployee( principal.getName()));
    }

    @GetMapping("/audit")
    public ResponseEntity<List<Orders>> audit() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Orders>> findById(@PathVariable Long id, HttpServletRequest request) {
         Principal principal = request.getUserPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id, principal.getName()));
    }

    @PostMapping
    public ResponseEntity<Orders> create(@RequestBody Orders orders, HttpServletRequest request) {
         Principal principal = request.getUserPrincipal();
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orders, principal.getName()));
    }

    @PutMapping
    public ResponseEntity<Orders> update(@RequestBody Orders orders, HttpServletRequest request) {
         Principal principal = request.getUserPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(orderService.update(orders, principal.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> delete(@PathVariable Long id, HttpServletRequest request) {
         Principal principal = request.getUserPrincipal();
        orderService.deleteById(id,  principal.getName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
