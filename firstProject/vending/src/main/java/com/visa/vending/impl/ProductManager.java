package com.visa.vending.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.visa.vending.entity.Product;
import com.visa.vending.entity.Transaction;
import com.visa.vending.utility.ConnectionHelper;

public class ProductManager {

	public static void main(String[] args) {
		
		List<Product> list=new ArrayList<>();
		
		list.add(new Product("Lays", 25.0, 9, 1));
		list.add(new Product("FunFlips", 10.0, 10, 2));
		list.add(new Product("Kurkure", 35.0, 20, 3));
		
		//a new transaction to vend product
		Transaction t1=new Transaction(1, 2);
		
//		list.forEach(p->{
//			if(p.getId()==t1.getProductId()
//					&& p.getQty()>t1.getQty()) {
//				p.setQty(p.getQty()-t1.getQty());
//				System.out.println("transaction succes");
//			}
//		});
//		
		list.forEach(p->{
			addRow(p);
		});
		List<Product> ls=showAll();
		System.out.println(ls);
	}
	
	public static Product addRow(Product p) {
		//Product p1=null;
		try(Connection c=ConnectionHelper.getConnection()){
			PreparedStatement ps=c.prepareStatement("insert into "
					+ " product (product_name, product_price, product_qty) values(?,?,?) ",Statement.RETURN_GENERATED_KEYS); 
				
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQty());
			
			ps.execute();
			
			ResultSet rs=ps.getGeneratedKeys();
			rs.next();
			p.setId(rs.getInt(1));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
		
	}
	
	public static List<Product> showAll() {
		List<Product> list=new ArrayList<>();
		try(Connection c=ConnectionHelper.getConnection()){
			ResultSet rs=c.createStatement().executeQuery("select * from product;");
			while(rs.next()) {
				Product newP=getRow(rs);
				list.add(newP);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;	
		
	}

	private static Product getRow(ResultSet rs) throws SQLException {
		Product p=new Product(rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(1));
		return p;
	}
	
	

}
