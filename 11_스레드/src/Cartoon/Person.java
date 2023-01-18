package Cartoon;

public class Person extends Thread {

	public Person(String name) {
		super(name); // 부모생성자로 name을 넘김 (Thread에게 넘김 - 생성자 Thread(String name)로 넘어간다.)
	}
	// 스레드 이름들이 각각 0, 1, 이렇게 되지만 위에서 name을 생성자로 넘겼기 때문에 스레드 이름이 제니, 로제 등으로 설정된다.

	public void run() {
		try { // CartoonShop 클래스에서 예외를 던졌기 때문에 호출한 곳에서 처리를 해주어야 한다!
			String cartoon = Main.cshop.lendCartoon(); // Main클래스의 cshop 변수가 관리하고 있는 곳에 lendCaroon()메서드가 있다!
			System.out.println(getName() + " : " + cartoon + " 빌린다."); // 지금 접속한 스레드이름?
			System.out.println(getName() + " : " + cartoon + " 보는중..\n");

			sleep(5000); // 만화를 보는 시간 얘도 예외 필요함
			System.out.println(getName() + " : " + cartoon + " 반납함\n");
			Main.cshop.returnCartoon(cartoon); // 보던 만화 다시보냄

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
