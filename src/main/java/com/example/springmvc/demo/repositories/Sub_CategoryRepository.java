package com.example.springmvc.demo.repositories;

import com.example.springmvc.demo.model.Category;
import com.example.springmvc.demo.model.Product;
import com.example.springmvc.demo.model.Sub_category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface Sub_CategoryRepository extends CrudRepository<Sub_category, Integer> {
    Iterable<Sub_category> findByid(Integer id);
    Page<Sub_category> findAll(Pageable pageable);
}

