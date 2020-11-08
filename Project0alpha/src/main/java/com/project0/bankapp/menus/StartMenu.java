package com.project0.bankapp.menus;

import java.util.Scanner;

public class StartMenu {
	static Scanner input = new Scanner(System.in);
	
	public static void startMenu() {
		System.out.println("Hello, Welcome to Bank\nPlease enter a selection\n1.\tCustomer menu\n2.\tEmployee menu\n3.\tQuit");
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			CustomerMenu.customerStartMenu();
			break;
		case 2:
			EmployeeMenu.employeeStartMenu();
			break;
		case 3:
			System.out.println("Thank you for using Bank.  Goodbye");
			break;
		default:
			System.out.println("Please enter a valid selection");
			startMenu();
			break;
		}
	}
}
