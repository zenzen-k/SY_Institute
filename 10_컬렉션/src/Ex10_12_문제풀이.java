import java.util.HashMap;
import java.util.Scanner;

class Student_2 {
	private String addr;
	private double height;
	private int kor;

	public Student_2(String addr, double height, int kor) {
		this.addr = addr;
		this.height = height;
		this.kor = kor;
	}
	
	public String toString() {
		return addr + "/" + height + "/" + kor;
	}
} // Student

public class Ex10_12_문제풀이 {
	public static void main(String[] args) {

		HashMap<String, Student> map = new HashMap<String, Student>(); // HashMap 객체 생성
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("이름:");
			String name = sc.next();

			System.out.print("주소:");
			String addr = sc.next();

			System.out.print("키:");
			double height = sc.nextDouble();

			System.out.print("국어:");
			int kor = sc.nextInt();

			Student s = new Student(addr, height, kor);
			map.put(name, s);

			System.out.print("계속?");
			String retry = sc.next();
			if(retry.equals("n"))
				break;
		} // while
		System.out.println(map);
		
		while(true) {
			System.out.print("찾는 이름:");
			String name = sc.next();
//			if(map.get(name) == null) { 
//			// 내가 한 과제랑 차이가 있는 부분! constainsKey를 해도 되지만, get을 통해서 데이터를 가져와도 된다.
//			// 가져올게 없으면 null을 출력하며, 있다면 값(value)을 가져온다.
//				System.out.println("찾는 이름 없음");
//			}
//			else {
//				System.out.println(map.get(name));
//			}
			if(map.containsKey(name)) {
				System.out.println(map.get(name));
			}
			else {
				System.out.println("찾는 이름 없음");
			}
			
			System.out.print("계속?");
			String retry = sc.next();
			if(retry.equals("n"))
				break;
		} // while
		
		while(true) {
			System.out.print("삭제할 이름:");
			String name = sc.next();
			if(map.get(name) == null) {
				System.out.println("찾는 이름 없음");
			}
			else {
				map.remove(name);
				System.out.println(map);
			}
			
			System.out.print("계속?");
			String retry = sc.next();
			if(retry.equals("n"))
				break;
		} // while
		System.out.println("프로그램을 종료합니다.");
		
		sc.close();
	}
}
