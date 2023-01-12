import java.util.Scanner;

class Person2 {
	private String id;
	private String pw;
	private String name;

	public Person2(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

} // Person2

public class Ex09_04_김아연 {

	public static void main(String[] args) {
		// Person2 객체 배열
		Person2[] arr = { new Person2("kim", "1234", "김연아"), new Person2("son", "7777", "손흥민"),
				new Person2("jooo", "9876", "조규성") };

		// 입력 : id입력:kim / pw입력:1234 -> 출력 : 김연아님 반갑습니다.
		// 맞으면 출력 : 계속? / 입력 : y / n -> 프로그램을 종료합니다.
		// 틀리면 비번이 맞지 않습니다. 일치하는 id가 없습니다. 출력 후 다시 입력함
		// id는 3글자~8글자 입력해야 합니다.

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("id입력:");
			String id = sc.next();
			boolean login = false;

			if (id.length() < 3 || id.length() > 8) {
				System.out.println("id는 3글자~8글자 입력해야 합니다.");
				continue;
			}
			// id 비교
			for (int i = 0; i < arr.length; i++) {
				if (id.equals(arr[i].getId())) {
					login = true;
					System.out.print("pw입력:");

					String pw = sc.next();
					// pw 비교
					if (pw.equals(arr[i].getPw())) {
						System.out.println(arr[i].getName() + "님 반갑습니다.");
						break;
					} else {
						System.out.println("비번이 맞지 않습니다.");
						break;
					}
				} // if id
			} // for id

			if (login == false) {
				System.out.println("일치하는 id가 없습니다.");
				continue;
			}

			System.out.print("계속?");
			String con = sc.next();
			if (con.equals("n")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} while (true);

	}

}
