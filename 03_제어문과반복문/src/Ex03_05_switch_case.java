import java.util.Scanner;

public class Ex03_05_switch_case {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력:");
		int num = sc.nextInt();
		System.out.println("num=" + num);

		if(num==1) {
			System.out.println("1입니다.");
		}
		else if(num==2) {
			System.out.println("2입니다.");
		}
		else if(num==3) {
			System.out.println("3입니다.");
		}
		else {
			System.out.println("1~3사이의 수가 아닙니다.");
		}
		
		System.out.println("--------------------");
		
		switch(num) { 
		case 1 : System.out.println("1입니다.");
			break;	// 더 밑으로 내려가지 말고 switch문을 빠져나가라는 의미.
					// break를 사용하지 않고 1을 입력받게 된다면 1, 2, 3 모두 출력이 됨
		case 2 : System.out.println("2입니다.");
			break;
		case 3 : System.out.println("3입니다.");
			break;
		//해당되는 값이 없을 때 default로 오게 된다.
		//해당되는 케이스가 없을때 뭔가 하고싶은게 아니면 굳이 default를 사용하지 않아도 된다
		default : System.out.println("1~3사이의 수가 아닙니다.");
			break;	// 맨 마지막줄은 더 이상 뭐가 없기 때문에 break를 생략해도 된다.
		}
		
		//수식사용도 가능함. 수식 계산의 값이 일치하는 case를 찾아간다.
		switch(num+1) {
		case 1 : System.out.println("1입니다.");
			break;
		case 2 : System.out.println("2입니다.");
			break;
		case 3 : System.out.println("3입니다.");
			break;
		default : System.out.println("1~3사이의 수가 아닙니다.");
			break;
		}
		
		
		System.out.println("switch~case 공부중..");

		sc.close();
	}

}
