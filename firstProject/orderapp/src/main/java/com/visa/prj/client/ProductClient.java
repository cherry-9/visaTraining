package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

public class ProductClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("app.xml");
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		OrderService os= ctx.getBean("osd",OrderService.class);
		
		Product p=new Product(0,"mouse","computer",1000.0,100);
		os.insertProduct(p);
		
		p=os.getById(1);
		
		
		System.out.println(p.getName());
		
		List<Product> l=os.getAll();
		l.forEach(System.out::println);
	}

}
