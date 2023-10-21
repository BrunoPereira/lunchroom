package com.lunchroom.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lunchroom.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}