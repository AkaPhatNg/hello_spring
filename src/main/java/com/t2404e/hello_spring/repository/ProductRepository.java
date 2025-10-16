package com.t2404e.hello_spring.repository;

import com.t2404e.hello_spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
