package com.visa.prj.entity;

public class Mobile extends Product {
	private String connectivity;
	
	public    Mobile(){
	}

	public Mobile(String name, double price, int id, String connectivity) {
		super(name, price, id);
		this.connectivity = connectivity;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	@Override
	public boolean isExpensive() {
		if(getPrice()>5000)return true;
		return false;
	}
	
	

}
