package com.lunchroom.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.lunchroom.product.model.Product;

import java.util.*;

@Repository
public class ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();

    public Optional<Product> findById(long id) {
        return Optional.ofNullable(products.get(id));
    }

    public void add(Product product) {
        products.put(product.getId(), product);
    }

    public Collection<Product> getProducts() {
        return products.values();
    }

    public Page<Product> getProducts(Pageable pageable) {
        int toSkip = pageable.getPageSize() * pageable.getPageNumber();
        List<Product> result = products.values().stream().skip(toSkip).limit(pageable.getPageSize()).toList();

        return new PageImpl<>(result, pageable, products.size());
    }
}