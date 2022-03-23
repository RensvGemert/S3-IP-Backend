package com.example.BikersBackend.service;

import com.example.BikersBackend.dal.ProductDAL;
import com.example.BikersBackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductDAL productDAL;

    @Autowired
    public ProductService(ProductDAL productDAL) {
        this.productDAL = productDAL;
    }

    public List<Product> getAllProducts(){
        return productDAL.getAllProducts();
    }

    public Optional<Product> getProductsById(Integer id){
        return productDAL.getProductsById(id);
    }

}
