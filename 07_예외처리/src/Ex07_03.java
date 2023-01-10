//import java.util.InputMismatchException;
//import java.util.Scanner;
import java.util.*;

public class Ex07_03 {

	public static void main(String[] args) {
		
		// 1~100 사이의 정수 난수 발생 : A~B -> B-A +1
//		int answer = (int)(Math.random()*100) + 1;
		
//		원래 난수는 double타입이므로 실수가 발생함.
//		0<= answer < 100 : 0~99
//		0< answer <= 100 : 1~100

//		System.out.println("answer:" + answer);
		
		// 17~85 사이의 정수 난수 발생 : 85-17+1 = 69, 17
		int answer = (int)(Math.random()*69) + 17;
		
		
		int input = 0;
		int count = 0;
		// 잘못 입력했을 때 input에 값이 들어가지 않는다.( try 안에 넣으면 )
		// 따라서 아래 if문에서 비교할 수 없게 되기 때문에 초기화를 해야한다.
		do {
			count ++;
			System.out.print("1~100사이의 숫자를 입력 : ");
			Scanner sc = new Scanner(System.in);
			try {
				input =  sc.nextInt();	
				
				// InputMismatchException e = new InputMismatchException 객체를 가지고 catch로 간다!
			} catch(InputMismatchException e) {
				System.out.println("유효하지 않은 값입니다. 다시 입력하세요");
				continue;
			}
			
			if(answer > input) {
				System.out.println("더 큰 수를 입력하세요");
			}
			else if (answer < input) {
				System.out.println("더 작은 수를 입력하세요");
			}
			else {
				System.out.println("정답입니다");
				System.out.println("시도한 횟수는 " + count + "번 입니다.");
				break;
			}
		}while(true);
		

	}

}
