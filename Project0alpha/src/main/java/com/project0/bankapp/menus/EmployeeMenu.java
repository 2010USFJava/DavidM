package com.project0.bankapp.menus;

import java.util.Scanner;

import com.project0.bankapp.actions.AdminDoes;
import com.project0.bankapp.beans.Account;
import com.project0.bankapp.beans.Employee;
import com.project0.util.Directory;
import com.project0.util.LogThis;

public class EmployeeMenu {
	static Scanner input = new Scanner(System.in);
	
	public static void employeeStartMenu() {
		System.out.println("Please enter a selection\n1.\tExisting employee\n2.\tNew employee\n3.\tBack\n4.\tQuit");
		int choice = Integer.parseInt(input.nextLine());
		switch (choice) {
		case 1:
			existingEmp();
			break;
		case 2:
			newEmp();
			break;
		case 3:
			StartMenu.startMenu();
			break;
		case 4:
			System.out.println("Thank you for using Bank.  Goodbye");
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid selection");
			employeeStartMenu();
			break;
		}
	}
	
	public static void existingEmp() {
		System.out.println("Bank login portal\nPlease enter your EID");
		long login = Long.parseLong(input.nextLine());
		Employee existingEmp = Directory.findEmployeeByID(login);
		System.out.println("Welcome " + existingEmp.getFirstName()+ ", please enter your password");
		String password = input.nextLine();
		Directory.employeePassword(password);
		if (existingEmp.isAdmin() == false) {
			System.out.println("Please enter Account Number you wish to view");
			long accountNo = Long.parseLong(input.nextLine());
			Account account = Directory.findAccountByNumber(accountNo);
			System.out.println(account.toString());
			StartMenu.startMenu();
		}
		else {
			System.out.println("What would you like to do\n1.\tView Account\n2.\tWithdraw\n3.\tDeposit\n4.\tTransfer\n5.\tCancel Account"
					+ "\n6.\tQuit");
			int choice = Integer.parseInt(input.nextLine());
			switch(choice) {
			case 1:
				System.out.println("Please enter Account Number");
				long accountNo = Long.parseLong(input.nextLine());
				Account account = Directory.findAccountByNumber(accountNo);
				System.out.println(account.toString());
				existingEmp();
				break;
			case 2:
				System.out.println("Please enter Account Number");
				long accountWithdraw = Long.parseLong(input.nextLine());
				Account withdrawAccount = Directory.findAccountByNumber(accountWithdraw);
				System.out.println("How much would you like to withdraw?");
				double withdraw = Double.parseDouble(input.nextLine());
				AdminDoes.giveMonies(withdrawAccount, withdraw);
				LogThis.LogIt("info", "Amount $" + withdraw + " has been taken from account" + withdrawAccount.getAccountNo());
				existingEmp();
				break;
			case 3:
				System.out.println("Please enter Account Number");
				long accountDeposit = Long.parseLong(input.nextLine());
				Account depositAccount = Directory.findAccountByNumber(accountDeposit);
				System.out.println("How much would you like to deposit?");
				double deposit = Double.parseDouble(input.nextLine());
				AdminDoes.takeMonies(depositAccount, deposit);
				LogThis.LogIt("info", "Amount $" + deposit + " has been deposited into account" + depositAccount.getAccountNo());
				existingEmp();
				break;
			case 4:
				System.out.println("Please enter source Account Number");
				long accountSource = Long.parseLong(input.nextLine());
				Account sourceAccount = Directory.findAccountByNumber(accountSource);
				System.out.println("Please enter target Account Number");
				long accountTarget = Long.parseLong(input.nextLine());
				Account targetAccount = Directory.findAccountByNumber(accountTarget);
				System.out.println("How much do you want to transfer?");
				double transfer = Double.parseDouble(input.nextLine());
				AdminDoes.moveMonies(sourceAccount, targetAccount, transfer);
				LogThis.LogIt("info", "Amount $" + transfer + " has been moved from " + sourceAccount.getAccountNo() + " to " + targetAccount.getAccountNo());
				existingEmp();
				break;
			case 5:
				System.out.println("Please enter Account Number");
				long accountClose = Long.parseLong(input.nextLine());
				Account closeAccount = Directory.findAccountByNumber(accountClose);
				AdminDoes.cancelAccount(closeAccount);
				LogThis.LogIt("info", "Account " + closeAccount.getAccountNo() +"has been closed");
				System.out.println("Well that's fantastic, a really smart decision, young man. We can put that check in a Money Market "
						+ "Mutual Fund, then we'll reinvest the earnings into foreign\ncurrency accounts with compounding interest aaaaand it's gone");
				existingEmp();
				break;
			case 6:
				System.out.println("Thank you for using Bank.  Goodbye");
				System.exit(0);
				break;
			default:
				System.out.println("Please make a valid selection");
				break;
			
			}
		}
		
	}
	
	public static void newEmp() {
		System.out.println("Welcome new team member\nPlease enter your first name");
		String firstName = input.nextLine();
		System.out.println("Please enter your last name");
		String lastName = input.nextLine();
		System.out.println("Please enter a desired password");
		String password = input.nextLine();
		System.out.println("Are you an admin?\n\ttrue\n\tfalse");
		boolean admin = Boolean.parseBoolean(input.nextLine());
		long empID = (long)Math.random() + System.currentTimeMillis();
		Employee newEmployee = new Employee(firstName, lastName, empID, password, admin);
		LogThis.LogIt("info", "New employee " + newEmployee.getFirstName() + " " + newEmployee.getLastName() + " " + newEmployee.getID() + " " + "has joined the team");
		Directory.employeeList.toString();
		StartMenu.startMenu();
	}

}
