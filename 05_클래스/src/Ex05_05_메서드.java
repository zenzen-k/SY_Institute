import java.util.Scanner;

//클래스 안에 클래스 정의불가. 메소드도 메소드 안에 또다른 메소드 정의 불가.
class Calculator { // 클래스 안에는 메소드 정의도 가능함
	
	//클래스객체를 만들고 호출하였기 때문에 main에서 사용하지만 static 메서드 사용가능하다.
	int sum(int x, int y) {	//참조변수로 호출해야함
		return x + y;
	}
	/*
	int sub(int x, int y) {
		return x - y;
	}
	*/
	static int sub(int x, int y) {	//참조변수 또는 클래스로 호출할 수 있음
		return x - y;	//return은 하나만 가능함
	}
	
	static int max(int x, int y) {
		if(x>y)
			return x;	//if를 사용했기때문에 경우에 따라서 하나만 return함
		else
			return y;
	}
}// Calculator

public class Ex05_05_메서드 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1:");
		int num1 = sc.nextInt();
		System.out.print("숫자2:");
		int num2 = sc.nextInt();

//		sum(num1,num2);	//같은 클래스 안에 정의가 되어있지 않아서 사용 불가능함.
		Calculator cal = new Calculator(); // 객체 생성
		int result1 = cal.sum(num1, num2); // 메소드도 클래스의 인스턴스변수를 호출하듯이 호출함.
		System.out.println("result1:" + result1);
		
		/*
		int result2 = cal.sub(num1, num2);
		System.out.println("result2:" + result2);
		System.out.println("result2:" + cal.sub(num1, num2));
		*/
		
//		int result2 = cal.sub(num1, num2);
		int result2 = Calculator.sub(num1, num2); // > static변수는 객체를 만들지 않고도 가능함
		System.out.println("result2:" + result2);
		
//		int result3 = cal.max(num1, num2);
		int result3 = Calculator.max(num1, num2);
		System.out.println("result3:" + result3);
		
		sc.close();
	}// main

}
