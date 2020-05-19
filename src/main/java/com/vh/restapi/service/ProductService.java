package com.vh.restapi.service;

import com.vh.restapi.entity.Picture;
import com.vh.restapi.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product(1, "test 1", "123456789", Arrays.asList(new Picture(1, "path", "comment")));
        Product product2 = new Product(2, "test 1", "123456789", Arrays.asList(new Picture(1, "path", "comment")));
        products.add(product1);
        products.add(product2);
        return products;
    }

    public Product findById(int id) {
        return new Product(1, "test 1", "123456789", Arrays.asList(new Picture(1, "path", "comment")));
    }

    public int save(Product product) {
        return 1;
    }

    public int update(Product product) {
        return 1;
    }

    public void delete(int id) {
        //
    }
}
