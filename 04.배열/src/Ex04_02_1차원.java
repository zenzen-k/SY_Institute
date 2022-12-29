
public class Ex04_02_1차원 {

	public static void main(String[] args) {

		// 1~10 합계 출력
		int sum = 0;
		for (int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println(sum + "\n");

		sum = 0;
		int[] score = { 79, 88, 91, 33, 100, 55, 95 };
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
			sum += score[i];
		}
		System.out.println();
		System.out.println("score sum=" + sum);
		System.out.println("평균:" + sum / score.length + "\n");

		sum = 0;
		for (int x : score) {
			System.out.print(x + " ");
			// 출력문에 score[x]를 사용하게 되면 79번방, 88번방, 이런식으로 대입이 됨..
			sum += x;
		}
		System.out.println();
		System.out.println("score sum=" + sum);
		System.out.println("평균:" + sum / score.length + "\n");

		// int[] score = {79, 88, 91, 33, 100, 55, 95};
		int max;
		int min;

		// 최댓값과 최솟값
		max = score[0];
		min = score[0];
		for (int i = 1; i < score.length; i++) { // 이미 0번방의 값을 넣었기 때문에 0번방끼리의 비교는 의미가 없다.
			if (max < score[i]) {	// 배열의 데이터들을 하나씩 max와 비교하면서 큰값을 max에 넣음
				max = score[i]; 	// 변수 max의 값 변화 : 79 88 91 100 
			}
			if (min > score[i]) {
				min = score[i];		// 변수 min의 값 변화 : 79 33
			}
		}

		System.out.println("가장 큰 값:" + max);
		System.out.println("가장 작은 값:" + min);
	}

}
