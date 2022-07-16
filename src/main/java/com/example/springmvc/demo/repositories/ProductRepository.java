package com.example.springmvc.demo.repositories;

import com.example.springmvc.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findByid(Integer id);
    Page<Product> findAll(Pageable pageable);
}
