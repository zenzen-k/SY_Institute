class Car {
	String color = "white";
	int door = 4;
	void drive() {
		System.out.println("drive~");
	}
	void stop() {
		System.out.println("stop!!");
	}
} // Car

class FireEngine extends Car{
	int door = 6;
	int wheel = 10;
	void drive() {
		System.out.println("FEdrive~");
	}
	void water() {
		System.out.println("water!!!");
	}
} // FireEngine


public class Ex06_10_다형성 {
	public static void main(String[] args) {
		
		Car c = new Car();
		System.out.println(c.color);
		System.out.println(c.door);
		c.drive(); // drive~
		c.stop();
		System.out.println("------");
		
		FireEngine fe = new FireEngine();
		System.out.println(fe.door); // 6
		System.out.println(fe.wheel); // 10
		System.out.println(fe.color); // white
		fe.drive();
		fe.stop();
		fe.water();
		
		
		System.out.println("------");
		
		c = fe;	// Car 타입 = FireEngine 타입. 상속관계이므로 업캐스팅이 가능하다.(자동)
		// c = (Car)fe; 
		System.out.println(c.door); //4
//		System.out.println(c.wheel); // error. cannot be resolved ->사용할 수 없는 변수
		System.out.println(c.color); //white
		c.drive(); // FEdrive~ -> 자식클래스가 가지고 있음!
		c.stop();
//		c.water(); // 에러. 정의되지않았다.
		
		System.out.println("******************");
		
		FireEngine fe2;
		if(c instanceof FireEngine) { // c 변수를 FireEngine 타입으로 변환할 수 있는지? 물어보는 연산자.
			System.out.println("다운캐스팅 가능");
			
			fe2 = (FireEngine)c; // 다운캐스팅. 부모를 자식타입으로 내려줌. 업캐스팅처럼 자동으로 이루어지지 않는다. 
			System.out.println(fe2.door); // 6
			System.out.println(fe2.wheel); // 10
			System.out.println(fe2.color); // white
			fe2.drive();
			fe2.stop();
			fe2.water();
		}
		else {
			System.out.println("다운캐스팅 불가능");
		}
		
		
		
	}
}
