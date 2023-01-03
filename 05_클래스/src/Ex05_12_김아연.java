import java.util.Scanner;

public class Ex05_12_김아연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1:");
		int num1 = sc.nextInt();
		System.out.print("숫자2:");
		int num2 = sc.nextInt();
		
		int pow = power(num1, num2);
		System.out.println("result:" + pow);
		System.out.println(num1 + "의 " + num2 + "승은 " + pow + "입니다.");
	}
	
	static int power(int x, int y) {
		if(y==1)
			return x;
		else
			return x * power(x,y-1);
	}
	
}
