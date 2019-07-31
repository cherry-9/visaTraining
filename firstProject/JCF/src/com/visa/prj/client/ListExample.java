package com.visa.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.visa.prj.entity.Product;

public class ListExample {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645,"Hp Laptop",135000.00,"computer",100));
		products.add(new Product(224,"iPhone",98000.00,"mobile",500));
		products.add(new Product(834,"Logitech Mouse",600.00,"computer",300));
		products.add(new Product(5,"Sony Bravia",125000.00,"tv",900));
		products.add(new Product(912,"One Plus",32000.00,"mobile",100));
		products.add(new Product(88,"HP Printer",19000.00,"computer",100));
		
		Map<String , List<Product>> mp= products.parallelStream().collect(Collectors.groupingBy(p->p.getCategory()));
		Set<String> k=mp.keySet();
		for(String s:k) {
			System.out.println(s);
			List<Product> pds=mp.get(s);
			pds.forEach(p->System.out.println(p.getName()));
		}
		
		mp.forEach((ke,v)->{
			System.out.println(ke);
			v.forEach(p->System.out.println(p.getName()));
		});
		/*Collections.sort(products,
				(a,b)->Integer.compare(a.getId(), b.getId()));
		
		Iterator<Product> i= products.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().getId());
		}*/
		//products.parallelStream().filter(p->p.getCategory().equals("mobile")).forEach(p->System.out.println(p));
//		List <String> pnames=products.parallelStream().map(p->p.getName()).collect(Collectors.toList());
//		for(String s:pnames) System.out.println(s);
		
//		double total=products.stream().map(p->p.getPrice()).reduce(0.0,(a,b)->a+b);
//		System.out.println(total);
		double total=products.stream().map(p->p.getPrice()).reduce(0.0,(a,b)->a+b);
		System.out.println(total);
	}

}
