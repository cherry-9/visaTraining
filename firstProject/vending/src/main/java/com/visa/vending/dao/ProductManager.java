package com.visa.vending.dao;

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
		Transaction t=new Transaction(6, 2);
		
//		list.forEach(p->{
//			if(p.getId()==t1.getProductId()
//					&& p.getQty()>t1.getQty()) {
//				p.setQty(p.getQty()-t1.getQty());
//				System.out.println("transaction succes");
//			}
//		});
////	add products from list to table	
//		list.forEach(p->{
//			addRow(p);
//		});
		
		//delete a product by id
		deleteById(1);
		
		//make a purchase if is it is safe
		if( findById(t.getProductId())!=null && getQtyById(t.getProductId())-t.getQty()>=0) {
			updateQtyById(getQtyById(t.getProductId())-t.getQty(), t.getProductId());
		}
		else {
			System.out.println("failure -> not enough qty || product id invalid ");
		}
		
		System.out.println(getQtyById(3));

		
		//see status of table
		List<Product> ls=showAll();
		ls.forEach(System.out::println);
		
	}
	
	
	//method to return product object from table by id and null if absent
	public static Product findById(int id) {
		Product p=null;
		try(Connection c=ConnectionHelper.getConnection()){
			PreparedStatement ps=c.prepareStatement("select * from product where product_id = ?"); 
				
			ps.setInt(1, id);			
					
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				p=getRow(rs);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
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
	
	public static void deleteById(int id) {
		try(Connection c=ConnectionHelper.getConnection()){
			c.createStatement().executeUpdate("delete from product where product_id = "+id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//method assumes that qtyToset is safe
	public static void updateQtyById(int qtyToSet, int id) {
		try(Connection c=ConnectionHelper.getConnection()){
			PreparedStatement ps=c.prepareStatement("update product set product_qty =? where product_id=?");
			ps.setInt(1, qtyToSet);
			ps.setInt(2, id);
			ps.execute();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//method to return qty by id
	public static int getQtyById(int id) {
		int res=-1;
		try(Connection c=ConnectionHelper.getConnection()){
			PreparedStatement ps=c.prepareStatement("select product_qty from product where product_id=?");
			ps.setInt(1, id);
			//ps.execute();
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=rs.getInt(1);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	//method to get a product object from result set
	private static Product getRow(ResultSet rs) throws SQLException {
		Product p=new Product(rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(1));
		return p;
	}
	
	

}
