package com.exceptions;

public class EvenNumberException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5978561171858943060L;
	//ovveriding getMessageMethod from Exception class
	@Override
	public String getMessage() {
		return "You cannot input an even number.";
	}
}

