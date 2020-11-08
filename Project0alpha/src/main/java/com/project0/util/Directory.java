package com.project0.util;

import java.util.ArrayList;
import java.util.List;

import com.project0.bankapp.beans.Account;
import com.project0.bankapp.beans.Customer;
import com.project0.bankapp.beans.Employee;
import com.project0.bankapp.menus.CustomerMenu;

public class Directory {
	protected static List<Employee> employeeList = new ArrayList<Employee>();
	
	public static Employee findEmployeeByName(String inputName) {
		for (int i = 0; i < employeeList.size(); i++) {
			String firstName = employeeList.get(i).getFirstName();
			String lastName = employeeList.get(i).getLastName();
			if (inputName.equalsIgnoreCase(lastName) || inputName.equalsIgnoreCase(firstName)) {
				return employeeList.get(i);
			}
		}
		System.out.println("Employee not found");
		return null;
	}
	public static Employee findEmployeeByID(long id) {
		for (int i = 0; i < employeeList.size(); i++) {
			long employeeNo = employeeList.get(i).getID();
			if (id == employeeNo) {
				return employeeList.get(i);
			}
		}
		System.out.println("Employee not found");
		return null;
	}
	
	private static List<Account> accountList = new ArrayList<>();
	
	public static Account findAccountByNumber(long id) {
		for (int i = 0; i < getAccountList().size(); i++) {
			long accountNo = getAccountList().get(i).getAccountNo();
			if (id == accountNo) {
				return getAccountList().get(i);
			}
		}
		System.out.println("Account not found");
		return null;
	}
	
	public static Account findAccountByCustomer(String inputName) {
		for (int i = 0; i < getAccountList().size(); i++) {
			String customer = getAccountList().get(i).getPrimary().getLastName();
			String customer2 = getAccountList().get(i).getSecondary().getLastName();
			if (inputName.equalsIgnoreCase(customer) || inputName.equalsIgnoreCase(customer2)) {
				return getAccountList().get(i);
			}
		}
		System.out.println("Account not found");
		return null;
	}
	
	protected static List<Customer> customerList = new ArrayList<>();
	
	public static Customer findCustomerByName(String inputName) {
		for (int i = 0; i < customerList.size(); i++) {
			String firstName = customerList.get(i).getFirstName();
			String lastName = customerList.get(i).getLastName();
			if (inputName.equalsIgnoreCase(firstName) || inputName.equalsIgnoreCase(lastName)) {
				return customerList.get(i);
			}
		}
		System.out.println("Customer not found");
		return null;
	}
	
	public static Customer findCustomerByEmail (String inputEmail) {
		for (int i = 0; i < customerList.size(); i++) {
			String email = customerList.get(i).getEmail();
			if(inputEmail == email) {
				return customerList.get(i);
			}
		}
		System.out.println("Customer not found");
		return null;
	}
	
	public static Customer passwordChecker(String inputLogin) {
		for (int i = 0; i < customerList.size(); i++) {
			String verify = customerList.get(i).getPassword();
			if (inputLogin.equals(verify)) {
				return customerList.get(i);
			}
		}
		System.out.println("Password incorrect");
		CustomerMenu.existingCustomer();
		return null;
	}
	
	public static List<Account> getAccountList() {
		return accountList;
	}
	public static void setAccountList(List<Account> accountList) {
		Directory.accountList = accountList;
	}
}
