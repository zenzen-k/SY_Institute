import java.util.Scanner;

public class Ex03_03_문제풀이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력=>");
		String name = sc.next();

		System.out.print("국어 입력=>");
		int kor = sc.nextInt(); // 공백없이 입력하는 명령어. 콘솔창 입력 시 띄어쓰기하면 안됨
		System.out.print("영어 입력=>");
		int eng = sc.nextInt();
		System.out.print("수학 입력=>");
		int math = sc.nextInt();

		System.out.println("---------------------------");
		System.out.println("이름\t국어\t영어\t수학");
		System.out.println("---------------------------");
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + math);
		System.out.println("---------------------------");

		int sum = kor + eng + math;
		double avg = sum / 3.0;
		// 10/4=2 (정수/정수=정수)임! 10.0/4=2.5(둘중 하나라도 실수여야 함)
		// (double)sum/3은 가능하나, (double)(sum/3)-> 이거는 정수/정수=정수를 계산한 결과를 double로 바꾸는것.
		// 따라서 잘 생각해야함! 결과를 바꿀것인지 피연산자를 바꿀것인지

		System.out.println("총점: " + sum);
		System.out.printf("평균: %.2f\n", avg);
		System.out.println("---------------------------");
		
		//비효율적인 코드 - 모든 if문을 들리기 때문
		if(avg>=90) {
			System.out.println("A학점");
		}
		if(avg>=80 && avg<90) {
			System.out.println("B학점");
		}
		if(avg>=70 && avg<80) {
			System.out.println("C학점");
		}
		if(avg>=60 && avg<70) {
			System.out.println("D학점");
		}
		if(avg<60) {
			System.out.println("F학점");
		}
		
		System.out.println("---------------------------");
		if(avg>=90) {
			System.out.println("A학점");
		}
		else if(avg>=80) {	//avg>=80 && avg<90
			System.out.println("B학점");
		}
		else if(avg>=70) {	//avg>=70 && avg<80
			System.out.println("C학점");
		}
		else if(avg>=60) {	//avg>=60 && avg<70
			System.out.println("D학점");
		}
		else {	// 위 조건에 모두 참이 아닐 때
			System.out.println("F학점");
		}
		
		System.out.println("---------------------------");
		//정수형변수, 문자열, 수식 가능 (실수 불가)
		switch((int)avg/10) {
		case 10 :
		case 9 : System.out.println("A학점"); break;
		case 8 : System.out.println("B학점"); break;
		case 7 : System.out.println("C학점"); break;
		case 6 : System.out.println("D학점"); break;
		default : System.out.println("F학점");
		
		}
		
		sc.close();
	}
}