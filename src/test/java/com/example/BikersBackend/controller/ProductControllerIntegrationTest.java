package com.example.BikersBackend.controller;
import com.example.BikersBackend.BikersBackendApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllProducts() throws Exception {

        ApplicationContext applicationContext = SpringApplication.run(BikersBackendApplication.class);

        var productController = applicationContext.getBean(com.example.BikersBackend.controller.ProductController.class);
        productController.getAllProducts();


        RequestBuilder request = MockMvcRequestBuilders.get("/api/products");
        MvcResult result = mvc.perform(request).andReturn();

        int actualStatus = result.getResponse().getStatus();
        int expectedStatus = 200;

        assertEquals(expectedStatus, actualStatus);
    }
}