package com.project0.bankapp.menus;

import java.util.Scanner;

import com.project0.bankapp.actions.CustomerDoes;
import com.project0.bankapp.beans.Account;
import com.project0.bankapp.beans.Customer;
import com.project0.bankapp.beans.Employee;
import com.project0.util.Directory;
import com.project0.util.LogThis;

public class CustomerMenu {
	static Scanner input = new Scanner(System.in);
	
	public static void customerStartMenu() {
		System.out.println("Please enter a selection\n1.\tExisting Customer\n2.\tNew Customer\n3.\tBack\n4.\tQuit");
		int choice = Integer.parseInt(input.nextLine());
		switch (choice) {
		case 1:
			existingCustomer();
			break;
		case 2:
			newCustomer();
			break;
		case 3:
			StartMenu.startMenu();
			break;
		case 4:
			System.out.println("Thank you for using Bank. Goodbye");
			System.exit(0);
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
		int choice = Integer.parseInt(input.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Enter account ID");
			long accountNo = Long.parseLong(input.nextLine());
			Account a = Directory.findAccountByNumber(accountNo);
			CustomerDoes.viewAccount(a);
			existingCustomer();
			break;
		case 2:
			System.out.println("Enter account ID");
			long accountNo2 = Long.parseLong(input.nextLine());
			Account b = Directory.findAccountByNumber(accountNo2);
			System.out.println("How much would you like to deposit?");
			double deposit = Double.parseDouble(input.nextLine());
			CustomerDoes.takeMonies(b, deposit);
			LogThis.LogIt("info", "deposit executed");
			existingCustomer();
			break;
		case 3:
			System.out.println("Enter account ID");
			long accountNo3 = Long.parseLong(input.nextLine());
			Account e = Directory.findAccountByNumber(accountNo3);
			System.out.println("How much would you like to withdraw?");
			double withdraw = Double.parseDouble(input.nextLine());
			CustomerDoes.giveMonies(e, withdraw);
			LogThis.LogIt("info", "withdraw executed");
			existingCustomer();
			break;
		case 4:
			System.out.println("Enter source account ID");
			long sourceAccount = Long.parseLong(input.nextLine());
			Account c = Directory.findAccountByNumber(sourceAccount);
			System.out.println("Enter target account ID");
			long targetAccount = Long.parseLong(input.nextLine());
			Account d = Directory.findAccountByNumber(targetAccount);
			System.out.println("How much would you like to transfer");
			double transfer = Double.parseDouble(input.nextLine());
			CustomerDoes.moveMonies(c, d, transfer);
			LogThis.LogIt("info", "transfer executed");
			existingCustomer();
			break;
		case 5:
			System.out.println("Thank you for using Bank.  Goodbye");
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid selection");
			break;
		}
	}
	
	public static void newCustomer() {
		System.out.println("Thank you for choosing Bank\nPlease enter your first name");
		String firstName = input.nextLine();
		System.out.println("Enter your last name");
		String lastName = input.nextLine();
		System.out.println("Enter your email address");
		String email = input.nextLine();
		System.out.println("Enter a desired password");
		String password = input.nextLine();
		System.out.println("Please hold for employee verification\nEmployee please login");
		long login = Long.parseLong(input.nextLine());
		Employee employee = Directory.findEmployeeByID(login);
		System.out.println("Thank you " + employee.getFirstName() + " , please enter your password");
		String verify = input.nextLine();
		Directory.employeePassword(verify);
		System.out.println("Would you like to accept " + firstName + " " + lastName + "'s application?");
		System.out.println("Enter true for yes, false for no");
		boolean accept = Boolean.parseBoolean(input.nextLine());
		if(accept == true) {
			Customer applicant = new Customer(firstName, lastName, email, password, null);
			LogThis.LogIt("info", applicant.getEmail() + " application was submitted");
			System.out.println("Application submitted successfully" + applicant.toString());
		} else {
			System.out.println("Sorry, your application cannot be processed at this time.  Goodbye");
			StartMenu.startMenu();
		}
		Customer applicant = new Customer(firstName, lastName, email, password, null);
		System.out.println("Would you like to create a joint account?\n1.\tYes\n2.\tNo");
		int choice = Integer.parseInt(input.nextLine());
		if (choice == 1) {
			System.out.println("Enter the co-applicants first name");
			String firstName2 = input.nextLine();
			System.out.println("Enter last name");
			String lastName2 = input.nextLine();
			System.out.println("Enter email");
			String email2 = input.nextLine();
			System.out.println("Enter desired password");
			String password2 = input.nextLine();
			Customer coapplicant = new Customer(firstName2, lastName2, email2, password2, null);
			System.out.println("What kind of account is this?\n1.\tChecking\n2.\tSavings");
			int type = Integer.parseInt(input.nextLine());
			if(type == 1) {
				long accountNo = (long)Math.random() + System.currentTimeMillis();
				Account jointAccount = new Account("Checking", accountNo, 0, applicant, coapplicant);
				LogThis.LogIt("info", "New " + jointAccount.getType().toString() +" account " + jointAccount.getAccountNo() + " has been opened");
			} else if (type == 2) {
				long accountNo = (long)Math.random() + System.currentTimeMillis();
				Account jointAccount = new Account("Saving", accountNo, 0, applicant, coapplicant);
				LogThis.LogIt("info", "New " + jointAccount.getType().toString() +" account " + jointAccount.getAccountNo() + " has been opened");
			} else {
				System.out.println("Please enter a valid selection");
				newCustomer();
			}
		} else if (choice == 2) {
			System.out.println("What kind of account is this?\n1.\tChecking\n2.\tSavings");
			int type = Integer.parseInt(input.nextLine());
			if (type == 1) {
				long accountNo = (long)Math.random() + System.currentTimeMillis();
				Account singleAccount = new Account("Checking", accountNo, 0, applicant);
				LogThis.LogIt("info", "New " + singleAccount.getType() + " account " + singleAccount.getAccountNo() + " has been opened");
			} else if (type == 2) {
				long accountNo = (long)Math.random() + System.currentTimeMillis();
				Account singleAccount = new Account("Savings", accountNo, 0, applicant);
				LogThis.LogIt("info", "New " + singleAccount.getType() + " account " + singleAccount.getAccountNo() + " has been opened");
			} else {
				System.out.println("Not a valid selection");
				newCustomer();
			}
		}
		StartMenu.startMenu();
	}
}
