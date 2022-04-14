package com.example.BikersBackend.service;

import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.repositories.IProductRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void GetAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bike 1", "Description", new BigDecimal(49.99), ""));
        products.add(new Product(2, "Bike 2", "Description", new BigDecimal(149.99), ""));
        products.add(new Product(3, "Bike 3", "Description", new BigDecimal(249.99), ""));

        given(productRepository.findAll()).willReturn(products);

        List<Product> expected = productService.getAllProducts();

        assertEquals(expected, products);
    }

    @Test
    void getProductById() {
        Product product = new Product(1, "Bike 1", "Description", new BigDecimal(249.99), "");

        given(productRepository.findById(1)).willReturn(Optional.of(product));

        Optional<Product> expected = productService.getProductById(1);

        String expectedTitle = "Bike 1";
        String actualTitle = expected.get().productTitle;

        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void createProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProduct() {
    }
}