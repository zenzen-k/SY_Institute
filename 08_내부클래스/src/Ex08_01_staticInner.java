class Car1 {
	Car1name name; // name변수가 model과 year를 관리함.
	String color;

	// static inner class : 공유하고 싶은 자료가 있을 때 사용
	static class Car1name {
		static String model; 
		int year;
		// Car1name 생성자
		Car1name(String model, int year) {
			this.model = model;
			this.year = year;
		}
		Car1name(){

		}

	} // static inner의 끝

	// Car1 생성자
	Car1(String model, int year, String color) {
		// 생성자에서 안쪽 클래스 객체를 만든다.
		this.name = new Car1name(model,year); // Car1이 가진 Car1name클래스가 가지고 있어서 이렇게 작성.
		this.color = color;
	}
	Car1(){

	}
	void OutInfo() {
		System.out.printf("모델 = %s, 년식 = %d, 색상 = %s\n",
				name.model, name.year, color);
	}
} // Car1

public class Ex08_01_staticInner {
	public static void main(String[] args) {
		Car1 pride = new Car1("프라이드", 2005, "파랑");
		pride.OutInfo(); // 모델 = 프라이드, 년식 = 2005, 색상 = 파랑
		System.out.println(pride.color);
		System.out.println(pride.name.model);
		System.out.println(pride.name.year);
		System.out.println();

		Car1 pride2 = new Car1();
		System.out.println(pride2.name.model);   

		System.out.println("=====================");
		
		// static 내부 클래스를 객체로 만들고 싶을 때에는 이렇게 작성해야 한다. -> new 외부클래스.내부클래스
		// static 변수에 접근하듯이 !
		Car1.Car1name sonata = new Car1.Car1name("소나타", 2023);
		System.out.printf("모델 = %s, 년식 = %d\n", sonata.model,sonata.year);
		// 모델 = 소나타, 년식 = 2023

		Car1.Car1name sonata2 = new Car1.Car1name();
		System.out.printf("모델 = %s, 년식 = %d\n", sonata2.model,sonata2.year);
	}
}

