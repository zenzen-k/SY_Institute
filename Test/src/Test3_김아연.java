import java.util.ArrayList;
import java.util.Scanner;

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
} // Person

class Student extends Person {
	private int java;
	private int jsp;
	
	public Student(String name, int age, int java, int jsp) {
		super(name, age);
		this.java = java;
		this.jsp = jsp;
	}
	
	public String toString() {
		return getName() + "," + getAge() + "," + java + "," + jsp;
	}

	public int getJava() {
		return java;
	}

	public int getJsp() {
		return jsp;
	}
	
	public int avg(int java, int jsp) {
		return (int)((this.java+this.jsp)/2);
	}
	
} // Student

public class Test3_김아연 {
	public static void main(String[] args) {
		// 이름입력:
		// 나이입력:
		// 자바입력:
		// jsp입력:
		// -> suden 객체 입력하고 arrylist에 넣기
		// 계속? > n할떄까지 계속반복
		// 자바와 jsp 두과목의 평균
		// 찾는이름 -> 나이,자바,jsp점수
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		
		String name, cont;
		int age, java, jsp, i;
		boolean flag;
		// 입력
		while(true) {
			System.out.print("이름입력:");
			name = sc.next();
			
			System.out.print("나이입력:");
			age = sc.nextInt();
			
			System.out.print("자바입력:");
			java = sc.nextInt();
			
			System.out.print("jsp입력:");
			jsp = sc.nextInt();
			
			System.out.println("*******************************");
			
			list.add(new Student(name, age, java, jsp));
			
			System.out.print("계속?");
			cont = sc.next();
			if(cont.equals("n"))
				break;
		}
		System.out.println("ArrayList 사용한 결과");
		for(i = 0; i<list.size(); i++) {
			Student std = list.get(i);
			
			System.out.println(i + ":" + std + " 평균:" + std.avg(std.getJava(), std.getJsp()));
		}
		
		System.out.println("=============================");
		
		while(true) {
			flag = false;
			
			System.out.print("찾는 이름을 입력 : ");
			name = sc.next();
			for(i = 0; i<list.size(); i++) {
				Student std = list.get(i);
				if(std.getName().equals(name)) {
					flag = true;
					System.out.println(std.getAge() + "/" + std.getJava() + "/" + std.getJsp());
				}
			}
			
			
			if(flag == false) {
				System.out.println("찾는 이름이 없습니다.");
			}
			
			System.out.print("계속?");
			cont = sc.next();
			if(cont.equals("n"))
				break;
		}
		System.out.println("프로그램을 종료합니다.");
		
		sc.close();
	} // main
}
