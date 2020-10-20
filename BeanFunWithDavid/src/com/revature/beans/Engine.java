package com.revature.beans;

public class Engine {
	
	private String name;
	private int horsepower;
	private int torque;
	
	public Engine(String name, int horsepower, int torque) {
		this.name = name;
		this.horsepower = horsepower;
		this.torque = torque;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	@Override
	public String toString() {
		return name + " with " + horsepower + " horsepower and " + torque + " torque";
	}
	
	

}
