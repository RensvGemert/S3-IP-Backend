package com.example.BikersBackend.controller;

import com.example.BikersBackend.BikersBackendApplication;
import com.example.BikersBackend.model.Product;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = BikersBackendApplication.class
)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    @Sql("/test-data.sql")
    public void shouldGetAllProducts() throws Exception{
         mockMvc.perform(MockMvcRequestBuilders.get("/api/products")
                         .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$[0].productTitle").value("Testbike1"))
                 .andExpect(jsonPath("$[0].productDescription").value("Testdescription"))
                 .andExpect(jsonPath("$[0].productPrice").value(200))
                 .andExpect(jsonPath("$[0].productImageUrl").value("testurl"))
                 .andReturn();
    }


    @Test
    @Order(2)
    public void shouldCreateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"productId\": \"1001\", \"productTitle\": \"Testbike\", \"productDescription\": \"Brand new bike\" }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andExpect(MockMvcResultMatchers.header().string("Location", Matchers.containsString("1001")))
                .andReturn();
    }


    @Test
    @Order(3)
    @Sql("/test-data.sql")
    public void shouldUpdateProduct() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.put("/api/products/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"productId\": \"1\", \"productTitle\": \"TestBikeUpdated\", \"productDescription\": \"Brand new bike\" }"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andExpect(MockMvcResultMatchers.header().string("Location", Matchers.containsString("1")));

//        mockMvc.perform(MockMvcRequestBuilders.get("/api/products")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].productTitle").value("TestBikeUpdated"))
//                .andExpect(jsonPath("$[0].productDescription").value("Brand new bike"))
//                .andExpect(jsonPath("$[0].productPrice").value(200))
//                .andExpect(jsonPath("$[0].productImageUrl").value("testurl"))
//                .andReturn();
    }


}