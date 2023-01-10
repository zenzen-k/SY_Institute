import java.util.Scanner;

public class Ex07_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자1:");
		int num1 = sc.nextInt();
		System.out.print("숫자2:");
		int num2 = sc.nextInt();

		boolean dap = divider(num1, num2);
		if (dap == true)
			System.out.println("연산 성공");
		else
			System.out.println("연산 실패");
		sc.close();
	}

	public static boolean divider(int a, int b) {
		int result = 0;
		try {
			result = a / b; // ArithmeticException : 5/0 -> 오류
			System.out.println("나눗셈 결과:" + result);
			return true;

		} catch (ArithmeticException e) {
			System.out.println("e:" + e);
			return false;

		} finally { // 무조건 실행하므로 돌아가더라도 finally는 무조건 처리하고 감!!!
			System.out.println("finally 영역");

		}

	}

}
