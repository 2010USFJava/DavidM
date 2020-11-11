package com.exceptions;

import java.util.Scanner;

public class Simulation {

	public static void main(String[] args) {
		//runs method get input and makes it catch custom exception
		try {
			getInput();
		} catch (EvenNumberException e) {
			e.printStackTrace();
		}
	}
	//main logic
	public static void getInput() throws EvenNumberException{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number");
		String line = input.nextLine();
		System.out.println("You typed " + line);
		//this passes user input through even number checker
		if (isEven(line)) {
			try {
				//tells the code that if it is even throw this custom error
			throw new EvenNumberException();
			} finally {
				//closing scanner
				input.close();
			}
		}
		//closing scanner
		input.close();
		
		
	}
	//method that finds even numbers
	public static boolean isEven(String num) {
		int value = Integer.parseInt(num);
		
		return (value %2 ==0);
	}
}

