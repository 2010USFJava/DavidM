package com.project0.bankapp.actions;

import java.util.List;
import com.project0.bankapp.beans.Account;
import com.project0.util.Directory;
import com.project0.util.Filer;

public class AdminDoes {
	private AdminDoes() {
		super();
	}
	public static void takeMonies(Account b, double d) {
		double balance = b.getBalance();
		double newMoney = d;
		balance = balance + newMoney;
		b.setBalance(balance);
		Filer.writeAccountFile(Directory.accountList);
	}
	public static void giveMonies(Account b, double scan) {
		double balance = b.getBalance();
		double newMoney = scan;
		if (balance > newMoney) {
			balance = balance - newMoney;
		} else {
			System.out.println("Not enough to withdraw");
		}
		b.setBalance(balance);
		Filer.writeAccountFile(Directory.accountList);
	}
	public static void moveMonies(Account source, Account target, double scan) {
		double sourceBalance = source.getBalance();
		double targetBalance = target.getBalance();
		double transfer = scan;
		if(sourceBalance > targetBalance && sourceBalance > transfer) {
			targetBalance = targetBalance + transfer;
			sourceBalance = sourceBalance - transfer;
		}
		else {
			System.out.println("Not enough to transfer");
		}
		source.setBalance(sourceBalance);
		target.setBalance(targetBalance);
		Filer.writeAccountFile(Directory.accountList);
	}
	public static void cancelAccount(Account account) {
		List<Account> a = Directory.getAccountList();
		a.remove(account);
	}
}
