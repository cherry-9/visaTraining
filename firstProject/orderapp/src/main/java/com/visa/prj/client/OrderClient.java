package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

public class OrderClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
	ctx.scan("com.visa.prj");
	ctx.refresh();
	
	OrderService os= ctx.getBean("osd", OrderService.class);
	
//	Order o= new Order();
//	
//	Product  p1=os.getById(1);
//	
//	Product p2 = os.getById(3);
//	Item i1 = new Item();
//	
//	i1.setProduct(p1);
//	i1.setQty(1);
//	i1.setAmount(p1.getPrice() * i1.getQty());
//	
//	o.getItems().add(i1);
//	
//	Item i2 = new Item();
//	i2.setProduct(p2);
//	i2.setQty(1);
//	i2.setAmount(p2.getPrice() * i2.getQty());
//	
//	o.getItems().add(i2);
//	
//	Customer c=new Customer();
//	c.setEmail("bhanu@google.com");
//	o.setCustomer(c);
//	
//	os.insertOrder(o);	
//	List<Order> ls=os.getAllOrders();
//	
//	ls.forEach(System.out::println);
//	}
	
	List<Order> ls=os.getAllOrders();
	
	ls.forEach(System.out::println);
	}
	
	

}
