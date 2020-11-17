package com.project0part2.beans;

public class Account {
	private int bankAccountID;
	private String accountType;
	private int userID;
	private double balance;
	public Account() {
		super();
	}
	public Account(int bankAccountID, String accountType, int userID, double balance) {
		super();
		this.bankAccountID = bankAccountID;
		this.accountType = accountType;
		this.userID = userID;
		this.balance = balance;
	}
	public int getBankAccountID() {
		return bankAccountID;
	}
	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [bankAccountID=" + bankAccountID + ", accountType=" + accountType + ", userID=" + userID
				+ ", balance=" + balance + "]";
	}
}
