package com.example.BikersBackend.service;

import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductsById(Integer id){
        return productRepository.findById(id);
    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

}
