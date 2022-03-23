package com.example.BikersBackend.dal;

import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDAL {

    private final IProductRepository productRepository;

    @Autowired
    public ProductDAL(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional <Product> getProductsById(Integer id){
        return productRepository.findById(id);
    }
}
