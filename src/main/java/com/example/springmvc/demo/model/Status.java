package com.example.springmvc.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "status_name")
    private String status_name;

    public Status(Integer id, String status_name) {
        this.id = id;
        this.status_name = status_name;
    }

    public Status() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
}
