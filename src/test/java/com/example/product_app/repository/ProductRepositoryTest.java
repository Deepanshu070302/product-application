package com.example.product_app.repository;
 
import java.util.List;
import java.util.Optional;
 
//import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.product_app.model.Product;
 
//@DataJpaTest
@SpringBootTest(classes = {com.example.product_app.ProductApplication.class})
public class ProductRepositoryTest {
	
	@Autowired
	ProductRepository productRepo;
	
	//test case 1 - find all the products
	@Test
	public void testGetAllProducts() {
		//AAA
		//Given - Arrange
    	Product p = new Product("Mobiles", "Sony", 500L);
    	Product p1 = new Product("Pencils", "Natraj", 200L);
    	
    	productRepo.save(p);
    	productRepo.save(p1);
    	
    	//When - Action - testing the findAll
    	List<Product> products = productRepo.findAll();
    	
    	//Then - Assertion
    	assertNotNull(products);
    	assertEquals(products.size(),11);
	}
//	
	//test case 2- save the product into table - save()
		@Test
		public void testsaveProduct() {
			//AAA
			//Given - Arrange
	    	Product p = new Product("Laptops", "Sony", 500L);
	    	
	    	
	    	//When - Action - save the product - repo.save()
	    	Product savedProduct = productRepo.save(p);
	    	
	    	//Then - Assertion
	    	assertNotNull(savedProduct.getId());
	    	assertEquals("Laptops", savedProduct.getName());
	 	}
 
		//test case 3 - get the product by productId - findById()
				@Test
				public void testGetProductById() {
					//AAA
					//Given - Arrange
			    	Product p = new Product("laptop", "Sony", 500L);
			    	productRepo.save(p);
			    	
			    	//When - Action - get the product by Id- repo.findById()
			    	Optional<Product> result = productRepo.findById(21L);
			    	
			    	//Then - Assertion
			    	assertNotNull(result);
			    	assertEquals("laptop", result.get().getName());
			 	}
				
				//test case 4 - delete the product  - delete()
				@Test
				public void testDeleteProduct() {
					//AAA
					//Given - Arrange
			    	Product p = new Product("laptop", "Sony", 500L);
			    	Product savedProduct = productRepo.save(p);
			    	
			    	//When - Action - delete the product - repo.delete()
			    	productRepo.delete(savedProduct);
			    	Optional<Product> result = productRepo.findById(21L);
			    	
			    	
			    	//Then - Assertion
			    	assertEquals(Optional.empty(), result);
			 	}
 
}
 