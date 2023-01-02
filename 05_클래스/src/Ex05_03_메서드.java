
public class Ex05_03_메서드 {

	public static void main(String[] args) {	//main 메서드 정의 
		//프로그램이 처음 시작할 때에는 main메서드를 찾아감. main은 반드시 있어야 한다.
		//다른 메서드가 main보다 먼저 정의되더라도 항상 main메서드 먼저 실행된다.
		
		System.out.println("main 메서드 정의 시작");
		display();	//메서드 호출
		System.out.println("***********");
		display();
		System.out.println("###########");
		display();
		System.out.println("main 메서드 정의 끝");
		
	}//main
	
	//메서드 : 특정한 작업을 수행하도록 독립적으로 작성된 프로그램
	//반복되는 작업이 있을때 정의해놓고 필요할때마다 호출할 수 있도록 만들어놓은 프로그램이다.
	//메서드는 정의하면 호출할 수 있음. 호출하지 않으면 메서드를 정의한 이유가 없다.
	static void display(){ 	// display() 정의 : static 리턴타입 메서드이름(){ }
		System.out.println("자바 공부중");
		System.out.println("클래스 부분 공부중");
		System.out.println("너무 재미있음");
		return; // 호출한 곳으로 돌아간다. return을 사용하지 않더라도 자동으로 호출한 곳으로 다시 돌아가기 떄문에 생략가능함.
		
	}
}
