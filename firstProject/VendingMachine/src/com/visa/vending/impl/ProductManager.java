package com.visa.vending.impl;

import java.util.ArrayList;
import java.util.List;

import com.visa.vending.entity.Product;
import com.visa.vending.entity.Transaction;

public class ProductManager {

	public static void main(String[] args) {
		
		List<Product> list=new ArrayList<>();
		
		list.add(new Product("Lays", 25.0, 9, 1));
		list.add(new Product("FunFlips", 10.0, 10, 2));
		list.add(new Product("Kurkure", 35.0, 20, 3));
		
		//a new transaction to vend product
		Transaction t1=new Transaction(1, 2);
		
		list.forEach(p->{
			if(p.getId()==t1.getProductId()
					&& p.getQty()>t1.getQty()) {
				p.setQty(p.getQty()-t1.getQty());
				System.out.println("transaction succes");
			}
		});
	}

}
