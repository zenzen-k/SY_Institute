class Data {
	public int i = 0; // 지금 공유자원이다. AA의 run메서드, BB의 run메서드에서 사용하고 있다.
} // Data

class AA extends Thread {
	public void run() {
		for (int i = 0; i < 100000; i++) { // 지역변수 i
			Ex11_07_NotSyncTest.d.i++; // d객체의 static 멤버변수 i -> 이름으로 접근!!! 클래스명.멤버변수명
			// 공유자원을 사용하고 있는 윗줄 이 영역을 "임계영역"이라고 한다.
			
		} // for
		System.out.println("AA:" + Ex11_07_NotSyncTest.d.i);
	} // run()
} // AA

class BB extends Thread {
	public void run() {
		for (int i = 0; i < 100000; i++) {
			Ex11_07_NotSyncTest.d.i++; // 임계영역
		} // for
		System.out.println("BB:" + Ex11_07_NotSyncTest.d.i);
	} // run()
} // BB

public class Ex11_07_NotSyncTest {
	
	// d : 멤버변수로 Data 객체를 가짐
	public static Data d = new Data(); // d에 i변수가 하나 있당!
	
	public static void main(String[] args) {
		System.out.println("main 시작");
		
		AA t1 = new AA();
		BB t2 = new BB();
		
		t1.start();
		t2.start();
		
		
		System.out.println("main 끝");
	} // main
}


