package com.project0part2.menus;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project0part2.beans.Account;
import com.project0part2.beans.Admin;
import com.project0part2.beans.User;
import com.project0part2.dao.AccountDao;
import com.project0part2.dao.AdminDao;
import com.project0part2.dao.UserDao;
import com.project0part2.daoimpl.AccountDaoImpl;
import com.project0part2.daoimpl.AdminDaoImpl;
import com.project0part2.daoimpl.UserDaoImpl;

public class AdminMenu {
	static Scanner input = new Scanner(System.in);
	
	public static void adminStartMenu() throws IOException {
		System.out.println("Please enter a selection\n1.\tExisting Admin\n2.\tNew Admin\n3.\tBack\n4.\tQuit");
		int choice = Integer.parseInt(input.nextLine());
		switch(choice) {
		case 1:
			existingAdmin();
			break;
		case 2:
			newAdmin();
			break;
		case 3:
			StartMenu.startMenu();
			break;
		case 4:
			System.out.println("Thank you for Bankius Maximus. Goodbye");
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid selection");
			adminStartMenu();
			break;
		}
	}
	
	public static void newAdmin() throws IOException {
		System.out.println("Please enter your first name");
		String fName = input.nextLine();
		System.out.println("Please enter your last name");
		String lName = input.nextLine();
		System.out.println("Please enter your desired user name");
		String username = input.nextLine();
		System.out.println("Please enter a password");
		String password = input.nextLine();
		AdminDao ad = new AdminDaoImpl();
		try {
			ad.addAdmin(fName, lName, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Admin created successfully");
		adminStartMenu();
	}
	
	public static void existingAdmin() throws IOException {
		System.out.println("Please enter your username");
		String login = input.nextLine();
		System.out.println("Please enter your password");
		String password = input.nextLine();
		AdminDao ad = new AdminDaoImpl();
		try {
			Admin admin = ad.passwordChecker(login, password);
			verifiedAdmin(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Login info incorrect");
			existingAdmin();
		}
	}
	
	public static void verifiedAdmin(Admin admin) throws IOException {
		System.out.println("Hello " + admin.getfName() + ", what would you like to do?\n1.\tView Accounts\n2.\tCreate User\n3.\tUpdate user\n4.\tDelete user\n5.\tLogout");
		int choice = Integer.parseInt(input.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Search by\n1.\tUser\n2.\tAccount");
			int viewChoice = Integer.parseInt(input.nextLine());
			switch(viewChoice) {
			case 1:
				System.out.println("Enter username");
				String userChoice = input.nextLine();
				UserDao ud = new UserDaoImpl();
				AccountDaoImpl ad = new AccountDaoImpl();
				try {
					User viewUser = ud.retrieveByUsername(userChoice);
					List<Account> aList = (ArrayList<Account>) ad.getAllAccounts(viewUser.getUserID());
					System.out.println(viewUser.toString() + "\n" + aList.toString());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				verifiedAdmin(admin);
				break;
			case 2:
				System.out.println("Enter account number");
				int accountChoice = Integer.parseInt(input.nextLine());
				AccountDaoImpl ada = new AccountDaoImpl();
				UserDao uda = new UserDaoImpl();
				try {
					Account viewAccount = ada.retrieveAccountByID(accountChoice);
					User viewUser = uda.retrieveByAccounts(viewAccount.getUserID());
					System.out.println(viewAccount.toString() +"\n"+viewUser.toString());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				verifiedAdmin(admin);
				break;
			default:
				System.out.println("Please enter a valid selection");
				verifiedAdmin(admin);
				break;
			}
			verifiedAdmin(admin);
			break;
		case 2:
			System.out.println("Please enter a desired username");
			String username = input.nextLine();
			System.out.println("Please enter password");
			String password = input.nextLine();
			System.out.println("Please enter your first name");
			String fName = input.nextLine();
			System.out.println("Please enter your last name");
			String lName = input.nextLine();
			UserDao ud = new UserDaoImpl();
			try {
				ud.enterUser(username, password, fName, lName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("User created successfully");
			verifiedAdmin(admin);
			break;
		case 3:
			System.out.println("Enter User Id you would wish to update");
			int userID = Integer.parseInt(input.nextLine());
			UserDao uda = new UserDaoImpl();
			try {
				System.out.println("What would you like to update?\n1.\tUsername\n2.\tPassword\n3.\tFirst Name\n4.\tLast Name\n5.\tBack");
				int userChoice = Integer.parseInt(input.nextLine());
				switch (userChoice) {
				case 1:
					System.out.println("What is the new username?");
					String newUsername = input.nextLine();
					uda.updateUsername(newUsername, userID);
					System.out.println("Username updated to " + newUsername);
					verifiedAdmin(admin);
					break;
				case 2:
					System.out.println("What is the new password?");
					String newPassword = input.nextLine();
					uda.updatePassword(newPassword, userID);
					System.out.println("Password updated to " + newPassword);
					verifiedAdmin(admin);
					break;
				case 3:
					System.out.println("What is the new first name?");
					String newFName = input.nextLine();
					uda.updateFName(newFName, userID);
					System.out.println("First name updated to " + newFName);
					verifiedAdmin(admin);
					break;
				case 4:
					System.out.println("What is the new last name?");
					String newLName = input.nextLine();
					uda.updateLName(newLName, userID);
					System.out.println("Last name updated to " + newLName);
					verifiedAdmin(admin);
					break;
				case 5:
					verifiedAdmin(admin);
					break;
				default:
					System.out.println("Please enter a valid selection");
					verifiedAdmin(admin);
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			verifiedAdmin(admin);
			break;
		case 4:
			System.out.println("In order to delete user, their account balance needs to be at $0, proceed?\n1.\tYes\n2.\tNo");
			int deletePreReq = Integer.parseInt(input.nextLine());
			if (deletePreReq == 1) {
				System.out.println("Enter user you want to delete");
				String userDelete = input.nextLine();
				UserDao udDelete = new UserDaoImpl();
				AccountDao accountEligible = new AccountDaoImpl();
				try {
					User userDeletePending = udDelete.retrieveByUsername(userDelete);
					List<Account> aList = (ArrayList<Account>) accountEligible.getAllAccounts(userDeletePending.getUserID());
					for (Account account : aList) {
						if (account.getBalance()==0) {
							accountEligible.deleteAccount(account.getBankAccountID());
						} else {
							System.out.println("User is not eligible to be erased");
							verifiedAdmin(admin);
						}
					}
					udDelete.exterminateUser(userDeletePending.getUsername());
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					verifiedAdmin(admin);
				}

			} else if (deletePreReq == 2) {
				System.out.println("Returning to menu");
				verifiedAdmin(admin);
			} else {
				System.out.println("Not a valid selection\nReturning to menu");
				verifiedAdmin(admin);
			}
			verifiedAdmin(admin);
			break;
		case 5:
			StartMenu.startMenu();
			break;
		default:
			System.out.println("Please enter a valid selection");
			break;
		}
	}
}
