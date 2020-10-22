package com.revature.staff;

public class Employee {
	
	private String fName;
	private String lName;
	private int empNumber;
	private String dept;
	private int salary;
	private boolean manager;
	
	public Employee() {
		
	}
	
	public Employee(String fName) {
		this(fName, "Doe");
	}
	
	public Employee(String fName, String lName) {
		this(fName, lName, 000000);
	}
	
	public Employee(String fName, String lName, int empNumber) {
		this(fName, lName, empNumber, "Revature");
	}
	
	public Employee(String fName, String lName, int empNumber, String dept) {
		this(fName, lName, empNumber, dept, 40000);
	}
	
	public Employee(String fName, String lName, int empNumber, String dept, int salary) {
		this(fName, lName, empNumber, dept, salary, false);
	}
	
	public Employee(String fName, String lName, int empNumber, String dept, int salary, boolean manager) {
		this.fName=fName;
		this.lName=lName;
		this.empNumber=empNumber;
		this.dept=dept;
		this.salary=salary;
		this.manager=manager;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Employee eligible fields: First Name(String), Last Name(String), Employee Number(int), Department(String), Salary(int), Manager(boolean)
		Employee jDoe = new Employee("J");
		System.out.println(jDoe);
	}

	@Override
	public String toString() {
		return "Employee: " + fName + " " + lName + ", EmployeeID: " + empNumber + ", Department: " + dept
				+ ", Salary: $" + salary + ", Permissions:" + manager;
	}
	
	

}
