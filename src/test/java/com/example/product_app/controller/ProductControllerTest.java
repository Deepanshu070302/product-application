package com.example.product_app.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//import com.example.product_app.model.Product;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // enable and configure auto-configuration of MockMvc
public class ProductControllerTest {
	
	@Autowired // Mocking class tailored for testing the web layer, http methods
	private MockMvc mockMvc;
	
	@Test
	public void testCreateProduct() throws Exception {
		// Arrange
		String prod = "{\r\n"
				+ "    \"name\": \"Laptops\",\r\n"
				+ "    \"description\": \"Lenovo\",\r\n"
				+ "    \"price\": 450\r\n"
				+ "}";
		// Product product = new Product(); product.setName("Laptops"); product.setDescription("Sony"); product.setPrice(600.00);
		
		// Action
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
				.contentType(MediaType.APPLICATION_JSON).content(prod));

		System.out.println(result.toString());

		// Assert - 
		result.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Laptops"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("450"));

	}
	
	//test case 2 - getProductByID
	@Test
	public void testGetProductById() throws Exception {
		
		//Action + Assertions
		mockMvc.perform(MockMvcRequestBuilders.get("/api/products/26")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Laptops"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("450"));

	}

	



}