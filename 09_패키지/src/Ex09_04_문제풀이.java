import java.util.Scanner;

class Person2_2 {
	private String id;
	private String pw;
	private String name;

	public Person2_2(String id, String pw, String name) {
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

} // Person2_2


public class Ex09_04_문제풀이 {

	public static void main(String[] args) {
		Person2_2[] arr = {
				new Person2_2("kim","1234","김연아"),
				new Person2_2("son","7777","손흥민"),
				new Person2_2("jooo","9876","조규성")
		};

		Scanner sc = new Scanner(System.in);
		String id, pw;
		int i;
		boolean flag = false;

		do {

			System.out.print("id입력:");
			id = sc.next();
			if(id.length()<3 || id.length()>9) {
				System.out.println("id는 3글자~8글자 입력해야 합니다.");
				continue;
			} //if

			else { // 2~8 사이 id 비교
				for(i=0; i<arr.length; i++) {
					if(arr[i].getId().equals(id)) {
						flag = true; // 찾았다는 뜻으로 작성함.
					} // if
				} // for
				
				
				// for문 바깥에 작성해야 한다. 비교해서 없을때마다 작성하게 되므로.
				if(flag == false) {
					System.out.println("일치하는 id가 없습니다.");
					continue;
				}
			}//else
			
			
			// pw 비교
			System.out.print("pw입력:");
			pw = sc.next();
			for(i=0; i<arr.length; i++) {
				if(arr[i].getId().equals(id)) {
					if(arr[i].getPw().equals(pw)) {
						System.out.println(arr[i].getName() + "님 반갑습니다.");
					}
					else {
						System.out.println("비번이 맞지않습니다.");
					}
				} // if
			}
			System.out.print("계속?");
			String retry = sc.next();
			if(retry.equals("n")) {
				break;
			}
		}while(true);
		System.out.println("프로그램을 종료합니다.");
	}

}
