
public class Ex04_05_김아연 {

	public static void main(String[] args) {
		
		//과제
		//2차원배열 하나 만들기 
		//학생들의 점수 들어감
		//5명학생의 세과목 점수. 숫자는 알아서 넣기
		int i,j,sum;
		int [][] score = {	//똑같은 배열을 정방배열이라고 함. (길이가 다른배열은 가변길이배열)
				{90,95,97},
				{75,71,74},
				{45,34,34},
				{51,61,65},
				{74,80,54}
		};
		
		//출력
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("=============================================");
		
		//학생 번호별 과목 점수
		for(i=0; i<score.length; i++) {
			sum=0;
			System.out.print((i+1)+"\t");	//번호 출력
			for(j=0; j<score[i].length; j++) {
				System.out.print(score[i][j] + "\t");	//학생별 과목 점수 출력
				sum += score[i][j];		//학생별 과목 총점 계산
			}
			System.out.print(sum + "\t" + sum/3.0);	//총점과 평균 출력
			System.out.println();
		}
		System.out.println("=============================================");
		System.out.print("총점:\t");
		
		// 과목별 총점 계산
		for(i=0; i<score[i].length; i++) {
			sum=0;
			for(j=0; j<score.length; j++) {
				sum += score[j][i];
			}
			System.out.print(sum + "\t");
		}
		
		
		
		
	}

}
