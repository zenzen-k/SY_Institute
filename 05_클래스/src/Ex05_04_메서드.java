
public class Ex05_04_메서드 {

	//jdk설치시 JVM자동 설치. JVM에 의해서 main메서드를 자동으로 호출해준다. (객체를 만들지 않아도 호출할 수 있도록 static을 붙여서 정의해준다!) 
	public static void main(String[] args) {	//main메서드 정의. 

//		add(3,9);	//호출
		int result = add(3, 9); // add메서드 호출. 호출한 곳(add)에 리턴된 sum을 받게 된다.
		// 즉 int result = 12;와 같다.
		System.out.println("result:" + result);

		result = add(200, 193);
		System.out.println("result:" + result);

		result = add(123, 456);
		System.out.println("result:" + result);

		System.out.println(add(100, 200)); // 받은 값을 바로 출력할 수 있음
		System.out.println("---------------");

		mul(2, 3.9, 7); // mul()메서드 호출
		mul(4, 9, 10); // mul()메서드 호출
		
//		show();	//static 붙이고 호출
		
		Ex05_04_메서드 ex = new Ex05_04_메서드();	//static 없이 호출
		ex.show();

	}

	
	//static메서드안에서 호출되는 메서드는 반드시 static 정의를 해주어야 한다.
	
	//매개변수 -> 호출할때 넘어오는 값을 받아주는 변수, 아래에서는 a와 b가 매개변수가 된다.
	static int add(int a, int b) { // add메서드 정의
		// 리턴할 값이 int라면 메서드 정의에서 리턴타입을 int로 작성해준다.
		// 즉 리턴타입은 리턴되는 값의 타입을 작성하는 것이다. void -> 아무것도 가져가지않음. 비어있는.
		int sum = a + b;
		return sum; // 호출한 곳으로 돌아간다.
	}// add 메서드 정의

	static void mul(int a, double b, int c) { // mul() 메서드 정의
		System.out.println("세 수의 곱:" + a * b * c);
	}
	
	void show() {
		System.out.println("show 메서드 정의 부분");
	}
}
