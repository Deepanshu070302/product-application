package com.example.product_app.e2e;

import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductE2ETest {

	@LocalServerPort
	private int port;
	
	@Test
	public void testSayHello() {
		given().port(port) //Arrange
		.when().get("/api/products/hello") //Action
		.then() //Assertion
				.contentType(ContentType.TEXT)
				.body(equalTo("Hello from Product App")); 
	}
	
	@Test 
	public void testCreateFare() {
 
	  //Arrange 
		String productJson = "{\r\n"
				+ "    \"name\": \"Laptops\",\r\n"
				+ "    \"description\": \"Lenovo\",\r\n"
				+ "    \"price\": 450\r\n"
				+ "}";
  
  //
		given() 
		.port(port)
		.log().all()
		.contentType(ContentType.JSON)
		.body(productJson)  //-> requestBody - arrange
		.when() 
		.post("/api/products") // -> action
		.then() 
		.log().all()
		.statusCode(200) // -> assertions
		.body("name", equalTo("Laptops"))
		.body("price",equalTo("450"));
		}




	
}