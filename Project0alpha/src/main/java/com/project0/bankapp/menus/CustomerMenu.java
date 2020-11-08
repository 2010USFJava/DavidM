package com.project0.bankapp.menus;

import java.util.Scanner;

import com.project0.bankapp.actions.CustomerDoes;
import com.project0.bankapp.beans.Account;
import com.project0.bankapp.beans.Customer;
import com.project0.util.Directory;

public class CustomerMenu {
	static Scanner input = new Scanner(System.in);
	
	public static void customerStartMenu() {
		System.out.println("Please enter a selection\n1.\tExisting Customer\n2.\tNew Customer\n3.\tBack\n4.\tQuit");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			//existingCustomer();
			break;
		case 2:
			//newCustomer();
			break;
		case 3:
			StartMenu.startMenu();
			break;
		case 4:
			System.out.println("Thank you for using Bank. Goodbye");
			break;
		default:
			System.out.println("Please enter a valid selection");
			customerStartMenu();
			break;
		}
	}
	
	public static void existingCustomer() {
		System.out.println("Please enter your customer email");
		String login = input.nextLine();
		Customer existingCustomer = Directory.findCustomerByEmail(login);
		System.out.println("Hello" + existingCustomer.getFirstName()+"\nPlease enter your password");
		String password = input.nextLine();
		Directory.passwordChecker(password);
		System.out.println("What would you like to do");
		System.out.println("1.\tView account\n2.\tDeposit\n3.\tWithdraw\n4.\tTransfer\n5.\tQuit");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter account ID");
			long accountNo = input.nextLong();
			Account a = Directory.findAccountByNumber(accountNo);
			CustomerDoes.viewAccount(a);
			existingCustomer();
			break;
		case 2:
			System.out.println("Enter account ID");
			long accountNo2 = input.nextLong();
			Account b = Directory.findAccountByNumber(accountNo2);
			System.out.println("How much would you like to deposit?");
			CustomerDoes.takeMonies(existingCustomer, b, input.nextDouble());
			existingCustomer();
			break;
		case 3:
			System.out.println("Enter account ID");
			long accountNo3 = input.nextLong();
			Account e = Directory.findAccountByNumber(accountNo3);
			System.out.println("How much would you like to withdraw?");
			double withdraw = input.nextDouble();
			CustomerDoes.giveMonies(existingCustomer, e, withdraw);
			existingCustomer();
			break;
		case 4:
			System.out.println("Enter source account ID");
			long sourceAccount = input.nextLong();
			Account c = Directory.findAccountByNumber(sourceAccount);
			System.out.println("Enter target account ID");
			long targetAccount = input.nextLong();
			Account d = Directory.findAccountByNumber(targetAccount);
			System.out.println("How much would you like to transfer");
			double transfer = input.nextDouble();
			CustomerDoes.moveMonies(existingCustomer, c, d, transfer);
			existingCustomer();
			break;
		case 5:
			System.out.println("Thank you for using Bank.  Goodbye");
			break;
		default:
			System.out.println("Please enter a valid selection");
			break;
	}
	}
}
