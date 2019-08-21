package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Order;


@Repository
public class OrderDaoJpaImpl implements OrderDao {
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public void placeOrder(Order o) {
		em.persist(o);

	}

	@Override
	public List<Order> getAllOrders() {
		String s= "select o from Order o";
		TypedQuery<Order> t= em.createQuery(s,Order.class);
		return t.getResultList();
	}

	@Override
	public List<Order> getOrdersByCustomer(Customer c) {
		String s= "select o from Order o where o.customer = :c ";
		TypedQuery<Order> t= em.createQuery(s,Order.class);
		t.setParameter("c", c);
		return t.getResultList();
	}

}
