package com.project0.bankapp.beans;

import java.io.Serializable;

import com.project0.util.Directory;
import com.project0.util.Filer;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8362630857749471234L;
	private String type;
	private long accountNo;
	private double balance;
	Customer primary;
	Customer secondary;
	public Account() {
		super();
		Directory.accountList.add(this);
		Filer.writeAccountFile(Directory.accountList);
	}
	public Account(String type, long accountNo, double balance, Customer primary) {
		super();
		this.type = type;
		this.accountNo = accountNo;
		this.balance = balance;
		this.primary = primary;
		Directory.accountList.add(this);
		Filer.writeAccountFile(Directory.accountList);
	}
	public Account(String type, long accountNo, double balance, Customer primary, Customer secondary) {
		super();
		this.type = type;
		this.accountNo = accountNo;
		this.balance = balance;
		this.primary = primary;
		this.secondary = secondary;
		Directory.accountList.add(this);
		Filer.writeAccountFile(Directory.accountList);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getPrimary() {
		return primary;
	}
	public void setPrimary(Customer primary) {
		this.primary = primary;
	}
	public Customer getSecondary() {
		return secondary;
	}
	public void setSecondary(Customer secondary) {
		this.secondary = secondary;
	}
	@Override
	public String toString() {
		return type + " account " + accountNo + " has $" + balance + ".  Primary account holder: " + primary + ".  Secondary account holder: " + secondary;
	}


}
