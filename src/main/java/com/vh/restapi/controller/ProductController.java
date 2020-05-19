package com.vh.restapi.controller;

import com.vh.restapi.entity.Product;
import com.vh.restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(productService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                    productService.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                );
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Product product) {
        Product resProduct = productService.save(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resProduct);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Product product) {
        Product resProduct = productService.update(product);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resProduct);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity delete(@PathVariable int id) {
        productService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
