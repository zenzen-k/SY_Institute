import javax.swing.JOptionPane;

class Test3 extends Thread{
	public void run() {

		for(int i = 10; i>0 ; i--) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {

			}

		}
	} 
}// Test3

public class Ex11_04_Thread {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		Test3 t = new Test3();
//		t.run(); // 단일 스레드
		t.start(); // 멀티 스레드
		// JOptionPane.showInputDialog -> String 리턴.
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력한 값은 " + input + "입니다.");
		
		System.out.println("프로그램 끝");

	} // main

}
