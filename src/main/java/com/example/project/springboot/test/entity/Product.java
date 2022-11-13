package com.example.project.springboot.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Product {

    @Id
    private Long productId;
    private String productName;
    private String productDescription;
    private Integer productCategory;
    private double price;
    private Date expiryDate;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Integer productCategory) {
        this.productCategory = productCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
