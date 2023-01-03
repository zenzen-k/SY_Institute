import java.util.Scanner;

public class Ex03_02_ifelse {

	public static void main(String[] args) {
		
		int num;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력:");	
		num = sc.nextInt();
		System.out.println("num= " + num);
		
		//if(num==1 || num==2 || ... || num==10)
		//조건문이 참이라면 내부적으로 if(true)이 되며, 거짓은 if(false).
		if(num>=1 && num<=10 ) {	// 1<=num<=10 한번에 쓸수 없기 때문에
			System.out.println("1~10사이의 수입니다.");
		}
		/*
		else : 위의 조건이 참이 아닐때에만 해당줄로 오게된다.
		if문이 참이면 else는 건너뛰게 된다.
		*/
		else if(num>=11 && num<=20) {
			System.out.println("11~20사이의 수입니다.");
		}
		else if(num>=21 && num<=30) {
			System.out.println("21~30사이의 수입니다.");
		}

		System.out.println("if~else 공부중..");
		
		/* 5의 배수, 10의 배수 */
		if(num%5==0) {
			System.out.println("5의 배수입니다.");
		}
		if(num%10==0) {
			System.out.println("10의 배수입니다.");
		}
		
		/*else로 묶지 않은 이유*/
		// 20이나 30은 5의 배수이기도 하므로 else를 사용했다면 "5의 배수입니다"만 출력이 되고 끝나기 때문의 별도의 if 그룹으로 만들어주어야 한다.
		
		sc.close();
	}

}
