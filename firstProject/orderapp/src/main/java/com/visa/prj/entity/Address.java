package com.visa.prj.entity;

public class Address {
	
	private String houseNumber;
	private String city;
	private String state;
	private String country;
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address() {
		super();
	}
	public Address(String houseNumber, String city, String state, String country) {
		super();
		this.houseNumber = houseNumber;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", city=" + city + ", state=" + state + ", country=" + country
				+ "]";
	}

}
