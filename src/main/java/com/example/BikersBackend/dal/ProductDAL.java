package com.example.BikersBackend.dal;

import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDAL {

    private IProductRepository productRepository;

    @Autowired
    public ProductDAL(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
