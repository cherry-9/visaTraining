package com.visa.prj.entity;

public class Tv extends Product {

	private String connectivity;

	public Tv(String name, double price, int id, String connectivity) {
		super(name, price, id);
		this.connectivity = connectivity;
	}

	public Tv() {
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	@Override
	public boolean isExpensive() {
		return true;
	}
	
	
}
