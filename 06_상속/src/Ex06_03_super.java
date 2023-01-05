class Person {
	private String name;
	private int age;

	public Person() {
		System.out.println("Person() 생성자");
	}

	public Person(String name, int age) {
		System.out.println("Person(String name, int age) 생성자");
		this.name = name;
		this.age = age;
	}

	public void show() {
		System.out.println("name:" + name);
		System.out.println("age:" + age);
	}

}// Person

class Student extends Person {
//	private String name;
//	private int age;
	private String school;

	public Student() {
		// super(); // 부모의 생성자 호출. 디폴트생성자의 호출은 자동이므로 생략가능하나 인수를 받는 생성자는 반드시 작성해주어야함
		System.out.println("Student() 생성자");
	}

	public Student(String name, int age, String school) {
		super(name, age); // 부모생성자에 String, int 를 받을 수 있는 생성자로 가라!
//		this.name = name; // private으로 설정되어 있어서 에러가 뜬다. not visible "찾을수없음"
//		this.age = age;
		this.school = school;
	}

	// 출력
	public void show() {
//		System.out.println("name:" + name);	// 에러. 찾을 수 없음
//		System.out.println("age:" + age);
		super.show(); // Student객체 안에 있는 name과 age를 부모 클래스의 show메서드를 이용하여 출력한다.
		System.out.println("school:" + school);
	}
}// Student

class Employee extends Person {
//	private String name; // 부모로부터 상속
//	private int age;
	private String company;
	private String part;

	public Employee(String name, int age, String company, String part) {
		super(name, age);
		this.company = company;
		this.part = part;
	}

	public void show() { // 메서드 오버라이딩
		super.show();
		System.out.println("company:" + company);
		System.out.println("part:" + part);
	}

} // Empolyee

public class Ex06_03_super {

	public static void main(String[] args) {
		Person p = new Person("철수", 20);
		p.show();

		System.out.println("--------");
		Student s = new Student("수영", 30, "쌍용고");
		s.show();

		System.out.println("--------");
		Employee e = new Employee("정국", 37, "현대", "개발부");
		e.show();

	}// main
}
