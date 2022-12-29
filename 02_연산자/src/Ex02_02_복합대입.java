
public class Ex02_02_복합대입 {

	public static void main(String[] args) {
		
		int a=10, b=20, c=30, d=40, e=50;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
		System.out.println("e=" + e);
		System.out.println();
		
		// = 대입 연산자, += 복합 대입 연산자
		a += 3;	// a = a+3;
		System.out.println("a=" + a);
		
		b -= 7;
		System.out.println("b=" + b);

		c *= 4;
		System.out.println("c=" + c);
		
		d /= 8;
		System.out.println("d=" + d);
 		
		e %= 6;
		System.out.println("e=" + e);
		
		char ch1='a';	//97
		System.out.println("ch1=" + ch1);
		
		//ch1 += 2 는 안됨. 왜냐! ch1(char 2바이트) + 2(int 4바이트) 이기 때문에 char안에 들어갈 수 없음
		ch1 = (char)(ch1+2);	// 97 + 2 =99. 연산 결과 99를 char로 바꿔라~
		System.out.println("ch1=" + ch1);
		
		//복합대입연산은 자동으로 처리가 된다.
		ch1 += 2;
		System.out.println("ch1=" + ch1);
		
		String fruit = "apple";
		System.out.println("fruit=" + fruit);
		//문자열의 덧셈은 연속해서 출력
		fruit += "banana";// fruit = fruit + "banana"; 같은 의미. 
		System.out.println("fruit=" + fruit);
	}

}
