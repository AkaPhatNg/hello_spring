package com.t2404e.hello_spring.controller;

import com.t2404e.hello_spring.entity.Product;
import com.t2404e.hello_spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/products")

public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @RequestMapping(method= RequestMethod.GET)
    public List<Product> getAllProducts(){
        List<Product> list = productRepository.findAll();

        return list;
    }
    @RequestMapping(method= RequestMethod.GET, path ="{id}")
    public Product getProductByID(@PathVariable long id){
        Product product = productRepository.findById(id).get();
        return product;
    }
}