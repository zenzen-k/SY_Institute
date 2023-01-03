import java.util.Scanner;

public class Ex03_01_ifelse {
	public static void main(String[] args) {
		//삼항연산자는 간단할때사용함. 조건이 많아지면 복잡해져 사용하기 어렵다.
		
		int a, b;
		Scanner sc = new Scanner(System.in);
		// a,b 숫자를 입력받음
		System.out.print("a입력:");
		a = sc.nextInt();
		System.out.print("b입력:");
		b = sc.nextInt();
		
		// 입력받은 값 확인
		System.out.println("a=" + a + ", b=" + b);
		
		/*
		if(조건문) {
		참일때 실행할 문장. 참이 아니면 그냥 넘어간다;
		}
		else {
		조건이 참이 아닐때 실행되는 문장;
		}
		 */
		
		//if(조건문); 을 해버리면 if의 조건문이 끝나버려 참이던 거짓이던 다음 문장이 출력된다.
		//따라서 세미콜론 사용하지 않도록 주의.
		//참일 때 처리할 문장이 한줄이면 중괄호{}는 생략해도 되지만, 두줄 이상이면 반드시 묶어줘야 함
		if(a>b) { 
			System.out.println("a가 b보다 크다.");
			System.out.println("하하하");
		}	
		else if(a<b) {	// a<b
			System.out.println("a가 b보다 작다.");
			System.out.println("호호호");
		}
		else {	//a==b
			System.out.println("a와 b가 같다.");
			System.out.println("헤헤헤");			
		}
		
		//if문이 끝나 무조건 처리되는 문장
		System.out.println("if문 공부중..");
		sc.close();
	}
}
