package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;


@Repository
public class ProductDaoJpaImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Product> getProducts() {
		String s= "from Product";
		TypedQuery<Product> t= em.createQuery(s,Product.class);
		return t.getResultList();
	}

	public Product getProduct(int id) {
		
		return em.find(Product.class, id);
	}

	public int addProduct(Product p) {
		em.persist(p);
		return p.getId();
	}

}
