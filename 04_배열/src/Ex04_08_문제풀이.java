import java.util.Scanner;

public class Ex04_08_문제풀이 {

	public static void main(String[] args) {
		
		// 2~4번은 배열이 만들어져야만 실행가능한 코드들이다. 
		// NullPointerException -> 배열에 null값이 들어가 있어서 배열을 사용할 수 없는 에러
		
		int studentNum; // 학생수
		int[] scores = null;// 학생의 점수.	scores은 참조변수(관리자)
		//여기서 선언을 해주어야 아래의 모든 if문안에서 사용가능함
		//null을 넣음으로써 아직은 주소도 모르고 아무것도 아님을 나타낸다.

		int i, j, temp, max, min, sum=0;
		Scanner sc = new Scanner(System.in);
		
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
				scores = new int[studentNum];	//score엔 첫번째방의 주소!!! 기억하쟈
			}
			// 2. 점수입력
			else if (selectNo == 2) {
				if(scores==null) {
					System.out.println("1.학생수 먼저 입력하세요.");
					continue;	//for : 증감식, while or do~while : 조건식
				}
				for(i=0; i<scores.length; i++) {
					System.out.print("score["+i+"]>");
					scores[i] = sc.nextInt();
				}
			}
			// 3. 점수리스트
			else if (selectNo == 3) {
				if(scores==null) {
					System.out.println("1.학생수 먼저 입력하세요.");
					continue;
				}
				for (i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]:" + scores[i]);
				}
			}
			// 4. 분석
			else if (selectNo == 4) {
				if(scores==null) {
					System.out.println("1.학생수 먼저 입력하세요.");
					continue;	//for : 증감식, while or do~while : 조건식
				}
//				max = scores[0];
//				min = scores[0];
//				sum= scores[0];	//0이 아닌 scores배열의 0번값을 대입하여 for문을 하나루,,,
				max = min = sum = scores[0];	//대입하는 값이 모두 같으므로 한줄로 작성할 수 있다.
				
				//이렇게 for문 하나만 사용해서 코딩하는 것도 생각해볼것!
				for(i = 1; i<scores.length; i++) {
					sum += scores[i];	//합계
					if(max < scores[i]) {	//최고점수
						max = scores[i];
					}
					if(min > scores[i]) {	//최하점수
						min = scores[i];
					}
				}
				System.out.println("최고점수:"+max);
				System.out.println("최하점수:"+min);
				System.out.println("평균:"+sum/scores.length);
				
				//선택정렬을 이용한 정렬
				for(i = 0; i<scores.length-1; i++) {
					for(j = i+1; j<scores.length; j++) {
						if(scores[i]>scores[j]) {
							temp = scores[j];
							scores[j] = scores[i];
							scores[i] = temp;
						}
					}
				}
				System.out.println("정렬한 결과");
				for(i=0;i<scores.length; i++) {
					System.out.print(scores[i]+"\t");
				}
				System.out.println();
			}
			// 5. 종료
			else if (selectNo == 5) {
				break;	//반복문을 종료함.
			}
			else {
				System.out.println("1~5사이의 번호만 입력하세요.");
			}

		} // while
		System.out.println("프로그램을 종료합니다.");
		sc.close();
		
	}

}
