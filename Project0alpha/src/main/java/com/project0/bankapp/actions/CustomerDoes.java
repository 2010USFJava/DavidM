package com.project0.bankapp.actions;

import java.util.Scanner;

import com.project0.bankapp.beans.Account;
import com.project0.bankapp.beans.Customer;

public class CustomerDoes {
	private CustomerDoes() {
		super();
	}
	public static void viewAccount(Account a) {
		System.out.println(a.toString());
	}
	public static void takeMonies(Customer a, Account b, double d) {
		double balance = b.getBalance();
		double newMoney = a.getCustomerActions().deposit(d);
		balance = balance + newMoney;
		b.setBalance(balance);
	}
	public static void giveMonies(Customer a, Account b, double withdraw) {
		double balance = b.getBalance();
		double newMoney = a.getCustomerActions().withdraw(withdraw);
		if (balance > newMoney) {
			balance = balance - newMoney;
		} else {
			System.out.println("Not enough to withdraw");
		}
		b.setBalance(balance);
	}
	public static void moveMonies(Customer a, Account source, Account target, double transfer2) {
		double sourceBalance = source.getBalance();
		double targetBalance = target.getBalance();
		double transfer = a.getCustomerActions().transfer(transfer2);
		if(sourceBalance > targetBalance && sourceBalance > transfer) {
			targetBalance = targetBalance + transfer;
			sourceBalance = sourceBalance - transfer;
		}
		else {
			System.out.println("Not enough to withdraw");
		}
		source.setBalance(sourceBalance);
		target.setBalance(targetBalance);
	}
}
