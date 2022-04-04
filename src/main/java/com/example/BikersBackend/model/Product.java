package com.example.BikersBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "productTable")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer productId;
    public String productTitle;
    public String productDescription;
    public BigDecimal productPrice;
    public String productImageUrl;

    public Product() {
    }

    public Product(Integer productId, String productTitle, String productDescription, BigDecimal productPrice, String productImageUrl) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImageUrl = productImageUrl;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productImageUrl='" + productImageUrl + '\'' +
                '}';
    }
}
