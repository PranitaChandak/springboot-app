package com.example.project.springboot.test.controller;

import com.example.project.springboot.test.entity.Product;
import com.example.project.springboot.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable final Long id){
        return productService.getProductById(id);
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody final Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable final Long id,@RequestBody final Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable final Long id){
        return productService.deleteProduct(id);
    }
}
