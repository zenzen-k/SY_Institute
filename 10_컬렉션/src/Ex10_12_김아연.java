import java.util.HashMap;
import java.util.Scanner;

class Student {
	private String addr;
	private double height;
	private int kor;

	public Student(String addr, double height, int kor) {
		this.addr = addr;
		this.height = height;
		this.kor = kor;
	}

	public String toString() {
		return addr + "/" + height + "/" + kor;
	}
} // Student

public class Ex10_12_김아연 {
	public static void main(String[] args) {

		// 이름 : 키
		// 밑에 3개는 Student객체로 만들어서 값으로
		// 주소 :
		// 키 :
		// 국어 :
		// -> 계속? y 눌러서 계속 입력함. n ㄴㄴ -> 찾음
		// 찾는 이름 키에 해당하는 사람의 대한 값 출력학.
		// -> 계속? n -> 삭제 하면 남아잇는 값을 출력!

		Scanner sc = new Scanner(System.in);
		HashMap<String, Student> map = new HashMap<String, Student>();
		String name, addr, action;
		double height;
		int kor;
		
		while (true) {
			// 1.정보 입력
			System.out.print("이름 : ");
			name = sc.next();

			System.out.print("주소 : ");
			addr = sc.next();

			System.out.print("키 : ");
			height = sc.nextDouble();

			System.out.print("국어 : ");
			kor = sc.nextInt();

			map.put(name, new Student(addr, height, kor));

			// 계속 실행 여부
			System.out.print("계속?");
			action = sc.next();
			System.out.println();

			if (action.equals("n")) {
				System.out.println(map);
				break;
			}
		}

		while (true) {
			// 2.학생 정보 찾기
			System.out.print("찾는 이름 : ");
			name = sc.next();
			if (map.containsKey(name)) {
				System.out.println(map.get(name));
			} else {
				System.out.println("찾는 이름 없음");
			}

			// 계속 실행 여부
			System.out.print("계속?");
			action = sc.next();
			System.out.println();

			if (action.equals("n")) {
				break;
			}
		}

		while (true) {
			// 3.학생 정보 삭제
			System.out.print("삭제할 이름 : ");
			name = sc.next();
			if (map.containsKey(name)) {
				map.remove(name);
				System.out.println(map);
			} else {
				System.out.println("찾는 이름 없음");
			}

			// 계속 실행 여부
			System.out.print("계속?");
			action = sc.next();
			System.out.println();

			if (action.equals("n")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		sc.close();
	} // main
}
