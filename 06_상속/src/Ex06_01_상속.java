// 공통적인 name과 inwon을 Sports(상위클래스)에 넣어서 하위클래스(Baseball,Football)에서 사용가능
class Sports { // 부모클래스(상위클래스, 조상클래스)
	String name; // 스포츠
	int inwon; // 10

	// 생성자
	public Sports() {

	}

	public Sports(String name, int inwon) {
		this.name = name;
		this.inwon = inwon;
	}

	// 출력메서드
	public void display() {
		System.out.println(name + "," + inwon);
	}

}// Sports

//extends Sports : Sports 클래스를 상속받는다는 의미.
class Baseball extends Sports { // class 자식클래스명 extends 부모클래스명
	double ta;

	// 생성자
	public Baseball() {

	}

	public Baseball(String name, int inwon, double ta) {
		this.name = name; // this.name -> 부모클래스의 name을 가리킴
		this.inwon = inwon;
		this.ta = ta;
	}

	// 출력 메서드
	public void display() {
		System.out.println(name + "," + inwon + "," + ta);
	}

}// Baseball

class Football extends Sports {
	int goal;

	// 생성자
	public Football() {

	}

	public Football(String name, int inwon, int goal) {
		this.name = name;
		this.inwon = inwon;
		this.goal = goal;
	}

	// 출력 메서드
	public void display() {
		System.out.println(name + "," + inwon + "," + goal);
	}

}// Football

public class Ex06_01_상속 {

	public static void main(String[] args) {
		Sports s = new Sports(); // 객체생성
		s.name = "스포츠";
		s.inwon = 10;

		System.out.println(s.name);
		System.out.println(s.inwon);

		Sports s2 = new Sports("스포츠", 10);
		s2.display();

		System.out.println("--------");

		Baseball b = new Baseball();
		b.name = "야구"; // 상속을 받음으로써 name과 inwon을 사용 가능
		b.inwon = 9;
		b.ta = 0.567;

		System.out.println(b.name);
		System.out.println(b.inwon);
		System.out.println(b.ta);

		Baseball b2 = new Baseball("야구", 9, 0.567);
		b2.display();

		System.out.println("--------");
		Football f = new Football();
		f.name = "축구";
		f.inwon = 11;
		f.goal = 3;

		System.out.println(f.name);
		System.out.println(f.inwon);
		System.out.println(f.goal);

		Football f2 = new Football("축구", 11, 3); // 인자, parameter
		f2.display();

	}// main

}
