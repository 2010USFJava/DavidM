package com.project0.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

import com.project0.bankapp.beans.Account;
import com.project0.bankapp.beans.Customer;
import com.project0.bankapp.beans.Employee;

public class Filer {
	public static final String employeeFile = "Employee List.txt";
	public static final String accountFile = "Account List.txt";
	public static final String customerFile = "Customer List.txt";
	
	//Write method
		public static void writeEmployeeFile(List<Employee> eList) {
			try {
				ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(employeeFile));
				objectOut.writeObject(eList);
				objectOut.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	//read method
		@SuppressWarnings("unchecked")
		public static void readEmployeeFile() {
			ObjectInputStream objectIn;
			try {
				objectIn = new ObjectInputStream(new FileInputStream(employeeFile));
				Directory.employeeList = (ArrayList<Employee>) objectIn.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		//Write method
		public static void writeAccountFile(List<Account> aList) {
			try {
				ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(accountFile));
				objectOut.writeObject(aList);
				objectOut.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	//read method
		@SuppressWarnings("unchecked")
		public static void readAccountFile() {
			ObjectInputStream objectIn;
			try {
				objectIn = new ObjectInputStream(new FileInputStream(accountFile));
				Directory.setAccountList((ArrayList<Account>) objectIn.readObject());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Write method
		public static void writeCustomerFile(List<Customer> cList) {
			try {
				ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(customerFile));
				objectOut.writeObject(cList);
				objectOut.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	//read method
		@SuppressWarnings("unchecked")
		public static void readCustomerFile() {
			ObjectInputStream objectIn;
			try {
				objectIn = new ObjectInputStream(new FileInputStream(customerFile));
				Directory.customerList = (ArrayList<Customer>) objectIn.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
