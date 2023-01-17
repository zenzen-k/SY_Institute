// implements 인터페이스를 쓸때에는 객체를 두번 만들어야 하지만, 반드시 써야할 때에는 써야함...
// 여러개의 메소드 , 상속을 위해
class Horizental extends Thread{ 
	public void run() {
		for(int i = 0; i<300 ; i++) {
			System.out.print("-");
			if(i%50==0) // 50번 출력한 뒤에 엔터치기~
				System.out.println();
		}
	}
} // Horizental

class Vertical extends Thread{ 
	public void run() {
		for(int i = 0; i<300 ; i++) {
			System.out.print("|");
			if(i%50==0) // 50번 출력한 뒤에 엔터치기~
				System.out.println();
		}
	}
} // Vertical

public class Ex11_05_우선순위 {
	public static void main(String[] args) {
		// 메소드마다 우선순위(1~10)라는 것이 있으며, 우선순위를 주지 않으면 모든 메서드는 5순위이다.
		// 이러한 우선순위를 직접 설정할 수 있다.
		// 숫자가 높을 수록 우선순위가 높다.
		// main메소드의 우선순위는 5이다.
		
		System.out.println("프로그램 시작");
		
		Horizental ho = new Horizental();
		Vertical ve = new Vertical();		
		
		System.out.println("ho.getPriority():" + ho.getPriority()); // 정수 리턴.
		System.out.println("ve.getPriority():" + ve.getPriority()); // 정수 리턴.
		
		ve.setPriority(7);
		
		ho.start(); // Thread 부모가 물려준 start 메소드~
		ve.start();
		System.out.println("프로그램 끝");
	} // main
}
