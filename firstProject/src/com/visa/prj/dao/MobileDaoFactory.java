package com.visa.prj.dao;

import java.util.ResourceBundle;

import com.visa.prj.dao.impl.MobileDaoDbImpl;

public class MobileDaoFactory {
	private static String NAME="";
	
	static {
	ResourceBundle res=ResourceBundle.getBundle("database");
	NAME=res.getString("MOBILE_CLAZZ").trim();
	}
	
	public static MobileDao getMobileDao() {
		try {
			return (MobileDao)Class.forName(NAME).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
}
