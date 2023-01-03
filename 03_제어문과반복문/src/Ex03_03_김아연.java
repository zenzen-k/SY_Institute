import java.util.Scanner;

public class Ex03_03_김아연 {

	public static void main(String[] args) {
		/* 사용할 변수 선언 */
		String name;
		int kor, eng, math;
		
		/* 이름과 점수를 입력받아 초기화 */
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 입력=>");
		name = sc.next();
		System.out.print("국어 점수=>");
		kor = sc.nextInt();
		System.out.print("영어 점수=>");
		eng = sc.nextInt();
		System.out.print("수학 점수=>");
		math = sc.nextInt();

		/* 총점과 평균 계산 */
		int sum = kor + eng + math;	//총점
		double avg = sum/3.0;		//평균


		/* 학점 계산 - 두개의 값 비교를 위해 변수 두 개 사용했습니다 */
		String grade1, grade2;
		// if문을 이용하여 학점 구하기 - 변수 grade1에 저장
		if(avg>=90) {
			grade1 = "A";
		} else if(avg>=80) {
			grade1 = "B";
		} else if(avg>=70) {
			grade1 = "C";
		} else if(avg>=60) {
			grade1 = "D";
		} else {
			grade1 = "F";
		}

		// switch문을 이용하여 학점 구하기 - 변수 grade2에 저장
		switch((int)avg/10) {
		case 10: 
		case 9: grade2 = "A"; break;
		case 8: grade2 = "B"; break;
		case 7: grade2 = "C"; break;
		case 6: grade2 = "D"; break;
		default : grade2 = "F";
		}

		/* 출력문 */
		System.out.println("---------------------------");
		System.out.println("이름\t국어\t영어\t수학");
		System.out.println("---------------------------");
		System.out.printf("%s\t%d\t%d\t%d\n",name,kor,eng,math);
		System.out.println("---------------------------");
		System.out.println("총점: " + sum);
		System.out.printf("평균: %.2f\n", avg);
		System.out.println("---------------------------");
		System.out.println("학점=" + grade1 + " (if문 사용)");
		System.out.println("학점=" + grade2 + " (switch문 사용)");

		sc.close();
	}

}
