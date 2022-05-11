package com.example.BikersBackend.service;

import com.example.BikersBackend.model.Product;
import com.example.BikersBackend.repositories.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    private ProductService underTest;

    @BeforeEach
    void SetUp(){
        underTest = new ProductService(productRepository);
    }

    @Test
    void canGetAllProducts(){
        // when
        underTest.getAllProducts();
        // then
        verify(productRepository).findAll();
    }

    @Test
    void canAddProducts(){
        // given
        Product product = new Product("Test bike", "description1", new BigDecimal(200), "test");
        // when
        underTest.createProduct(product);
        // then
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);

        verify(productRepository).save(productArgumentCaptor.capture());

        Product capturedProduct = productArgumentCaptor.getValue();

        assertThat(capturedProduct).isEqualTo(product);
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
        underTest.updateProduct(product.productId, product);
        productRepository.save(product);

        // expected vs result
        String expectedProductTitle = "Test Bike 1";
        String updatedProductTitle = productRepository.findById(10).get().productTitle;

        // New Title is equal to the updated title
        assertEquals(expectedProductTitle, updatedProductTitle);
    }
}