package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.Product;


@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.req", "Name cannot be blank");
		
		Product p=(Product) target;
		
		if(p.getPrice()<=0) {
			errors.rejectValue("price", "price.err", "price should be positive");
		}

	}

}
