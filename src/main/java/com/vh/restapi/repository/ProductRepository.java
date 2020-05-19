package com.vh.restapi.repository;

import com.vh.restapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();

    Product save(Product product);

    void deleteById(Integer id);
}
