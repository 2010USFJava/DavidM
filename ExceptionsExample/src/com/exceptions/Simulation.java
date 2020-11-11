package com.exceptions;

import java.util.Scanner;

public class Simulation {

	public static void main(String[] args) {
		try {
			getInput();
		} catch (EvenNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getInput() throws EvenNumberException{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number");
		String line = input.nextLine();
		System.out.println("You typed " + line);
		
		if (isEven(line)) {
			try {
			throw new EvenNumberException();
			} finally {
				input.close();
			}
		}
		
		input.close();
		
		
	}
	
	public static boolean isEven(String num) {
		int value = Integer.parseInt(num);
		
		return (value %2 ==0);
	}
}

