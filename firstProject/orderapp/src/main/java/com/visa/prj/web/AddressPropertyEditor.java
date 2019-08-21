package com.visa.prj.web;

import java.beans.PropertyEditorSupport;

import com.visa.prj.entity.Address;

public class AddressPropertyEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		Address ad =(Address) getValue();
		
		return ad.toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] str=text.split(",");
		
		Address ad=new Address();
		ad.setHouseNumber(str[0]);
		ad.setCity(str[1]);
		ad.setCountry(str[3]);
		ad.setState(str[2]);
		setValue(ad);
	}
	
	

}
