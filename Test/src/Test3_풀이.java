import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Person_2 {
	private String name;
	private int age;

	public Person_2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + "," + age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}// Person_2

class Student_2 extends Person_2 {
	private int java;
	private int jsp;

	public Student_2(String name, int age, int java, int jsp) {
		super(name, age);
		this.java = java;
		this.jsp = jsp;
	}

	public String toString() {
		return super.toString() + "," + java + "," + jsp + " 평균:" + (java + jsp) / 2;
	}

	public int getJava() {
		return java;
	}

	public int getJsp() {
		return jsp;
	}

} // Student

public class Test3_풀이 {

	public static void main(String[] args) {

		String name;
		int age, java, jsp, i;
		boolean flag;

		Scanner sc = new Scanner(System.in);
		ArrayList<Student_2> list = new ArrayList<Student_2>();

		do {
			System.out.print("이름입력:");
			name = sc.next();
			
			// 예외처리!
			do {
				try {
					System.out.print("나이입력:");
					age = sc.nextInt(); // 엔터를 날려야 자바입력까지 무사히 갈 수 있다.
					break; // 잘입력했으면 알아서 이줄 실행하나 잘못입력했다면 바로 밑으로 내려가버림.
				} catch (InputMismatchException e) {
					System.out.println("잘못입력하셨습니다. 숫자를 입력하세요");
					sc.next(); // 엔터를 읽어들이기. 엔터는 문자다.
				}
			} while (true);
			
			
			System.out.print("자바입력:");
			java = sc.nextInt();

			System.out.print("jsp입력:");
			jsp = sc.nextInt();

			Student_2 s = new Student_2(name, age, java, jsp);
			list.add(s);

			System.out.print("계속?");
			String retry = sc.next();
			if (retry.equals("n"))
				break;
		} while (true);

		System.out.println("ArrayList 사용한 결과");
		for (i = 0; i < list.size(); i++) {
			Student_2 stu = list.get(i);
			System.out.println(i + ":" + stu);
		}
		System.out.println("=============================");

		do {
			flag = false;
			System.out.print("찾는 이름을 입력 :");
			name = sc.next();
			for (i = 0; i < list.size(); i++) {
				if(list.get(i).getName().equals(name)) {
					flag = true;
					System.out.println(list.get(i).getAge()+"/"+list.get(i).getJava()+"/"+list.get(i).getJsp());
				}
			}
			if(flag == false)
				System.out.println("찾는 이름이 없습니다.");
			
			System.out.print("계속?");
			String retry = sc.next();
			if (retry.equals("n"))
				break;
			
		} while (true);
		System.out.println("프로그램을 종료합니다.");
		
		sc.close();
	} // main

}
