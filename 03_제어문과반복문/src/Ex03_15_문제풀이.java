
public class Ex03_15_문제풀이 {

	public static void main(String[] args) {

		int i, sum = 0;
		for (i = 1; i <= 100; i++) {
			sum += i;
			if (i % 10 == 0) { // 10의 배수가 됐을때마다 출력함
				System.out.println("1~" + i + "=" + sum);
			}
		}

		System.out.println();

		sum = 0;
		for (i = 1; i <= 100; i++) {
			sum += i;
			if (i % 10 == 0) { // 10의 배수가 됐을때마다 출력함
				System.out.println(i - 9 + "~" + i + "=" + sum);
				sum = 0;
			}
		}

	}

}
