package com.t2404e.hello_spring.controller;

import com.t2404e.hello_spring.entity.Product;
import com.t2404e.hello_spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @RequestMapping(method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        // Validate dữ liệu.
        System.out.println(product);
        Product savedProduct = productRepository.save(product);
        return savedProduct; // có id.
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Product updateProduct(@RequestBody Product updateProduct, @PathVariable Long id) {
        // check sự tồn tại của id.
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            // 404
            // message error, define error response
            return null;
        }
        // Validate dữ liệu.
        // update vào thằng existing và save.
        Product existingProduct = optionalProduct.get();
        existingProduct.setName(updateProduct.getName());
        existingProduct.setPrice(updateProduct.getPrice());
        existingProduct.setDescription(updateProduct.getDescription());
        existingProduct = productRepository.save(existingProduct);
        return existingProduct; // có id.
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public String deleteProduct(@PathVariable Long id) {
        // check sự tồn tại của id.
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            // 404
            // message error, define error response
            return null;
        }
        // Validate dữ liệu.
        // update vào thằng existing và save.
        Product existingProduct = optionalProduct.get();
        existingProduct.setStatus(-1);
        existingProduct = productRepository.save(existingProduct);
        // productRepository.deleteById(id);
        return "Action success"; // format message
    }
}