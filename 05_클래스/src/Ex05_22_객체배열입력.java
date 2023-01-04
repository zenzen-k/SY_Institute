import java.util.Scanner;

class Person3 {
	private String name;
	private int age;

	// 생성자
	public Person3(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 출력 메서드
	public void display() {
		System.out.println(name + "," + age);
	}

	// 다른 방법의 출력 메서드
	public String toString() {
		return name + "," + age; // kim,20 하나라도 문자가 있으면 문자열이다.
	}
}

public class Ex05_22_객체배열입력 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Person3[] arr = new Person3[3];

		int i;
		for (i = 0; i < arr.length; i++) { // 입력반복

			System.out.print("이름입력:");
			String name = sc.next();

			System.out.print("나이입력:");
			int age = sc.nextInt();

			arr[i] = new Person3(name, age);
		}

		for (i = 0; i < arr.length; i++) { // 출력반복
			arr[i].display();
		}
		System.out.println("-------");
		for (i = 0; i < arr.length; i++) { // 출력반복
			System.out.println(arr[i]); // 참조값 == 참조값.toString
		}

		sc.close();
	}

}
