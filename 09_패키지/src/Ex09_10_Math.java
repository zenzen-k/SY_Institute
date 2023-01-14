import static java.lang.Math.*;
// 안해도 됨 lang패키지는 자동이니까~
// * 은 모든 것을 의미한다. -> Math클래스를 쓰겠다는 의미

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

		// round 반올림해서 정수로 리턴해주는 메소드.
		long m1 = Math.round(4.3);
		System.out.println(m1);
		
		m1 = Math.round(4.9);
		System.out.println(m1);
		
		// ceil 올림해서 실수로 리턴함 (ceil : 천장. 즉 올린다!)
		double m2 = Math.ceil(4.3);
		System.out.println(m2);
		
		m2 = Math.ceil(4.9);
		System.out.println(m2);
		
		// floor 내림해서 실수로 리턴함. (floor : 바닥. 내린다!)
		// 위에 Math클래스를 import 해준다면 Math를 생략할 수 있다.
		double m3 = floor(4.9);
		System.out.println(m3);
		
		
	}

}





