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
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void GetAllProducts() {
        // init values
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bike 1", "Description", new BigDecimal(49.99), ""));
        products.add(new Product(2, "Bike 2", "Description", new BigDecimal(149.99), ""));
        products.add(new Product(3, "Bike 3", "Description", new BigDecimal(249.99), ""));

        // rendering method
        given(productRepository.findAll()).willReturn(products);

        // expected vs actual
        int expectedProductCount = 3;
        List<Product> actualProducts = productService.getAllProducts();

        // list size is equal to expected size
        assertEquals(expectedProductCount, actualProducts.size());
    }

    @Test
    void getProductById() {
        // init values
        Product product = new Product(1, "Bike 1", "Description", new BigDecimal(249.99), "");
        given(productRepository.findById(1)).willReturn(Optional.of(product));

        // rendering method
        Optional<Product> actualProduct = productService.getProductById(1);

        // expected vs actual
        String expectedTitle = "Bike 1";
        String actualTitle = actualProduct.get().productTitle;

        // Are equal
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void createProduct() {
        // init values
        Product product = new Product(1, "Bike 1", "Description", new BigDecimal(249.99), "");
        productService.createProduct(product);

        // Check if the create method rendered 1 time
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void deleteProduct() {

    }

    @Test
    void updateProduct() {
        // init values
        Product product = new Product(10, "Bike 1", "Description", new BigDecimal(249.99), "");
        given(productRepository.save(product)).willReturn(product);
        given(productRepository.findById(10)).willReturn(Optional.of(product));

        // updating the fields
        String newTitle = "Test Bike 1";
        product.setProductTitle(newTitle);

        // saving the new data
        productService.updateProduct(product.productId, product);
        productRepository.save(product);

        // expected vs result
        String expectedProductTitle = "Test Bike 1";
        String updatedProductTitle = productRepository.findById(10).get().productTitle;

        // New Title is equal to the updated title
        assertEquals(expectedProductTitle, updatedProductTitle);
    }
}