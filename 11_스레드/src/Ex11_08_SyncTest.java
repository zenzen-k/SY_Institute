class Data2 {
	public int i = 0;
} // Data

class AA2 extends Thread {
	public void run() {
		for (int i = 0; i < 100000; i++) { // 지역변수 i
			synchronized (Ex11_08_SyncTest.d) { // () 안에 공유자원이 있는 객체 작성
				Ex11_08_SyncTest.d.i++; // 임계영역				
			}
		} // for
		System.out.println("AA2:" + Ex11_08_SyncTest.d.i);
	} // run()
} // AA

class BB2 extends Thread {
	public void run() {
		for (int i = 0; i < 100000; i++) {
			synchronized (Ex11_08_SyncTest.d) { 
				Ex11_08_SyncTest.d.i++; // 임계영역				
			}
		} // for
		System.out.println("BB2:" + Ex11_08_SyncTest.d.i);
	} // run()
} // BB
public class Ex11_08_SyncTest {

public static Data2 d = new Data2(); 
	
	public static void main(String[] args) {
		System.out.println("main 시작");
		
		AA2 t1 = new AA2();
		BB2 t2 = new BB2();
		
		t1.start();
		t2.start();
		 
		
		System.out.println("main 끝");
	} // main

}
