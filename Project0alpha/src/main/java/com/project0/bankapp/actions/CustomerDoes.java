package com.project0.bankapp.actions;

import java.util.Scanner;

import com.project0.bankapp.beans.Account;
import com.project0.bankapp.beans.Customer;

public class CustomerDoes {
	private CustomerDoes() {
		super();
	}
	public static void takeMonies(Customer a, Account b, Scanner scan) {
		double balance = b.getBalance();
		double newMoney = a.getCustomerActions().deposit(scan);
		balance = balance + newMoney;
		b.setBalance(balance);
	}
	public static void giveMonies(Customer a, Account b, Scanner scan) {
		double balance = b.getBalance();
		double newMoney = a.getCustomerActions().withdraw(scan);
		if (balance > newMoney) {
			balance = balance - newMoney;
		} else {
			System.out.println("Not enough to withdraw");
		}
		b.setBalance(balance);
	}
	public static void moveMonies(Customer a, Account source, Account target, Scanner scan) {
		double sourceBalance = source.getBalance();
		double targetBalance = target.getBalance();
		double transfer = a.getCustomerActions().transfer(scan);
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
