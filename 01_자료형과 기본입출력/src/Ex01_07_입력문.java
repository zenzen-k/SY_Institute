import java.util.Scanner;	//Scanner를 사용하기 위해서 반드시 써줘야함. 

public class Ex01_07_입력문 {
	public static void main(String[] args) {
		int a;
		int b;
//		a = 10;
//		b = 20;
		
		//System.in : 키보드 
		//System.out : 콘솔창
		Scanner sc = new Scanner(System.in);	//키보드(System.in)로 입력한 데이터를 sc라는 이름의 스캐너로 읽음.	
		System.out.print("a입력 : ");	//콘솔창(System.out)에 출력해라!
		a = sc.nextInt();	//키보드로부터 정수형 데이터를 스캐너가 입력받아 a라는 변수에 저장
		
		System.out.print("b입력 : ");
		b = sc.nextInt();	//정수 입력
		
		System.out.println(a+b);
		
		String c;
		System.out.print("c입력 : ");
		c = sc.next();	//문자열 입력
		System.out.println("c:" + c);
		
		sc.close();	//sc를 더 이상 사용하지 않음
	}
}
