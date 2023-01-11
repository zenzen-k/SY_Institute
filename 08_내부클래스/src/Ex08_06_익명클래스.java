interface RemoteControll{ 
	void turnOn();
	void turnOff();
} // RemoteControll

class TV implements RemoteControll{

	@Override
	public void turnOn() {
		System.out.println("TV를 켠다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끈다.");
		
	}

} // TV
public class Ex08_06_익명클래스 {
	
	public static void main(String[] args) {
		// RemoteControll는 인터페이스라서 직접 객체 생성이 안되므로 자식클래스를 만들어서 메서드를 정의 후, 자식객체를 통해 호출함!
		TV t = new TV();
		t.turnOn();
		t.turnOff();
		
		// 한번에 두개를 동시에 호출할 수 없다. 인터페이스 객체도 이런식으로 완성하여 호출까지 가능함!~
		RemoteControll rc = new RemoteControll() {
			public void turnOn() {
				System.out.println("TV를 켠다.");
			}
			public void turnOff() {
				System.out.println("TV를 끈다.");
				
			}
		};
		// 별도호출. 인터페이스도 메서드가 하나였다면 참조변수 없이 앞에서 바로 호출한거처럼 사용 가능함!
		rc.turnOn();
		rc.turnOff();
		
	} // main

}
