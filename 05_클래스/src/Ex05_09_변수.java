class Count {
	static int a;
	int b;
	// 클래스 안의 멤버변수는 기본값 0이 들어가 있다.
	// 기본값 : int 0, double 0.0, boolean false, 참조형변수 null, String null

	void increment() { // increment 정의!!!!	이것은 메서드이지 멤버변수가 아니다!
		int c = 0; // 지역변수 : 메서드 안의 변수
		a++;
		b++;
		c++;
		System.out.println("static 변수 a:" + a);
		System.out.println("instance 변수 b:" + b);
		System.out.println("지역 변수 c:" + c);
		System.out.println();
	}
	/*
	void sub() {
		System.out.println(c); // 사용불가능함! 지역변수가 선언된 범위를 벗어났기때문이다
	}
	*/
}

public class Ex05_09_변수 {
	
	public static void main(String[] args) {

//		int x;	//지역변수. main 메서드 안에 들어가있기 때문
//		System.out.println(x);	//initialized. 초기화 안했다는 에러가 뜬다.

//		System.out.println(cnt1.a);	//클래스의 멤버변수는 기본값이 있음을 확인
//		System.out.println(cnt1.b);
		
		Count cnt1 = new Count(); // 객체생성
		
		cnt1.increment();
		cnt1.increment();
		
		Count cnt2 = new Count(); // 객체생성
		
		cnt2.increment();
		cnt2.increment();
		
		Count cnt3 = new Count(); // 객체생성
		
		cnt3.increment();
		cnt3.increment();
		
	}	//프로그램 종료 > static변수와 인스턴스 변수의 사라지는 시점

}
/*
 * 멤버변수 : 	정적변수/static/class -> 클래스이름 언급될때 생성 / main메서드가 끝나고 프로그램 종료시 소멸
 * 			인스턴스변수 -> 객체의 생성 / main메서드가 끝나고 프로그램 종료시 소멸
 * 매개변수 : 지역변수의 특징을 가진다.
 * 참조변수
 * 지역변수 : 자동초기화	-> 변수가 선언된 블록 { } 안으로 들어왔을 때 생성 / 변수가 선언된 블록 { }이 종료시 소멸
 * 			사용범위는 변수가 선언된 블록 { }안에서만 사용가능 
 * */