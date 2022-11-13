package com.example.project.springboot.test.service;

import com.example.project.springboot.test.entity.Product;
import com.example.project.springboot.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    public Product updateProduct(Long id,Product updatedProduct){
        productRepository.findById(id).
                map(c->
                {
                    c.setProductCategory(updatedProduct.getProductCategory());
                    c.setProductName(updatedProduct.getProductName());
                    c.setProductDescription(updatedProduct.getProductDescription());
                    c.setPrice(updatedProduct.getPrice());
                    c.setExpiryDate(updatedProduct.getExpiryDate());
                    return productRepository.save(c);
                }).orElseGet(
                        ()->{
                            updatedProduct.setProductId(id);
                            return productRepository.save(updatedProduct);
                        }
                );
        return updatedProduct;
    }

    public boolean deleteProduct(Long id){
        boolean doesExist= productRepository.findById(id).isPresent();
        if(doesExist){
            productRepository.deleteById(id);
            return true;
        }else{
            System.out.println("Given record with id"+id+ "could not found");
            return false;
        }

    }
}
