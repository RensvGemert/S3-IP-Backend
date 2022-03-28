package com.example.BikersBackend.controller;

import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/details/{productId}")
    public Optional<Product> getProductsById(@PathVariable Integer productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/update/{productId}")
    public void updateProduct(@PathVariable("productId") Integer productId,
                @RequestParam(required = false) String productTitle,
                @RequestParam(required = false) String productDescription) {
        productService.updateProduct(productId, productTitle, productDescription);
    }
}
