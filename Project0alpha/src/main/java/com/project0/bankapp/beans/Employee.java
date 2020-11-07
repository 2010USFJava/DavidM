package com.project0.bankapp.beans;

public class Employee {
	private String firstName;
	private String lastName;
	private long iD;
	private String password;
	private boolean isAdmin;
	private Employees employeeAction;
	private Admin admin;
	public Employee(String firstName, String lastName, long iD, String password, Employees employee) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.iD = iD;
		this.password = password;
		this.isAdmin = false;
		this.employeeAction = employee;
	}
	public Employee(String firstName, String lastName, long iD, String password, Admin admin) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.iD = iD;
		this.password = password;
		this.isAdmin = true;
	}
	
	public Employee() {
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
	public long getID() {
		return iD;
	}
	public void setID(long iD) {
		this.iD = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", ID=" + iD + ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}
	public Employees getEmployeeAction() {
		return employeeAction;
	}
	public void setEmployeeAction(Employees employeeAction) {
		this.employeeAction = employeeAction;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
