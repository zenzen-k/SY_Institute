class Sub1 {
	int x = 5;

	void display() {
		System.out.println("Sub1 x : " + x);
	}
} // Sub1

class Sub2 extends Sub1 {
	// 오버라이딩했음! (메서드이름 같, 매개변수 개수와 타입 같, 리턴타입 같 -> 선언부 같!)
	void display() {
		System.out.println("Sub2 x*x : " + x * x);
	}

} // Sub2

public class Ex08_04_익명클래스 {
	public static void main(String[] args) {
		// 익명클래스 : 이름없는 클래스?

		Sub1 s1 = new Sub1();
		s1.display();
		Sub2 s2 = new Sub2();
		s2.display();

		// 클래스를 만들지 않고도 기존 클래스의 메서드를 다시 재정의할 수 있다! -> 익명클래스
		// Sub1을 새롭게 재정의를 함.
		new Sub1() {
			void display() {
				System.out.println("Sub2 x*x*x : " + x * x * x);
			} // display
		}.display(); // new Sub1()
		// 익명클래스의 호출 : 객체를 만듦과 동시에 호출을 한다.

	}

}
