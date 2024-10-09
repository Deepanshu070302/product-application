package com.example.product_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // Lombok to reduce boilerplate code (optional)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Long price;
    public Product() {
    	
    }
	public Product(String name, String description,Long price) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.description=description;
		this.price=price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
    
    
    
}