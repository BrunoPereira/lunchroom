package com.lunchroom.product.controler;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lunchroom.product.exception.ProductException;
import com.lunchroom.product.model.Product;
import com.lunchroom.product.repository.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class RestControler {

    private final ProductRepository repository;

    public RestControler(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable long id) {
        return repository.findById(id)
                .orElseThrow(ProductException::new);
    }

    @GetMapping("/")
    public Collection<Product> findProducts() {
        return repository.getProducts();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(
            @PathVariable("id") final String id, @RequestBody final Product product) {
        return product;
    }
}
