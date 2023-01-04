import java.util.Scanner;

public class Ex05_12_문제풀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1:");
		int num1 = sc.nextInt();

		System.out.print("숫자2:");
		int num2 = sc.nextInt();

		int result = recursive(num1, num2);
		System.out.println(num1 + "의 " + num2 + "승은 " + result + "입니다.");
		
		//반복문 사용
		int i; 
		result = 1;
		for (i = 0; i < num2; i++) {
			result *= num1;
		}
		System.out.println("result:" + result);
		
//		static double pow​(double a, double b)
		double result2 = Math.pow(num1, num2);
		System.out.println("result2:" + result2);
		
		sc.close();
	} // main

	static int recursive(int a, int b) {
		if (b == 0) // or b==1
			return 1; // or return a;
		else
			return a * recursive(a, --b);
	} // recursive

}
