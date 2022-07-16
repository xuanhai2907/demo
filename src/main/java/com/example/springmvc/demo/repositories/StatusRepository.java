package com.example.springmvc.demo.repositories;

import com.example.springmvc.demo.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Integer> {

}
