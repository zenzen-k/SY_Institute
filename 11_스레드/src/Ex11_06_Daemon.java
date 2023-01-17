class DaemonTest extends Thread {
	public void run() {
		
		while(true) {
			// 3초 잠자고 깨어나서 if문이 참이면 autoSave()를 호출
			try {
				sleep(3*1000); // 1000은 1초!
				//Thread.sleep 으로 써도 되지만 어자피 상속받았으니까 sleep만 작성 가능!
			} catch (InterruptedException e) {
				e.printStackTrace(); // 굳이 안써도 되는데 자동완성으로 나왔으니까,,, 경로 역추적하는 메소드임!
			} 
			
			if(Ex11_06_Daemon.autoSave) { // autoSave -> 괄호가 없으니 변수임! 참이면~ static변수의 호출
				autoSave(); // autoSave메서드 호출함! -> 괄호 있으니 메서드!
			}
		} // while 
		
	} // run()
	
	// 사이사이에 나오는 이 기능을 데몬스레드라고 한다.
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
} // DaemonTest


public class Ex11_06_Daemon {
	
	// 클래스의 멤버변수. boolean의 기본값은 false이지만 일단은 이렇게 초기화~
	static boolean autoSave = false;
	public static void main(String[] args) {
		
		DaemonTest t = new DaemonTest(); // 객체생성
		t.setDaemon(true); // t를 Daemon메서드로 설정한다는 의미이며, true로 작성해준다.
		// 데몬 스레드로 설정되었기 때문에 메인이 끝나면 알아서 자동 강제 종료된다.
		t.start(); // start 하면 run이 호출
		
		for(int i = 1; i<=20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(i); // 쉬었다가 출력하는거임! sleep 뒤에 나왔응꼐
			
			// 5초마다 저장하기 위한
			if(i == 5)
				autoSave = true;
		}//for
		
		System.out.println("프로그램을 종료합니다.");
		
	} // main

}
