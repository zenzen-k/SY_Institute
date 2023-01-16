class Test1 implements Runnable{

	@Override
	public void run() {
		for(int i =1; i<=50; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
} // Test1

public class Ex11_01_Thread {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		// 단일 스레드. 
		// 메인이 돌아가다가 run을 호출함으로 기다리는 상태에서 Test1 클래스로 가서 run메소드를 실행 후 다시 돌아와서 main메서드를 마무리
		Test1 t1 = new Test1();
		t1.run();
		
		// 멀티 스레드.
		// Test1 클래스에서 run 메서드가 실행되는 중에 main도 동시에 실행된다.
		Thread th1 = new Thread(t1); // new Thread(new Test1()) 도 가능
		th1.start();
		
		System.out.println("프로그램 끝");
		
	} // main
}
