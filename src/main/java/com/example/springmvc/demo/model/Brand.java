package com.example.springmvc.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "brand_name")
    private String brand_name;

    public Brand() {
    }

    public Brand(int id, String brand_name) {
        this.id = id;
        this.brand_name = brand_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
}
