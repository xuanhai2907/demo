package com.example.springmvc.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.*;
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "subcate_id")
    private Integer subcate_id;
    @Column(name = "product_name")
    @NotEmpty(message = "Product_name is not null")
    private  String product_name;
    @Column(name = "color")
    @NotEmpty(message = "Color is not null")
    private  String color;
    @Column(name = "quantity")
    @NotNull(message = "Quantity is not null")
    @Min(value = 1, message = "Quantity should not be less than 0 ")
    private Integer quantity;
    @Column(name = "sell_price")
    @NotNull(message = "Sell_price is not null")
    @Min(value = 1, message = "Sell_price should not be less than 0 ")
    private  Double sell_price;
    @Column(name = "origin_price")
    @NotNull(message = "Origin_price is not null")
    @Min(value = 1, message = "Origin_price should not be less than 0 ")
    private  Double origin_price;
    @Column(name = "description")
    @NotEmpty(message = "Description is not null")
    private  String description;
    @Column(name = "status_id")
    private  Integer status_id;

    public Product(Integer id, Integer subcate_id, String product_name, String color, Integer quantity, double sell_price, double origin_price, String description, Integer status_id) {
        this.id = id;
        this.subcate_id = subcate_id;
        this.product_name = product_name;
        this.color = color;
        this.quantity = quantity;
        this.sell_price = sell_price;
        this.origin_price = origin_price;
        this.description = description;
        this.status_id = status_id;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubcate_id() {
        return subcate_id;
    }

    public void setSubcate_id(Integer subcate_id) {
        this.subcate_id = subcate_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSell_price() {
        return sell_price;
    }

    public void setSell_price(Double sell_price) {
        this.sell_price = sell_price;
    }

    public Double getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(Double origin_price) {
        this.origin_price = origin_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }
}
