class Person2 {
	private String name;
	private int age;

	// 생성자
	public Person2() {

	}

	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 출력
	public void show() {
		System.out.println("name:" + name);
		System.out.println("age:" + age);
	}

}// Person2


class Employee2 extends Person2 {
//	private String name; // 부모로부터 상속
//	private int age;
	private String company;
	private String part;

	// 생성자
	public Employee2() {

	}

	public Employee2(String name, int age, String company, String part) {
		super(name, age);
		this.company = company;
		this.part = part;
	}

	// 출력
	public void show() {
		super.show();
		System.out.println("company:" + company);
		System.out.println("part:" + part);
	}

}// Employee2


class Teacher extends Employee2 {
//	private String name; // Person2 부모로부터 상속
//	private int age;
//	private String company; // Employee2 부모로부터 상속
//	private String part;
	private String subject;
	
	public Teacher() {
		
	}

	public Teacher(String name, int age, String company, String part, String subject) {
		super(name, age, company, part); //super() 부모의 생성자를 호출하는 것은 맨위에
		this.subject = subject;
	}

	public void show() {
		super.show(); // 요런건 위치 상관 X
		System.out.println("subject:" + subject);
	}

}// Teacher


public class Ex06_04_상속 {

	public static void main(String[] args) {

		Person2 p = new Person2("제니", 20);
		p.show();

		System.out.println("-----");
		Employee2 e = new Employee2("지디", 30, "쌍용출판사", "인사부");
		e.show();

		System.out.println("-----");
		Teacher t = new Teacher("태연", 50, "SM고", "생활지도부", "음악");
		t.show();
		
		
		Person2 arr[] = {
						 new Person2("제니", 20),
						 new Employee2("지디", 30, "쌍용출판사", "인사부"),
						 new Teacher("태연", 50, "SM고", "생활지도부", "음악")
		};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("-----");
			arr[i].show();
		}

	}// main

}
