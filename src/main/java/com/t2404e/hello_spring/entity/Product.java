package com.t2404e.hello_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition = "BIGINT")
    private long id;
    @Column(name="name",columnDefinition = "VARCHAR(255)")
    private String name;
    @Column(name="description",columnDefinition = "TEXT")
    private String description;
    @Column(name="price",columnDefinition = "DECIMAL")
    private double price;
    @Column(name="status",columnDefinition = "TINYINT")
    private int status;
}

