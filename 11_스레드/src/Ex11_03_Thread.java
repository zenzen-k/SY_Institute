class Big extends Thread{ // Thread
	// A~Z
	@Override
	public void run() {
		for(char i='A'; i<='Z'; i++) {
			System.out.print(i + " ");
			
			try {
				sleep(100);
				// Thread가 상속해줘서 이름 생략 가능
			} catch(InterruptedException e) {
				
			}
			
		}
	}
} // Big

class Small implements Runnable{// Runnable
	// a~z
	@Override
	public void run() {
		for(char i='a'; i<='z'; i++) {
			System.out.print(i + " ");
			
			try {
				//sleep 은 static이다. 클래스명으로 접근 하는 것을 보면!!!
				Thread.sleep(100); // 1초 씩 천천히
				// sleep메서드는 1초 잠자는 동안 예외가 발생할 수 있다.
				// 상속이 되지 않았으므로 클래스명 작성해주기.
			}catch(InterruptedException e) {
				
			}
			
			
		}
	} 
} // Small

public class Ex11_03_Thread {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		Big b = new Big();
		b.start();


		Thread s = new Thread(new Small());
		s.start();
		
		System.out.println("프로그램 끝");
	} // main
}
