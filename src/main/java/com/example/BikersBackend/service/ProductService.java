package com.example.BikersBackend.service;

import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public void updateProduct(int productId, Product prod) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("product with id: " + productId + " not found!"));

        if(prod.productTitle != null &&
                prod.productTitle.length() > 0 &&
                !Objects.equals(product.getProductTitle(), prod.productTitle)){
            product.setProductTitle(prod.productTitle);
        }

        if(prod.productDescription != null &&
                prod.productDescription.length() > 0 &&
                !Objects.equals(product.getProductDescription(), prod.productDescription)){
            product.setProductDescription(prod.productDescription);
        }

        if(prod.productPrice != null &&
                !Objects.equals(product.getProductPrice(), prod.productPrice)){
            product.setProductPrice(prod.productPrice);
        }

        if(prod.productImageUrl != null &&
                prod.productImageUrl.length() > 0 &&
                !Objects.equals(product.getProductImageUrl(), prod.productImageUrl)){
            product.setProductImageUrl(prod.productImageUrl);
        }
    }

}
