import java.util.Scanner;

//학생정보 클래스
class Student{
	String name;
	int kor, eng, math;
	
	//합계를 return하는 sum메서드 정의
	int sum(int x, int y, int z) {
		return x+y+z;
	}
	
	//평균을 return하는 avg메서드 정의
	double avg(int x, int y, int z) {
		return (x+y+z)/3.0;
	}
}//


public class Ex05_07_김아연 {

	public static void main(String[] args) {
		
		Student std = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.print("이름입력:");
		std.name = sc.next();
		System.out.print("국어입력:");
		std.kor=sc.nextInt();
		System.out.print("영어입력:");
		std.eng=sc.nextInt();
		System.out.print("수학입력:");
		std.math=sc.nextInt();
		System.out.println();
		
		//입력받은 4가지 값 모두 출력
		System.out.println("이름출력:"+std.name);
		System.out.println("국어출력:"+std.kor);
		System.out.println("영어출력:"+std.eng);
		System.out.println("수학출력:"+std.math);
		System.out.println();
		
		//합계 출력
		System.out.println("합계출력:"+std.sum(std.kor, std.eng, std.math));
		
		//평균 출력(소수 아래 2자리까지 출력)
		System.out.printf("평균출력:%.2f",std.avg(std.kor, std.eng, std.math));
	}

}   
