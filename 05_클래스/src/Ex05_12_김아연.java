import java.util.Scanner;

public class Ex05_12_김아연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1:");
		int num1 = sc.nextInt();
		System.out.print("숫자2:");
		int num2 = sc.nextInt();
		
		System.out.println("result:" + power(num1, num2));
	}
	
	static int power(int x, int y) {
		if(y==1)
			return x;
		else
			return x * power(x,y-1);
	}
	
}
