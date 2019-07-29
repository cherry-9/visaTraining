package com.visa.prj.client;

import com.visa.prj.entity.Account;

public class AcountClient {

	
	public static void main(String[] args) {

		Account acc1 =new Account();
		Account acc2 =new Account();
		acc1.deposit(100);
		acc2.deposit(400);
		//request for gc
		System.gc();
		
		System.out.println("bal in acc 1 :"+ acc1.getBalance());

		System.out.println("bal in acc 2 :"+ acc2.getBalance());
		
	}

}
