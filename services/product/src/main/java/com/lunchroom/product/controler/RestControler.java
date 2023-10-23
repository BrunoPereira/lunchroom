package com.lunchroom.product.controler;

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

import com.lunchroom.product.model.CaloriesRequest;
import com.lunchroom.product.model.CaloriesResponse;
import com.lunchroom.product.model.Product;
import com.lunchroom.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class RestControler {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/calories")
    public ResponseEntity<CaloriesResponse> calculateCalories(@RequestBody CaloriesRequest caloriesRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.calculateCalories(caloriesRequest));
    }
}
