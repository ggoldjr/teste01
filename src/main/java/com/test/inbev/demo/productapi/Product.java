/**
 * autor: geraldojr
 * teste para entrevita técnica ab-inbev
 * data 09/09/2020
 * 
 * classe: Product
 * 		objeto produto usado na aplicação 
 */
package com.test.inbev.demo.productapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 
@Entity
public class Product {
	private @Id @GeneratedValue long id;
    private String name;
    private String description;
    private double price;
    private String brand;
 
    protected Product() {
    }
    
    Product(String name, String description, double price, String brand) {
	    this.name = name;
	    this.description = description;
	    this.price = price;
	    this.brand = brand;
	  }
    
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}