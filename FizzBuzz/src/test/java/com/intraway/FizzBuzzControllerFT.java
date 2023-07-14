package com.intraway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzControllerFT {

    public static final String SE_ENCONTRARON_MÚLTIPLOS_DE_3_Y_DE_5 = "se encontraron múltiplos de 3 y de 5";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Test
    public void  testGetFizzBuzzList_1To15_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/intraway/api/fizzbuzz/1/15")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value(SE_ENCONTRARON_MÚLTIPLOS_DE_3_Y_DE_5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.list")
                        .value("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz"));
    }

    @Test
    public void  testGetFizzBuzzList_1To3_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/intraway/api/fizzbuzz/1/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("se encontraron múltiplos de 3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.list")
                        .value("1,2,Fizz"));
    }

    @Test
    public void testGetFizzBuzzList_InvalidParams() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/intraway/api/fizzbuzz/5/-2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}

