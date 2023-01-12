
public class Ex09_10_Math {

	public static void main(String[] args) {
		
		// 3~8 난수. 
		// 일단 Math.random()은 double을 리턴 하며, 1보다는 작은 0보다는 큰 랜덤의 실수가 나옴
		// 3~8 -> (8-3+1) + 3;  A~B -> (B-A+1) + A; 
		
		//0*6 <= d < 1*6 => (Math.random()*6)
		//0 <= d < 5.999999
		//0+3 <= d <= 5+3
		// 3 <= d <= 8
		for(int i = 1; i<=10; i++) {
			int ran = (int)(Math.random()*6) + 3;
			System.out.println(ran);			
		}
		
		// A~Z 출력 65 - 90
		char x = (char)((Math.random()*26) + 65);
		System.out.println(x);
		
		
		System.out.println(1);
		
		
	}

}
