import java.util.Scanner;

public class Ex03_04_ifelse {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자입력:");
		int num = sc.nextInt();
		System.out.println("입력한 숫자:" + num);
		System.out.println();
		
		if(num%5==0) {
			System.out.println("5의 배수");
			/*if문 안의 if-else문은 바깥의 if문이 참인 경우에 안의 if문과 else문 을 수행한다*/
			if(num%10==0) {	//5의 배수이고, 10의 배수
				System.out.println("10의 배수");
			} else {	//5의 배수이지만, 10의 배수가 아니면
				System.out.println("10의 배수 아님");
			}
		}
		else {	// 5의 배수가 아니면
			System.out.println("5의 배수가 아님");
		}

		sc.close();
		
		
	}

}
