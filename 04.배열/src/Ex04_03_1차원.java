import java.util.Scanner;

public class Ex04_03_1차원 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		System.out.print("국어입력=>");
//		int kor = sc.nextInt();
//		System.out.print("영어입력=>");
//		int eng = sc.nextInt();
//		System.out.print("수학입력=>");
//		int math = sc.nextInt();
//		
//		System.out.println("국어:" + kor);
//		System.out.println("영어:" + eng);
//		System.out.println("수학:" + math);

		String[] sub = { "국어점수:", "영어점수:", "수학점수:" };
		// 0으로 자동 초기화
		int[] score = new int[3];
		int i;
		// 배열에 점수 입력받기
		for (i = 0; i < score.length; i++) {
			System.out.print(sub[i]); // 과목출력
			score[i] = sc.nextInt(); // 과목점수 입력받음
		}

		System.out.println();
		for (i = 0; i < score.length; i++) {
			System.out.println(sub[i] + score[i]);
		}

		sc.close(); 
	}

}
