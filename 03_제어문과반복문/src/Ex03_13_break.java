import java.util.Scanner;

public class Ex03_13_break {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		//입력한 숫자가 음수가 될 때 멈춤
		while(true) {
			System.out.print("숫자입력:");
			num = sc.nextInt();
			
			if(num<0) {	
				break;
			}
		}
		System.out.println("프로그램 끝");
		sc.close();
	}
}
