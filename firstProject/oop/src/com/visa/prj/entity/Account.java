package com.visa.prj.entity;
/**
 * Class for Account buss. data
 * does debit, credit amount
 * @author root
 * @version 1.0
 *
 */
public class Account {
	
	public Account(float balance) {
		this.balance = balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	private float balance;
	/**
	 * method to credit amt
	 * @param amt amount to be credited
	 */
	public void deposit(float amt) {
		balance+=amt;
	}
	/**
	 * method to get bal
	 * @return current balance
	 */
	public float getBalance() {
		return balance;
	}
	
	public Account() {}

}
