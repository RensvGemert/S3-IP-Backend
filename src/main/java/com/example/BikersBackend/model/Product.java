package com.example.BikersBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "productTable")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer productId;
    public String productTitle;

    public Product() {
    }

    public Product(Integer productId, String productTitle) {
        this.productId = productId;
        this.productTitle = productTitle;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                '}';
    }
}
