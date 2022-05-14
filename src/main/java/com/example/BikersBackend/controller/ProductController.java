package com.example.BikersBackend.controller;

import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    public Optional<Product> getProductsById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder uriComponentsBuilder) {
        productService.createProduct(product);
        // for API Testing location
        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/products/{productId}").build(product.getProductId()))
                .build();
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/update/{productId}")
    public void updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        productService.updateProduct(productId, product);
    }
}
