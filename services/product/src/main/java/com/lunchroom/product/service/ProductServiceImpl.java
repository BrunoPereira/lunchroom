package com.lunchroom.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunchroom.product.model.CaloriesRequest;
import com.lunchroom.product.model.CaloriesResponse;
import com.lunchroom.product.model.Product;
import com.lunchroom.product.repository.ProductRepository;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public CaloriesResponse calculateCalories(CaloriesRequest caloriesRequest){
    int calories =0;
    CaloriesResponse caloriesResponse = new CaloriesResponse();
    
    caloriesResponse.setOrderId(caloriesRequest.getOrderId());
    for (long productId : caloriesRequest.getProductIds()) {
        Optional<Product> auxProduct = productRepository.findById(productId);
        if (auxProduct.isPresent()){
            calories += auxProduct.get().getCalories();
        }
    }
    caloriesResponse.setCalories(calories);
        
    return caloriesResponse;
    }
}