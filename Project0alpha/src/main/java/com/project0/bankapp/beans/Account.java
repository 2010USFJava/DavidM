package com.project0.bankapp.beans;

public class Account {
	private String type;
	private long accountNo;
	private double balance;
	Customer primary;
	Customer secondary;
	public Account() {
		super();
	}
	public Account(String type, long accountNo, double balance, Customer primary) {
		super();
		this.type = type;
		this.accountNo = accountNo;
		this.balance = balance;
		this.primary = primary;
	}
	public Account(String type, long accountNo, double balance, Customer primary, Customer secondary) {
		super();
		this.type = type;
		this.accountNo = accountNo;
		this.balance = balance;
		this.primary = primary;
		this.secondary = secondary;
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
		return "Account [type=" + type + ", accountNo=" + accountNo + ", balance=" + balance + ", primary=" + primary
				+ ", secondary=" + secondary + "]";
	}


}
