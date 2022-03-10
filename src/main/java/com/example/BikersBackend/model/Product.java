package com.example.BikersBackend.model;

public class Product {
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
