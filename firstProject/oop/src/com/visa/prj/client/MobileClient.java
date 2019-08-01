package com.visa.prj.client;

import com.visa.prj.dao.MobileDao;
import com.visa.prj.dao.MobileDaoFactory;
import com.visa.prj.dao.impl.MobileDaoDbImpl;
import com.visa.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args) {
		Mobile m=new Mobile();
		//set m from input fields
		//MobileDao mobileDao=new MobileDaoDbImpl();
		MobileDao mobileDao=MobileDaoFactory.getMobileDao();
		mobileDao.addMobile(m);
	}

}