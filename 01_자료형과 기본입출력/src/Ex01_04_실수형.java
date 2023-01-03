
public class Ex01_04_실수형 {
	public static void main(String[] args) {
		/*실수형 자료형 
		 * float (4)10의38승, 
		 * double (8)10의380승 */
		float a;
		//a=1.1;	-> Type mismatch: cannot convert from double to float
		//그냥 실수를 작성하면 double형으로 생각함. 따라서 에러가 뜸. float을 사용할 때에는 반드시 f를 붙여주어야 함
		a = 1.1F;
		
		double b;
		b = 2.2;	//d,D 를 사용해도 되나 생략가능함 (2.2d;)
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		float f1 = 0.0012300f;	//마지막 유효숫자 0은 안나옴
		System.out.println("f1:" + f1);
		
		float f2 = 1.123456789f;
		System.out.println("f2:" + f2);	//7번째 자리까지 나오는데 8번째 자리를 보고 반올림을 함
		
		float f3 = 123f;	// 4byte에 4byte를 넣음
		System.out.println("f3:" + f3);	//실수자리 . 123.0
		
		//int i4 = 1.23f;		// 4 <- 4 이지만 안됨. float이 더 큰 그릇이라 생각함. Error Type mismatch: cannot convert from float to int
		int i4 = (int)1.23f;	//잠깐 int형으로 바꿔줘~ 강제형변환.
		System.out.println("i4:" + i4);	//.~ 숫자는 빼고 정수부분만 출력함 (반올림X. ex int i4 = 1.7 => 1 출력)
		
		//double d1 = 0.123;		// d1 = .123; 이렇게 사용도 가능
		double d1 = .123e4;		// 0.123 * 10^4	. e, E 둘다 가능
		System.out.println("d1:" + d1);	
		double d2 = .123e-5;	// 0.123 * 10^-5. e, E 둘다 가능
		System.out.println("d2:" + d2);		// 출력 결과가 길면 d2:1.23E-6 이런식으로 출력된다.
		
	}
}
