import java.util.Scanner;

public class Ex09_11_김아연 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 1~45 사이의 정수 난수 6개를 발생 -> 배열에 담기
		int[] lotto = new int[6]; // 난수 들어가는 공간
		int[] my = new int[6]; // 내가 입력한 값

		// 다른 난수를 발생시켜야함! 앞의 방들과 비교
		int i, j;
		for (i = 0; i < lotto.length; i++) {
			int num = (int) (Math.random() * 45) + 1;

			for (j = 0; j < i + 1; j++) {
				while (num == lotto[j]) {
					num = (int) (Math.random() * 45) + 1;
				} // while
			} // for j
			lotto[i] = num;
		} // for i
		

		// 입력받는 값
		i = 0;
		do {
			System.out.print("숫자" + (i + 1) + ": ");
			int num = sc.nextInt();

			for (j = 0; j < i; j++) {
				while (num == my[j]) {
					System.out.print("중복됨숫자" + (i + 1) + ": ");
					num = sc.nextInt();

				} // while
			} // for j

			if (num < 1 || num > 45) {
				System.out.println("1~45의 수를 입력하세요.");
				continue;
			}

			my[i] = num;
			i++;
		} while (i < 6);

		// 전체 숫자 출력
		// 로또번호
		System.out.println("컴이 발생시킨 로또 번호");
		for (i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println("\n");
		// 입력받은 숫자
		System.out.println("내가 선택한 로또 번호");
		for (i = 0; i < my.length; i++) {
			System.out.print(my[i] + " ");
		}

		// 값 비교
		int count = 0;
		for (i = 0; i < lotto.length; i++) {
			for (j = 0; j < my.length; j++) {
				if (lotto[i] == my[j])
					count++;
			}
		}
		System.out.println("맞은 갯수 :" + count);
		if (count == 6) {
			System.out.println("1등입니다");
		} else if (count == 5) {
			System.out.println("2등입니다");
		} else if (count == 4) {
			System.out.println("3등입니다");
		} else {
			System.out.println("꽝!");
		}

		sc.close();

	}// main

}
