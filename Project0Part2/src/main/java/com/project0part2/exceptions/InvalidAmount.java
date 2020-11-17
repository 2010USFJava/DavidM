package com.project0part2.exceptions;

public class InvalidAmount extends Exception {

	/**
	 * This exceptions are for invalid user operations
	 */
	private static final long serialVersionUID = 4920385160868830777L;
	//@Override
	public String getMessage() {
		return "Please enter a valid amount";
	}
}
