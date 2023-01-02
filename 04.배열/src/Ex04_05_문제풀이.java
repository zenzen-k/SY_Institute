
public class Ex04_05_문제풀이 {

	public static void main(String[] args) {
		
		// pdf 자료에 나온 방식도 참고해보기 -> 아래 score배열에 총점과 평균방을 추가한 방법
		int[][] score = { // 똑같은 배열을 정방배열이라고 함. (길이가 다른배열은 가변배열)
							{ 90, 95, 97 }, 
							{ 75, 71, 74 }, 
							{ 45, 34, 34 }, 
							{ 51, 61, 65 }, 
							{ 74, 80, 54 } };
		//과목별 총점 배열
		int[] totalSubject = new int[3]; // 0으로 초기화가 된다.

		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("=============================================");

		// score[0] = 0행의 첫번째 방의 주소(참조값)

		int i, j, sum = 0;
		for (i = 0; i < score.length; i++) { // 행, 천천히
			System.out.print(i + 1 + "\t");
			for (j = 0; j < score[i].length; j++) { // 열, 빨리
				System.out.print(score[i][j] + "\t");
				sum += score[i][j];
				totalSubject[j] += score[i][j]; // 아래 2번 방식!
			} // 안쪽 for문
			System.out.println(sum + "\t" + sum / 3.0);
			sum = 0;
		} // 바깥쪽 for문
			// 1. 방하나에 행을 빨리 증가시켜서 넣는 방법 -> for문을 또 만들어야함.
			// 2. 열을 빨리 증가시켜서 하나씩 넣으면서 증가시키는 방법 -> 현재 이방법으로 선택함!
		System.out.println("=============================================");
		System.out.print("총점:\t");
		for (i = 0; i < totalSubject.length; i++) {
			System.out.print(totalSubject[i] + "\t");
		}
		System.out.println();
	}// main

}// class
