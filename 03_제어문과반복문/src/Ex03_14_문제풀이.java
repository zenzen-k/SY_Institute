
public class Ex03_14_문제풀이 {

	public static void main(String[] args) {

		// continue 사용
		for (int i = 2; i < 10; i++) {
			if (i % 2 != 0) {
				continue; // 홀수일때는 밑에 실행 X. break사용시 2단만 출력하고 끝나버림
			}
			System.out.println("==" + i + "단==");
			for (int j = 1; j < 10; j++) {
				if (i < j) {
					break; // continue도 가능함
					// break사용 시 조건을 만족할때 break가 포함된 가장 가까운 반복문, 즉 안의 for문을 빠져나옴!
					// continue를 사용 시 밑의 문장 실행안하고 다시 위로 올라감.(작은 for문안의  9까지 반복하다가 다시 맨위의 for문으로 간다)
					// -> break가 더 수행속도가 빠르다.
				}
				System.out.println(i + "*" + j + "=" + i * j);
			}
			System.out.println();
		}

	}

}
