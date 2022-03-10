package com.example.BikersBackend.service;

import com.example.BikersBackend.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Fiets"));
        return products;
    }
}
