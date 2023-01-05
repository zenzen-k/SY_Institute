package com.javastudy;

import java.util.*;

public class Car {
	private int speed;
	private String direction;
	
	public Car(int speed, String direction){
		this.speed = speed;
		this.direction = direction;
	}
	
	public void prnCar() {
		System.out.println("speed:" + speed);
		System.out.println("direction" + direction);
		System.out.println("--------");
		
		Date d = new Date();
		System.out.println(d);
		
		System.out.println("--------");
	}

}
