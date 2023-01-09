class Robot {
	
} // Robot

class DanceRobot extends Robot {
	void dance() {
		System.out.println("춤을 춥니다.");
	}
} // DanceRobot

class SingRobot extends Robot {
	void sing() {
		System.out.println("노래를 합니다.");
	}
} // SingRobot

class DrawRobot extends Robot {
	void draw() {
		System.out.println("그림을 그립니다.");
	}
} // DrawRobot


public class Ex06_11_다형성 {
	public static void main(String[] args) {
		
		Robot a = (Robot)new DanceRobot();
		Robot b = new SingRobot();
		Robot c = new DrawRobot();
		
		// 변수 3개가 모두 같은 타입(Robot)이므로 배열로 만들 수 있다! 서로 다른 타입은 배열로 만들 수 없우..
		// 이런 경우에 배열로 관리가 된다는 편리한 점이 있기 때문엥
		Robot[] arr = {
						new DanceRobot(), // 100번지
						new SingRobot(),
						new DrawRobot()
					  };
		
		for(int i=0; i<arr.length; i++) {
			action(arr[i]);
			// i=0 arr[0]=100번지
			// i=1 arr[1]=200번지
			// i=2 arr[2]=300번지
		}
		
		
		
	}// main
	
//	Robot r = (Robot)new DanceRobot(); // i=0
//	Robot r = (Robot)new SingRobot(); // i=1 r=200번지 200번지=>SingRobot()의 참조값임
//	Robot r = (Robot)new DrawRobot(); // i=2 

	public static void action(Robot r) { // 업캐스팅(자식객체를 부모가 받아서)되면서 r변수에 객체의 주소가 넘어왔다!
//		r.dance(); // 부모가 갖고있지 않아서 자식의 메소드를 호출할 수 없음!
		if(r instanceof DanceRobot) { // 다운캐스팅이 가능하니? 라는 뜻! (위에서 업캐스팅해서 가능함.)
			DanceRobot dr = (DanceRobot)r; // 자식 = 부모; 다운캐스팅함!
			dr.dance();
		}
		else if(r instanceof SingRobot) { // arr[1]번방! 위의 조건문에는 자식클래스가 달라서 false가 된다.
			SingRobot sr = (SingRobot)r;
			sr.sing();
		}
		else if(r instanceof DrawRobot) {
			DrawRobot dw = (DrawRobot)r;
			dw.draw();
		}
		// 배열이 아니었다면 action메서드를 3번 정의해야 했지만, 다형성을 이용해 배열로 관리하여 하나의 메서드로 할 수 있었음  
		
	} // action
}
