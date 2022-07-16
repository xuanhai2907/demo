package com.example.springmvc.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_brand")
public class Product_Brand {
    @Id
    @Column(name = "product_id")
    private Integer product_id;
    @Column(name = "brand_id")
    private Integer brand_id;

    public Product_Brand(Integer product_id, Integer brand_id) {
        this.product_id = product_id;
        this.brand_id = brand_id;
    }

    public Product_Brand() {
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }
}
