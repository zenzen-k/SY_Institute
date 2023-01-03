class Example {
	static int max(int x, int y) {
		if (x > y)
			return x;
		else
			return y;
	}
}// 내가만든 클래스~

public class Ex05_15_Math {

	public static void main(String[] args) {

		int a = 30, b = 40, c;

		c = Example.max(a, b); // int Example.max(int x, int y)
		System.out.println("큰 값:" + c);

		c = Math.max(a, b); // Math 클래스에 이미 정의된 max
		System.out.println("큰 값:" + c);

		c = Math.min(a, b); // Mate 클래스에 이미 정의된 min
		System.out.println("작은 값:" + c);
		
		System.out.println(Math.abs(-3.2));
		System.out.println(Math.abs(-12));
		
		System.out.println(Math.PI);
	}

}
