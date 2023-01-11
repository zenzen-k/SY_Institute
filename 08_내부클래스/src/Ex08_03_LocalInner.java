
class Car4 {
	int wheel;
	void Drive() {
		System.out.println("부릉 부릉");
	}
}

public class Ex08_03_LocalInner {
	public static void main(String[] args) {
		// 메서드 안의 클래스. 마치 지역변수처럼 메서드 안에 있어서 지역 클래스라고 부른다.
		// 이 메서드안에서만 사용하고 싶고, 다른 메서드에서 사용하지 못하도록 하고 싶을 때 사용한다.
		// local inner class
		class Truck extends Car4 {	// Car4클래스를 상속받는다.
			void Drive() {
				final int door=4;
				System.out.println("우당탕 쿵탕");
				System.out.println("wheel:"+wheel);
			}

		} // Truck 클래스의 끝

		Truck porter = new Truck(); // 
		porter.wheel = 8;
		System.out.println("wheel:"+porter.wheel);
		porter.Drive(); // 우당탕 쿵탕
	}
	
}

