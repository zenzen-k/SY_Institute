import java.util.Scanner;

public class Ex09_11_문제풀이 {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		int[] my = new int[6];
		int i, j, count = 0;
		Scanner sc = new Scanner(System.in);

		// 난수
		for (i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1; // 1~45

			// 앞에방들과 비교. 0번방은 조건을 만족하지 않아서 안으로 들어가지 않는다. 굳이 if문 안써도 됨..!
			/* 헷갈리면 반복문 관련 문제 더 풀어보쟈
			 * i=0 j=0<1
			 * i=1 j=0<1 : 0
			 * i=2 j=0<2 : 0 1
			 * */
			for (j = 0; j < i; j++) { // 3번방이면 0,1,2 비교
				if(lotto[i] == lotto[j]) {
					lotto[i] = (int)(Math.random() * 45) + 1;
					j = -1; // -1로 초기화하면 다시 j가 증감식을 만나 0이 된다.(다시 0번부터 비교) 
							// -> while문을 안써도 이걸로 해결이 되었던거임,,
							// j--; 는 안된다. > 왜? 초기화해서 0이 되어야 하는데, -- 는 한번만 빼고 for문으로 가기 때문에
				} //if
			}//for j
		}//for i
		
		for(i=0; i<my.length; i++) {
			System.out.print("숫자"+(i+1)+":");
			my[i] = sc.nextInt(); // 1~45
			
			if(my[i]<1 || my[i]>45) {
				System.out.println("1~45사이의 수를 입력하세요");
				i--; // 문제가 있는 방에 다시 넣기 위해서. i--를 하지 않으면 다음방으로 넘어가버린다!
			}//if
			
			for(j=0; j<i; j++) {
				if(my[i] == my[j]) {
					System.out.print("중복됨");
					i--;
					break; // 중간에 같은방을 만나면 굳이 더 비교안해도 된다. 다시 입력되어야 함.
						   // 안쪽 for문을 나가서 바깥 for문의 증감식을 만남. 따라서 증감하지 않도록 i를 빼준다!
				}//if
			}//for j
			
			
		}//for i
		
		// 로또 출력
		System.out.println("컴퓨터가 발생시킨 로또 번호");
		for (i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println();

		// 내가 선택한 로또
		System.out.println("내가 선택한 로또 번호");
		for (i = 0; i < my.length; i++) {
			System.out.print(my[i] + " ");
		}
		
		// 비교
		for (i = 0; i < lotto.length; i++) {
			for (j = 0; j < lotto.length; j++) {
				if (lotto[i] == my[j]) {
					count++;
				}
			}
		}
		
		System.out.println();
		System.out.println("맞은 갯수:" + count);
		if (count == 6) {
			System.out.println("1등입니다");
		} else if (count == 5) {
			System.out.println("2등입니다");
		} else if (count == 4) {
			System.out.println("3등입니다");
		} else {
			System.out.println("꽝!");
		}
		
		//switch문으로도 작성가능!
		switch (count) {
		case 6:
			System.out.println("1등입니다");
			break;
		case 5:
			System.out.println("2등입니다");
			break;
		case 4:
			System.out.println("3등입니다");
			break;
		default:
			System.out.println("꽝!");
		}
		
	}

}
