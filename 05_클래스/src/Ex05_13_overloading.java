
public class Ex05_13_overloading {

	public static void main(String[] args) {
		// 오버로딩 : 하나의 메서드 이름으로 여러개의 메서드를 만드는 것
		// 이름은 같으나 매개변수가 다르면 중복되었다고 보지 않기 때문에 같은 이름의 메서드를 정의가능하다.

		star();
		star(7);
		star(3.7);
	}

	static void star() {
		System.out.println("*****");
	}

	static void star(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	static void star(double n) {
		// return 0.0 ; 생략되어있음
	}

	// 오류. 리턴타입은 보지 않는다. 오로지 매개변수의 타입과 개수만 봄
//	static int star(int n) {
//		
//	}
}
