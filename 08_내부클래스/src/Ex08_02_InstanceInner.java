class Car2 {
	Car2name name;
	String color;
	
	// instance inner class : 공유하고 싶은 자료가 없을 때 사용
	class Car2name {
		String model; 
		int year;
		
		Car2name(String model, int year) {
			this.model = model;
			this.year = year;
		}

		Car2name(String model, int year, String col) {
			this.model = model;
			this.year = year;
			color = col; 
		}

		void Outcolor() {
			System.out.println("model:"+model+" 연식:"+year+" 색상:" + color + "입니다.");
		}
	}//class Car2name

	Car2(String model, int year, String color) {
		name = new Car2name(model,year);
		this.color = color;
	}

	void OutInfo() {
		System.out.printf("모델 = %s, 년식 = %d, 색상 = %s\n",
				name.model, name.year, color);
	}
}

public class Ex08_02_InstanceInner {
	public static void main(String[] args) {
		Car2 pride = new Car2("프라이드", 2005, "파랑");
		// 참조변수.c = 10; 이런식의 접근
		pride.OutInfo(); // 모델 = 프라이드, 년식 = 2005, 색상 = 파랑
		System.out.println();
		
		pride.name.Outcolor(); // model:프라이드 연식:2005 색상:파랑입니다.
		System.out.println();
		
		//Outer.Inner 변수명 = 외부객체.new Inner(생성자 인수)
		Car2.Car2name pride2 = pride.new Car2name("프랑이", 2009);
		pride2.Outcolor(); // model:프랑이 연식:2009 색상:파랑입니다.
		System.out.println();
		
		Car2.Car2name pride3 = pride.new Car2name("노란프랑이", 2023,"노랑");
		pride3.Outcolor(); // model:노란프랑이 연식:2023 색상:노랑입니다.
		System.out.println();
		
		pride.OutInfo(); 
		System.out.println();
		
		pride.name.Outcolor();
		
	}
}