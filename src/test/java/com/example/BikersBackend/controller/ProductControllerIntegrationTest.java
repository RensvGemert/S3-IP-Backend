package com.example.BikersBackend.controller;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllProducts() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/products");
        MvcResult result = mvc.perform(request).andReturn();

        String actual = result.getResponse().getContentAsString();
        String expected = "[{\"productId\":1,\"productTitle\":\"Fiets 1\",\"productDescription\":\"Test product 1\",\"productPrice\":199.00,\"productImageUrl\":\"https://contents.mediadecathlon.com/p1537948/k$a83fb42f90d368d826fe089b858074a8/sq/racefiets-wielrenfiets-rc500-shimano-sora-met-schijfremmen-grijs.jpg?format=auto&f=969x969\"}]";

        assertEquals(expected, actual);
    }


    @Test
    public void getProductsById(){
    }
}