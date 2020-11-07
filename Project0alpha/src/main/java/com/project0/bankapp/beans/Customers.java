package com.project0.bankapp.beans;

import java.util.Scanner;

public interface Customers extends View {
	public double deposit(Scanner scan);
	public double transfer(Scanner scan);
	double withdraw(Scanner scan);
}
