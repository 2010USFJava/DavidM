package com.project0.bankapp.actions;

import com.project0.bankapp.beans.Account;
import com.project0.util.Directory;
import com.project0.util.Filer;

public class CustomerDoes {
	public CustomerDoes() {
		super();
	}
	public static void viewAccount(Account a) {
		System.out.println(a.toString());
	}
	public static void takeMonies(Account b, double d) {
		double balance = b.getBalance();
		double newMoney = d;
		balance = balance + newMoney;
		b.setBalance(balance);
		Filer.writeAccountFile(Directory.accountList);
	}
	public static void giveMonies(Account b, double withdraw) {
		double balance = b.getBalance();
		double newMoney = withdraw;
		if (balance > newMoney) {
			balance = balance - newMoney;
		} else {
			System.out.println("Not enough to withdraw");
		}
		b.setBalance(balance);
		Filer.writeAccountFile(Directory.accountList);
	}
	public static void moveMonies(Account source, Account target, double transfer) {
		double sourceBalance = source.getBalance();
		double targetBalance = target.getBalance();
		double transferAmt = transfer;
		if(sourceBalance > transferAmt) {
			targetBalance = targetBalance + transferAmt;
			sourceBalance = sourceBalance - transferAmt;
			source.setBalance(sourceBalance);
			target.setBalance(targetBalance);
		}
		else {
			System.out.println("Not enough to withdraw");
		}
		Filer.writeAccountFile(Directory.accountList);
	}
}
