package com.visa.prj.client;

import java.util.Set;
import java.util.TreeSet;

import com.visa.prj.entity.Product;

public class SetExample {

	public static void main(String[] args) {
		//Set<Product> products=new HashSet<>();

		Set<Product> products=new TreeSet<>((a,b)-> {
			int diff=Double.compare(a.getPrice(),b.getPrice());
			if(diff==0) {
				diff=a.getId()-b.getId();
			}
			return diff;
		});
		products.add(new Product(645,"ap Laptop",135000.00,"computer",100));
		products.add(new Product(224,"iPhone",98000.00,"mobile",500));
		products.add(new Product(834,"bogitech Mouse",600.00,"computer",300));
		products.add(new Product(5,"cony Bravia",125000.00,"tv",900));
		products.add(new Product(912,"dne Plus",32000.00,"mobile",100));
		products.add(new Product(88,"fP Printer",19000.00,"computer",100));
		
		products.forEach(p->System.out.println(p));
	}

}
