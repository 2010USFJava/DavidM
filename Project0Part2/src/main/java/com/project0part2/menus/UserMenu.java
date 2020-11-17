package com.project0part2.menus;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project0part2.beans.Account;
import com.project0part2.beans.LogBean;
import com.project0part2.beans.User;
import com.project0part2.dao.AccountDao;
import com.project0part2.dao.LogDao;
import com.project0part2.dao.UserDao;
import com.project0part2.daoimpl.AccountDaoImpl;
import com.project0part2.daoimpl.LogDaoImpl;
import com.project0part2.daoimpl.UserDaoImpl;
import com.project0part2.exceptions.InvalidAmount;
import com.project0part2.util.LogThis;

public class UserMenu {
	static Scanner input = new Scanner(System.in);
	
	public static void userStartMenu() throws IOException {
		System.out.println("Please enter a selection\n1.\tExisting Customer\n2.\tNew Customer\n3.\tBack\n4.\tQuit");
		int choice = Integer.parseInt(input.nextLine());
		switch (choice) {
		case 1:
			existingUser();
			break;
		case 2:
			newUser();
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
			userStartMenu();
			break;
		}
	}
	
	public static void newUser() throws IOException {
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
		userStartMenu();
	}
	
	public static void existingUser() throws IOException{
		System.out.println("Please enter your username");
		String login = input.nextLine();
		System.out.println("Please enter your password");
		String password = input.nextLine();
		UserDao ud = new UserDaoImpl();
		try {
			User user = ud.passwordChecker(login, password);
			verifiedUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidAmount e) {
			e.printStackTrace();
		} finally {
			System.out.println("Incorrect login info");
			existingUser();
		}
	}
	
	public static void verifiedUser(User user) throws InvalidAmount,IOException,SQLException {
		System.out.println("Hello " + user.getfName() + ", what would you like to do?\n1.\tCreate Account\n2.\tSelect Account\n3.\tLogout\n4.\tQuit");
		int choice = Integer.parseInt(input.nextLine());
		switch(choice) {
		case 1:
			System.out.println("What kind of account would you like to open?\n1.\tChecking\n2.\tSavings");
			int accountTypeChoice = Integer.parseInt(input.nextLine());
			switch (accountTypeChoice) {
				case 1:
					String checking = "Checking";
					System.out.println("How much would you like to deposit?");
					int deposit = Integer.parseInt(input.nextLine());
					AccountDao ad = new AccountDaoImpl();
					try {
						ad.createAccount(user, checking, deposit);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					verifiedUser(user);
					break;
				case 2:
					String savings = "Savings";
					System.out.println("How much would you like to deposit?");
					int depositSaving = Integer.parseInt(input.nextLine());
					AccountDao adSaving = new AccountDaoImpl();
				try {
					adSaving.createAccount(user, savings, depositSaving);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				verifiedUser(user);
				break;
				default:
					System.out.println("Please enter a valid selection");
					verifiedUser(user);
					break;
				}
			break;
		case 2:
			System.out.println("What would you like to do?\n1.\tView Accounts\n2.\tDeposit\n3.\tWithdraw\n4.\tDelete Account\n5.\tView Logs\n6.\tLogOut");
			int accountChoice = Integer.parseInt(input.nextLine());
			switch (accountChoice) {
			case 1:
				AccountDaoImpl view = new AccountDaoImpl();
				try {
					List<Account> aList = (ArrayList<Account>) view.getAllAccounts(user.getUserID());
					System.out.println(aList.toString());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				verifiedUser(user);
				break;
			case 2:
				AccountDao deposit = new AccountDaoImpl();
				System.out.println("Please enter account ID you wish to access");
				int depositChoice = Integer.parseInt(input.nextLine());
				System.out.println("How much do you want to deposit?");
				double depositAmount = Double.parseDouble(input.nextLine());
				if (depositAmount < 0) {
					try {
						throw new InvalidAmount();
					} catch(InvalidAmount e) {
						e.printStackTrace();
					}
					finally {
						verifiedUser(user);
					}
				} else {
				try {
					Account depositAccount = deposit.retrieveAccountByID(depositChoice);
					double depositNewBalance = depositAmount + depositAccount.getBalance();
					deposit.updateAccount(depositNewBalance, depositChoice);
					System.out.println("Deposit successful");
					LogThis.LogMe("info", "$" + depositAmount + " has been added, new balance $" + depositNewBalance+ " for User:" + user.getfName(), user.getUsername());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
				verifiedUser(user);
				break;
			case 3:
				AccountDao withdraw = new AccountDaoImpl();
				System.out.println("Please enter account ID you wish to access");
				int withdrawChoice = Integer.parseInt(input.nextLine());
				System.out.println("How much would you like to withdraw");
				double withdrawAmount = Double.parseDouble(input.nextLine());
				if(withdrawAmount < 0) {
					try {
						throw new InvalidAmount();
					} catch(InvalidAmount e) {
						e.printStackTrace();
					}
					finally {
						verifiedUser(user);
					}
				} else {
				try {
					Account withdrawAccount = withdraw.retrieveAccountByID(withdrawChoice);
					if (withdrawAmount > withdrawAccount.getBalance()) {
						System.out.println("Not enough to withdraw");
						verifiedUser(user);
					} else {
						double withdrawBalance;
						withdrawBalance = withdrawAccount.getBalance() - withdrawAmount;
						withdraw.updateAccount(withdrawBalance, withdrawChoice);
						LogThis.LogMe("info", "$" + withdrawAmount + " has been added, new balance $" + withdrawBalance + " for User:" + user.getfName(), user.getUsername());
						System.out.println("Withdraw successful");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
				verifiedUser(user);
				break;
			case 4:
				AccountDao delete = new AccountDaoImpl();
				System.out.println("Please enter account ID you wish to access");
				int deleteChoice = Integer.parseInt(input.nextLine());
				System.out.println("Can only close account if balance is $0\nAre you sure you want to close account?\n1.\tYes\n2.\tNo");
				int confirmDelete = Integer.parseInt(input.nextLine());
				switch (confirmDelete) {
				case 1:
					try {
						Account deleteAccount = delete.retrieveAccountByID(deleteChoice);
						if(deleteAccount.getBalance()==0) {
							delete.deleteAccount(deleteChoice);
							System.out.println("Account successfully closed");
						} else {
							System.out.println("Account not eligible to be closed");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					verifiedUser(user);
					break;
				case 2:
					verifiedUser(user);
					break;
				default:
					System.out.println("Please enter a valid selection");
					verifiedUser(user);
					break;
				}
			case 5:
				LogDao viewLog = new LogDaoImpl();
				try {
					List<LogBean> logList = (ArrayList<LogBean>) viewLog.getAllAccounts(user.getUsername());
					System.out.println(logList.toString());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				verifiedUser(user);
				break;
			case 6:
				StartMenu.startMenu();
				break;
			default:
				System.out.println("Please enter a valid selection");
				verifiedUser(user);
				break;
			}
			break;
		case 3:
			StartMenu.startMenu();
			break;
		case 4:
			System.out.println("Thank you for using Bankus Maximus, goodbye");
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid selection");
			break;
		}
	}
}
