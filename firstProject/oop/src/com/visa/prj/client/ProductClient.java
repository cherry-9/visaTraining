package com.visa.prj.client;

import java.lang.reflect.Method;
import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {

		 Product[] products = new Product[5]; // Array of 4 Pointers
			products[0] = new Tv("Sony Bravia",135000,100,"LED");
			products[1] = new Mobile("MotoG", 12999.00, 300,"4G");
			products[2] = new Tv("Onida Thunder",3500.00,190,"CRT");
			products[3] = new Mobile("iPhone XR", 99999.00,450,"3G");
			products[4] = new Mobile("Oppo", 9999.0,780,"4G");
		
			printExpensive(products);

	}

	private static void printExpensive(Product[] products) {
		for(int i=0;i<products.length;i++) {
			if(products[i].isExpensive())System.out.println(products[i].getName()+" YES");
			else System.out.println(products[i].getName()+" NO");
		}
		
	
	
	for(Product p:products) {
		Method[] methods=p.getClass().getMethods();
		for(Method m:methods) {
			if(m.getName().startsWith("get")) {
				try {
					Object ret=m.invoke(p);
					System.out.println(ret);
				} catch(Exception ex) {
					
				}
				
			}
		}
		/*System.out.println( p.getName() );
		if(p instanceof Tv) {
			Tv t=(Tv) p;
			System.out.println(t.getConnectivity());
		}
		else {
			Mobile t=(Mobile) p;
			System.out.println(t.getConnectivity());
		}*/
		
	}
	
	}
	
	
	
	

}
