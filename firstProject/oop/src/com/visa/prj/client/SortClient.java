package com.visa.prj.client;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.Utility;

public class SortClient {
	public static void main(String[] args) {
		String[] names= {"bhanu","sushmita","paaro"};
		Utility.sort(names);
		
		/*for(String s:names) {
			System.out.println(s);
		}*/
		
		 Product[] products = new Product[5]; // Array of 4 Pointers
			products[0] = new Tv("Bravia",135000,100,"LED");
			products[1] = new Mobile("MotoG", 12999.00, 300,"4G");
			products[2] = new Tv("Onida Thunder",3500.00,190,"CRT");
			products[3] = new Mobile("XR", 99999.00,450,"3G");
			products[4] = new Mobile("Oppo", 9999.0,780,"4G");
			
		Utility.sort(products);
		
		for(Product p:products) {
			System.out.println(p.getName());
		}
	}

}
