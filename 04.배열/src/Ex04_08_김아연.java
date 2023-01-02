import java.util.Scanner;

public class Ex04_08_김아연 {

	public static void main(String[] args) {

		int studentNum; // 학생수
		/*
		 * 참조변수 scores에는 주소가 들어가는데 아직 입력받지 않아서 비어있음. 3번에서 오류발생 -> 뭐라도 넣어줘야함 -> null
		 * null은 아무것도 아닌 값을 뜻하는데, 아무것도 없다해도 초기화를 해주어야 사용할 수 있기 때문에 null을 입력해서 초기화 해주어야
		 * 한다.
		 */
		int[] scores = null;// 학생의 점수

		int i, j;
		Scanner sc = new Scanner(System.in);
		// 1, 2, 3, 4, 5 번중에 번호를 서ㅓㄴ택함
		// 5번을 입력할때까지 계속 반복함.
		while (true) {
			System.out.println("==================================");
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("==================================");
			System.out.print("선택>");
			int selectNo = sc.nextInt();
			// 1. 학생수 입력
			if (selectNo == 1) {
				System.out.print("학생수>");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
			}
			// 2. 점수입력
			else if (selectNo == 2) {
				for (i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "]>");
					scores[i] = sc.nextInt(); // 입력받아서 scores에 저장
				}
			}
			// 3. 점수리스트
			else if (selectNo == 3) {
				for (i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]:" + scores[i]);
				}
			}
			// 4. 분석
			else if (selectNo == 4) {
				int max = scores[0];
				int min = scores[0];
				int temp, sum=0;
				// 최고점수 출력
				for (i = 1; i < scores.length; i++) {
					if (max < scores[i]) {
						max = scores[i];
					}
				}
				System.out.println("최고점수:" + max);

				// 최저점수 출력
				for (i = 0; i < scores.length; i++) {
					if (min > scores[i]) {
						min = scores[i];
					}
				}
				System.out.println("최하점수:" + min);
				
				//평균 출력
				for(i=0; i<scores.length; i++) {
					sum+=scores[i];
				}
				System.out.println("평균:"+ sum/scores.length);
				System.out.println();
				
				// 정렬결과
				System.out.println("정렬한 결과");
				for (i = 0; i < scores.length - 1; i++) {
					for (j = i + 1; j < scores.length; j++) {
						if (scores[i] > scores[j]) {
							temp = scores[j];
							scores[j] = scores[i];
							scores[i] = temp;
						}
					}
				}
				for(i = 0; i < scores.length; i++) {
					System.out.print(scores[i]+" ");
				}
				System.out.println();
			}
			// 5. 종료
			else if (selectNo == 5) {
				break;
			}

		} // while
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}

}
