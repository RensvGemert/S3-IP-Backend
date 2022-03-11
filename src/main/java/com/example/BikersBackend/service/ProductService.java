package com.example.BikersBackend.service;

import com.example.BikersBackend.dal.ProductDAL;
import com.example.BikersBackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDAL productDAL;

    @Autowired
    public ProductService(ProductDAL productDAL) {
        this.productDAL = productDAL;
    }

    public List<Product> getProducts(){
        List<Product> products = productDAL.getProducts();
        return products;
    }
}
