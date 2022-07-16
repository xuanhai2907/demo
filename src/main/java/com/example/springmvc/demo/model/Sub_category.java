package com.example.springmvc.demo.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "sub_category")
public class Sub_category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotBlank(message = "Sub_cate_code is not null")
    @Pattern(regexp = "SA\\d{4}", message = "Sub_cate_code is not format")
    @Column(name = "sub_cate_code")
    private String sub_cate_code;
    @NotBlank(message = "Sub_cate_name is not null")
    @Pattern(regexp = "[a-zA-Z]+", message = "Sub_cate_name is not format")
    @Column(name = "sub_cate_name")
    private String sub_cate_name;
    private Integer cate_id;

    public Sub_category() {
    }

    public Sub_category(Integer id, String sub_cate_code, String sub_cate_name, Integer cate_id) {
        this.id = id;
        this.sub_cate_code = sub_cate_code;
        this.sub_cate_name = sub_cate_name;
        this.cate_id = cate_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSub_cate_code() {
        return sub_cate_code;
    }

    public void setSub_cate_code(String sub_cate_code) {
        this.sub_cate_code = sub_cate_code;
    }

    public String getSub_cate_name() {
        return sub_cate_name;
    }

    public void setSub_cate_name(String sub_cate_name) {
        this.sub_cate_name = sub_cate_name;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }
}
