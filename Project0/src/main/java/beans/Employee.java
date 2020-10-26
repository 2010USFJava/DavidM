package beans;

public class Employee extends Person {
	private int employeeNumber;

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	public void view() {
		Account.class.toString();
	}
	
	public void decision() {
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + "]";
	}
	
	
	
}
