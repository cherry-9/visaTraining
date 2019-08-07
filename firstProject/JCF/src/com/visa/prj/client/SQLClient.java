package com.visa.prj.client;

import com.visa.prj.entity.Product;
import com.visa.prj.util.SQLUtil;

public class SQLClient{
	public static void main(String[] args) {
//
		String create_sql=SQLUtil.generateCreateTable(Product.class);
		System.out.println(create_sql);
		
		Product p=new Product(1,"moto",1000.0,"mobile",9);
		String s=SQLUtil.genInsertSQL(p);
		System.out.println(s);
	}

}
