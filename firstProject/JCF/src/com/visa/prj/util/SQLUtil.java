package com.visa.prj.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

public class SQLUtil {
	public static String generateCreateTable(Class<?> c) {
		StringBuilder b=new StringBuilder();
		Table t=c.getAnnotation(Table.class);
		if(t!=null) {
			b.append(("create table "));
			b.append(t.name());
			b.append("(");
			
			Method[] m=c.getDeclaredMethods();
			for(Method me:m) {
				if(me.getName().startsWith("get")) {
					Column clm=me.getAnnotation(Column.class);
					if(clm!=null) {
						b.append(clm.name());
						b.append(" ");
						b.append(clm.type());
						b.append(", ");
					}
				}
			}
			b.setCharAt(b.lastIndexOf(","), ')');
		}
		return b.toString();
	

	}
	
	//insert into products values (prd_id=120,prd_name='iphone')
	//insert into emp values (3,'ss')
	public static String genInsertSQL(Object c) {
		StringBuilder b=new StringBuilder();
		Table t=c.getClass().getAnnotation(Table.class);
		if(t!=null) {
			b.append(("insert into "));
			b.append(t.name());
			b.append(" values (");
			
			Method[] m=c.getClass().getDeclaredMethods();
			for(Method me:m) {
				if(me.getName().startsWith("get")) {
					Column clm=me.getAnnotation(Column.class);
					if(c!=null) {
						Object ret=null;
						try {
							ret = me.invoke(c);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(ret!=null) {
							b.append(ret.toString());}
						b.append(", ");
					}
				}
			}
			b.setCharAt(b.lastIndexOf(","), ')');
		}
		return b.toString();
	


		
	}
}
