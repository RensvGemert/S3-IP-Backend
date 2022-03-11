package com.example.BikersBackend.service;

import com.example.BikersBackend.repositories.IProductRepository;
import com.example.BikersBackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }
}
