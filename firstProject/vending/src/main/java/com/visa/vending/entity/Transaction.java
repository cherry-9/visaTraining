package com.visa.vending.entity;

public class Transaction extends Thread {
	//private int transId;
	private int productId;
	private int qty;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Transaction(int productId, int qty) {
		super();
		this.productId = productId;
		this.qty = qty;
	}
	/*
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}*/
	

}
