class Test2 extends Thread{
	@Override
	public void run() {
		for(int i =1; i<=50; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

public class Ex11_02_Thread {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		// 멀티 스레드
		Test2 t2 = new Test2();
		t2.start();
		
		System.out.println("프로그램 끝");
		
	}
}
