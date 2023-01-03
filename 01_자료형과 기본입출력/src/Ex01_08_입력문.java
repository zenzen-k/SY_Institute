import java.util.Scanner;

public class Ex01_08_입력문 {

	public static void main(String[] args) {
		String name;
		int kor;
		int eng;
		int math;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력=>");
		name = sc.next();
		System.out.print("국어 입력=>");
		kor = sc.nextInt();
		System.out.print("영어 입력=>");
		eng = sc.nextInt();
		System.out.print("수학 입력=>");
		math = sc.nextInt();
		
		int sum = kor+eng+math;
		float avg = (float)sum/3;	//double avg = sum/3; -> 정수/정수=정수 이므로 강제형변환해주어야함! (double) or sum/3.0
		
		System.out.println("---------------------------");
		System.out.println("이름\t국어\t영어\t수학");
		System.out.println("---------------------------");
		System.out.printf("%s\t%d\t%d\t%d\n",name,kor,eng,math);	//System.out.println(name+"\t"~~
		System.out.println("---------------------------");
		System.out.println("총점: " + sum);
		System.out.printf("평균: %.2f\n",avg);
		System.out.println("---------------------------");
		
		sc.close();
	}
}