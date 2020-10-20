package com.revature.driver;

import com.revature.beans.Car;
import com.revature.beans.Engine;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car newCar = new Car(2020, "Chevrolet", "Corvette");
		Engine chevyEngine = new Engine("LT2", 495 , 465);
		System.out.println(newCar + " with " + chevyEngine);
		Car anotherNewCar = new Car (2020, "Toyota", "86");
		Engine toyotaEngine = new Engine("FA20D", 205, 156);
		System.out.println(anotherNewCar + " with " + toyotaEngine);
		

	}

}
