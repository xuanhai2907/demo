package com.example.springmvc.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "cate_code")
    private String cate_code;
    private String cate_name;

    public Category() {
    }

    public Category(int id, String cate_code, String cate_name) {
        this.id = id;
        this.cate_code = cate_code;
        this.cate_name = cate_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCate_code() {
        return cate_code;
    }

    public void setCate_code(String cate_code) {
        this.cate_code = cate_code;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }
}
