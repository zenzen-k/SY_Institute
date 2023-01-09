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

/*
 * 접근제어자
 * private : 선언한 클래스 내부!
 * default : 생략가능. 같은 패키지 내부!
 * protected : 다른 패키지의 상속받은 클래스까지 가능!
 * public : 어디서나 사용 가능
 * */