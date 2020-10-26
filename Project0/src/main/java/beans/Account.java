package beans;

public class Account {
	private String type;
	private int accountNumber;
	private double balance;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [type=" + type + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}
	
	
	
}
