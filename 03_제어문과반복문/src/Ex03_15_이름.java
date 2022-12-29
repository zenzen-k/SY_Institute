
public class Ex03_15_이름 {

	public static void main(String[] args) {
		
		//1~10 1~20 ... 1~100 반복돌면서 10의 배수가 될때마다 출력함. for문 안에서 총 10번 출력!
		int i;
		int sum =0;
		
		for(i=1; i<=100; i++) {
			sum += i;
			if(i%10==0) {
				System.out.println(1 + "~" + i + "=" + sum);
			}
		}
		System.out.println();
		
		//continue를 사용한 방식
		sum =0;
		for(i=1; i<=100; i++) {
			sum += i;
			if(i%10 != 0) {
				continue;
			}
			System.out.println(1 + "~" + i + "=" + sum);
		}
		System.out.println();
		System.out.println("============");
		System.out.println();
		
		
		
		//1~10 11~20 ... 91~100 숫자 10개씩의 합계를 구함.
		sum = 0;
		for(i=1; i<=100; i++) {
			sum += i;
			if(i%10==0) {
				System.out.println(i-9 + "~" + i + "=" + sum);
				sum = 0;
			}
		}
		System.out.println();
		
		//continue를 사용한 방식
		sum = 0;
		for(i=1; i<=100; i++) {
			sum += i;
			if(i%10!=0) {
				continue;
			}
			System.out.println(i-9 + "~" + i + "=" + sum);
			sum = 0;
		}
		System.out.println();
		
	}
}
