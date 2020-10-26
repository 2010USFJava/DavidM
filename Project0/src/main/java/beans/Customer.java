package beans;

public class Customer extends Person {
	private int accountNumber;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + "]";
	}
	
	public void apply() {
		
	}
	
	public void deposit() {
		
	}
	
	public void withdraw() {
		
	}
}
