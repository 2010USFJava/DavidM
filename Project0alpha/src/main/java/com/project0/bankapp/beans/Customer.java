package com.project0.bankapp.beans;

public class Customer {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Customers customerActions;
	
	public Customer(String firstName, String lastName, String email, String password, Customers customerActions) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.customerActions = customerActions;
	}
	
	public Customer() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + "]";
	}

	public Customers getCustomerActions() {
		return customerActions;
	}

	public void setCustomerActions(Customers customerActions) {
		this.customerActions = customerActions;
	}
	
	
}
