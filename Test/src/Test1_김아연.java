
public class Test1_김아연 {

	public static void main(String[] args) {
		// 1~100 5의 배수 이면서 동시에 7의 배수인 수 출력
		// for문,
		int i = 1;
		for (i = 1; i <= 100; i++) {
			if (i % 5 == 0) {	//조건을 하나로 묶어도 된다. (i % 5 == 0 && i % 7 == 0)
				if (i % 7 == 0) {
					System.out.print(i + " ");
				}
			}
		}
		System.out.println();
		

		// while문,
		i = 1;
		while (i <= 100) {
			if (i % 5 == 0) {
				if (i % 7 == 0) {
					System.out.print(i + " ");
				}
			}
			i++;
		}
		System.out.println();
		
		
		// do while문
		i = 1;
		do {
			if (i % 5 == 0) {
				if (i % 7 == 0) {
					System.out.print(i + " ");
				}
			}
			i++;
		} while(i <= 100);
		
		
	}

}
