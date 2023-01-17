class Data3 {
	public int i = 0;
	
	public synchronized void a() {
		for(int i = 0; i < 100000; i++) {
			this.i++; // 멤버변수 i
		}//for
		System.out.println("Data3 a() i : " + i);
	}
	
	public synchronized void b() {
		for(int i = 0; i < 100000; i++) {
			this.i++; // 멤버변수 i
		}//for
		System.out.println("Data3 b() i : " + i);
	}
} // Data3

class AA3 extends Thread {
	public void run() {
		Ex11_09_SyncTest.d.a(); // 변수에 접근하듯이 메서드도 같은 방식으로
	} // run()
} // AA3

class BB3 extends Thread {
	public void run() {
		Ex11_09_SyncTest.d.b();
	} // run()
} // BB3

public class Ex11_09_SyncTest {

public static Data3 d = new Data3(); 
	
	public static void main(String[] args) {
		System.out.println("main 시작");
		
		AA3 t1 = new AA3();
		BB3 t2 = new BB3();
		
		t1.start();
		t2.start();
		
		System.out.println("main 끝");
	} // main


}
