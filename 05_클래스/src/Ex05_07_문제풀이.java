import java.util.Scanner;

//학생정보 클래스
class Student2 {
	static String name;
	static int kor, eng, math;

	// 합계를 return하는 sum메서드 정의
	int sum1(int kor, int eng, int math) {
		return kor + eng + math; // 매개변수사용
	}

	int sum2() {
		return kor + eng + math; // 멤버변수사용
	}

	// 평균을 return하는 avg메서드 정의
	double avg1() {
		//return (kor + eng + math) / 3.0;
		return sum2()/3.0;
	}
	static double avg2() {
		return (kor + eng + math) / 3.0;
		// Cannot make a static reference to the non-static field kor : 멤버변수(field) kor가 static이 아님.
		// static메서드 안에서는 static변수만 사용 가능함. 
	}
	
	static void show() {
		System.out.println("name:"+name);
		System.out.println("kor:"+kor);
		System.out.println("eng:"+eng);
		System.out.println("math:"+math);
	}

}//

public class Ex05_07_문제풀이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Student2 stu = new Student2();

		System.out.print("이름입력:");
//		String name = sc.next();
		stu.name = sc.next();

		System.out.print("국어입력:");
//		int kor = sc.nextInt();	//Student의 kor, sum메서드 kor, 이 kor이 모두 다른 kor임.
		Student2.kor = sc.nextInt();

		System.out.print("영어입력:");
//		int eng = sc.nextInt();
		Student2.eng = sc.nextInt();

		System.out.print("수학입력:");
//		int math = sc.nextInt();
		Student2.math = sc.nextInt();

		// 합계 출력
//		int result1 = stu.sum1(kor, eng, math);
		int result1 = stu.sum1(stu.kor, stu.eng, stu.math);
		int result2 = stu.sum2();
		System.out.println("합계1:" + result1);
		System.out.println("합계2:" + result2);
		
		// 평균 출력(소수 아래 2자리까지 출력)
		double result3 = stu.avg1();
		System.out.printf("평균1:%.2f\n" , result3);
		
		result3 = Student2.avg2();
		System.out.printf("평균1:%.2f\n" , result3);
		
		stu.show();
		Student2.show();
	}

}
