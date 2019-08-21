package com.visa.prj.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service (value="osd")
public class OrderService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public int insertProduct(Product p) {
		return productDao.addProduct(p);
	}
	
	public Product getById(int id) {
		return productDao.getProduct(id);
	}
	
	public List<Product> getAll(){
		return productDao.getProducts();
	}
	
	@Transactional
	public void insertOrder(Order o) {
		
		
		double total =0.0;
		List<Item> items = o.getItems();
		
		for(Item i:items) {
			total +=i.getAmount();
			Product p = getById(i.getProduct().getId());
			p.setCount((p.getCount() -i.getQty()));
			
		}
		o.setTotal(total);
		orderDao.placeOrder(o);
	}
	
	public List<Order> getAllOrders(){
		return orderDao.getAllOrders();
	}
	
	public List<Order> getOrdersByCustomers(Customer c){
		return orderDao.getOrdersByCustomer(c);
	}

	@Transactional
	public void placeOrder(String[] ele, String email) {
		
		List<Item> items=new ArrayList<>();			
		for(String e:ele) {
			Product pds=productDao.getProduct(Integer.parseInt(e));
			//create item object
			Item it=new Item();
			it.setProduct(pds);
			it.setQty(1);
			it.setAmount(pds.getPrice());
			items.add(it);
		
		}
		
		//now create a order
		Order o=new Order();
		o.setItems(items);
		o.setCustomer(new Customer(email));
		o.setOrderDate(new Date());
		insertOrder(o);
		
		//System.out.println(orderDao.getAllOrders().toString());
	}
	
	

}
