package com.visa.training.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCProductDao {

	public List<Product> findAll() {
		List<Product> list=new ArrayList<Product>();

		try (Connection c = ConnectionHelper.getConnection()) {
			Statement s=c.createStatement();
			ResultSet r= s.executeQuery("select * from product");
			
			while(r.next()) {
				Product p=mapRow(r);
				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Product findById(int id) {
		
		Product p=null;

		try (Connection c = ConnectionHelper.getConnection()) {
			Statement s=c.createStatement();
			ResultSet r= s.executeQuery("select * from product where product_id="+id);
			
			if(r.next()) {
				p = mapRow(r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	private Product mapRow(ResultSet r) throws SQLException {
		Product p;
		p=new Product();
		p.setId(r.getInt(1));
		p.setName(r.getString(2));
		p.setPrice(r.getFloat(3));
		p.setQty(r.getInt(4));
		return p;
	}

	public Product save(Product p) {

		try (Connection c = ConnectionHelper.getConnection()) {
			PreparedStatement ps=c.prepareStatement("insert into product(product_name,"
					+ "product_price,product_qty) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, p.getName());
			ps.setFloat(2, p.getPrice());
			ps.setInt(3, p.getQty());
			ps.execute();
			
			ResultSet r=ps.getGeneratedKeys();
			r.next();
			p.setId(r.getInt(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;

	}
	

}
