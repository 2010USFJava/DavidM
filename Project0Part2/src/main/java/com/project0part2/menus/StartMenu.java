package com.project0part2.menus;

import java.io.IOException;
import java.util.Scanner;

public class StartMenu {
	static Scanner input = new Scanner(System.in);
	
	public static void startMenu() throws IOException {
		System.out.println("Hello, Welcome to Bankius Maximus\nPlease enter a selection\n1.\tCustomer menu\n2.\tEmployee menu\n3.\tQuit");
		int choice = Integer.parseInt(input.nextLine());
		switch(choice) {
		case 1:
			UserMenu.userStartMenu();
			break;
		case 2:
			AdminMenu.adminStartMenu();
			break;
		case 3:
			System.out.println("Thank you for using Bankius Maximus.  Goodbye");
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid selection");
			startMenu();
			break;
		}
	}
}
