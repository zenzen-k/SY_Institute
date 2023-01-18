package Cartoon;

import java.util.Vector;

public class CartoonShop {

	Vector<String> v = new Vector<String>();

	public CartoonShop() {
		v.addElement("슬램덩크");
		v.addElement("명탐정 코난");
		v.addElement("원피스");
	}

	// 동시에 책을 빌릴수 없으니 동시에 하지 못하도록 동기화 해주어야 한다.
	public synchronized String lendCartoon() throws InterruptedException { // lendCartoon()메소드를 호출한 곳으로 던진다.

		Thread t = Thread.currentThread(); // 현재 접근한 스레드를 리턴한다.
		if (v.size() == 0) {
			System.out.println(t.getName() + " : 번호표 받음");
			// wait : 잠깐 실행을 멈추고 싶을 때 사용. sleep()은 자동으로 runnable 상태로 깨어남.
			// 하지만 wait은 notify()를 이용하여 복귀할 수 있도록 해주어야 한다. (수동) 항상 같이 써야함!!
			// wait - notrunnable / notify() - runnable
			// this 생략가능
			this.wait(); // InterruptedException이 발생할 수 있으므로 예외처리 해주어야 한다.
			System.out.println(t.getName() + " : 다음 순서");
		}
		String str = v.remove(v.size() - 1); // 2. 원피스 빌려쥬기 // 삭제하면 삭제한 데이터가 리턴된다.

		return str; // 받은 만화가 리턴된다!
	} // lendCartoon

	// 반납하기 - 얘도 동시에 할 수 없음!
	public synchronized void returnCartoon(String cartoon) {
		v.addElement(cartoon); // 책 반납
		notify(); // 기다리던 사람을 깨우기!!!
	} // returnCartoon
}
