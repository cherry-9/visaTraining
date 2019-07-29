package com.visa.prj.entity;

public abstract class Product {
	
	String name;
	double price;
	int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Product(String name, double price, int id) {
		this.name = name;
		this.price = price;
		this.id = id;
	}
	
	public Product() {}
	
	public abstract boolean isExpensive();

}
