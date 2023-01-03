import java.util.Scanner;

public class Ex02_01_산술연산자 {
	public static void main(String[] args) {
		
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 숫자를 입력하세요 : ");
		num2 = sc.nextInt();
		
		System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
		System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
		System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
		System.out.println(num1 + "/" + num2 + "=" + (num1/num2));
		System.out.printf("%d/%d=%.2f\n",num1,num2,(double)num1/num2);	//float보다는 double이 많은 소수점 숫자를 쓸 수 있어서 더 안전함.
		System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);	//서식문자가 3개면 출력문자도 3개이어야 한다.
		
		// % : 나머지 구하는 연산자
		System.out.println(num1 + "%" + num2 + "=" + (num1%num2));
		//%를 출력하기 위해서는 %%
		System.out.printf("%d%%%d=%d\n",num1,num2,num1%num2);
		
		sc.close();
	}
}
