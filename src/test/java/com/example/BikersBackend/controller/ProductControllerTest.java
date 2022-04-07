package com.example.BikersBackend.controller;
import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.repositories.IProductRepository;
import com.example.BikersBackend.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class ProductControllerTest {


    @Test
    void getProductById_Test_IsEqualTo() {
        Product product1 = new Product(1, "TestBike1", "description", new BigDecimal("199.99"), "");

        assertThat(product1.productId).isEqualTo(1);
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getProductsById() {
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
