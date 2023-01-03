
public class Ex03_08_이중for {

	public static void main(String[] args) {
		
		int i, j;
		for (i = 1; i <= 3; i++) {
			for (j = 5; j <= 8; j++) {
				System.out.println(i + "," + j);
			} // 안쪽for문
			System.out.println("-----------");
		} // 바깥쪽for문
		System.out.println("##########");
		
		
		// 9,3 9,2 9,1 7,~~ 출력
		//if문을 빼고 for(i=9; i>4; i=i-2)로 작성해도 됨 <- 이 방법이 더 코드가 짧고 좋을듯!
		for (i = 9; i > 4; i--) {
			if (i % 2 != 0) {
				for (j = 3; j > 0; j--) {
					System.out.println(i + "," + j);
				}
				System.out.println("----");
			}
		}

		
		//2~9단 출력하기
		for (i = 2; i < 10; i++) {
			System.out.println("***" + i + "단***");
			for (j = 1; j < 10; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}
			System.out.println();
		}
		
		/*
		// 부등호의 방향을 주의할것 !
		for(i=1; i>=5; i++) {	//for(i=1; false; i++)가 됨.
			System.out.println(i);
		}
		
		
		//무한루프
		for(i=1; i<=5; i--) {
			System.out.println(i);
		}
		*/
	}

}
