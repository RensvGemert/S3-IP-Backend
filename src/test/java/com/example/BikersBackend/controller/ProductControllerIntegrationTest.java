package com.example.BikersBackend.controller;

import com.example.BikersBackend.BikersBackendApplication;
import com.example.BikersBackend.model.Product;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = BikersBackendApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

//    @Autowired
//    private TestRestTemplate testRestTemplate;

    @Test
    @Sql("/test-data.sql")
    public void getAllProducts_API_GET_TEST() throws Exception{

//        ResponseEntity<Product> response = testRestTemplate.getForEntity("/api/products", Product.class);
//        assertThat(response.getResponse().getContentAsByteArray().length == 0);
//        System.out.println(response.getResponse().getContentAsString());
//        System.out.println(response);
//        assertEquals("Testbike1", Objects.requireNonNull(response.getBody()).productTitle);
//        assertEquals("Testdescription", response.getBody().productDescription);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/products").accept(MediaType.APPLICATION_JSON)).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}