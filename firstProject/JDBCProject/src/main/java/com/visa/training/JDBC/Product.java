package com.visa.training.JDBC;

public class Product {
	private int id;
	private String name;
	private float price;
	private int qty;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, float price, int qty) {
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getPrice()=" + getPrice() + ", getQty()=" + getQty() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
