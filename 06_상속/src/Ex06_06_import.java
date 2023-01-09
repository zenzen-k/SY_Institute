import com.javastudy.*;	//com. javastudy 패키지 안에 있는 것들을 임포트!
// java.lang 패키지 안에는 자주 사용되는 여러가지 클래스들이 있다. 
// 아주 자주 사용되기 때문에 이 클래스들은 import없이 사용할 수 있도록 프로그램이 허용해놨음
import java.lang.System;
import java.lang.String;
import java.util.Date;

//class Car {
//	private int speed;
//	private String direction;
//	
//	public Car(int speed, String direction){
//		this.speed = speed;
//		this.direction = direction;
//	}
//	
//	public void prnCar() {
//		System.out.println("speed:" + speed);
//		System.out.println("direction" + direction);
//	}
//	
//}// Car

public class Ex06_06_import {
	public static void main(String[] args) {
//		Car car = new Car(100,"동남"); // 같은 프로젝트 안의 같은 패키지 안에서만 Car클래스를 찾는다.
//		car.prnCar();
		
		System.out.println(123);
		
		// String도 클래스다! 원래작성법 : java.lang.String s = "아이유";
		String s = "아이유";
		
		
		// java.util.Date d = new java.util.Date();
		Date d = new Date();
		System.out.println(d); // 현재 시간과 날짜
	}

}
