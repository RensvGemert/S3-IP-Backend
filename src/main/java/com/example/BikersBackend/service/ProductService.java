package com.example.BikersBackend.service;

import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
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

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public void createProduct(Product product){
        if(product.productTitle != "" || product.productDescription != "") {
            productRepository.save(product);
        }
    }

    public void deleteProduct(int productId){
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new IllegalStateException("Product with id: " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(int productId, String productTitle, String productDescription, BigDecimal productPrice, String productImageUrl) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("product with id: " + productId + " not found!"));

        if(productTitle != null &&
                productTitle.length() > 0 &&
                !Objects.equals(product.getProductTitle(), productTitle)){
            product.setProductTitle(productTitle);
        }

        if(productDescription != null &&
                productDescription.length() > 0 &&
                !Objects.equals(product.getProductDescription(), productDescription)){
            product.setProductDescription(productDescription);
        }

        if(productPrice != null &&
                !Objects.equals(product.getProductPrice(), productPrice)){
            product.setProductPrice(productPrice);
        }

        if(productImageUrl != null &&
                productImageUrl.length() > 0 &&
                !Objects.equals(product.getProductImageUrl(), productImageUrl)){
            product.setProductImageUrl(productImageUrl);
        }
    }

}
