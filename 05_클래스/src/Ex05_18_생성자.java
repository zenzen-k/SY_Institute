class Member {
	private String id;
	private String passwd;

	// default 생성자
	public Member() { // 생성자. 클래스 이름과 동일(대소문자구분)
		System.out.println("Member() 생성자");
		id = "park";
		passwd = "9876";
	}

	// String 2개를 받는 생성자. 이처럼 필요에 따라 다양하게 생성가능.
	public Member(String id, String passwd) { // 생성자 오버로딩 !!!
		System.out.println("Member(String x, String y)");
		this.id = id;
		this.passwd = passwd;
	}

	// String 1개를 받는 생성자
	public Member(String id) {
		System.out.println("Member(String id)");
		this.id = id;
		this.passwd = "9876"; // 안받은 값 정의
	}

	// setter메서드와 getter메서드
	public void setId(String id) { // 메서드 정의. 메서드는 어떤 기능을 가지고 있다.
		this.id = id;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getId() {
		return id;
	}

	public String getPasswd() {
		return passwd;
	}
} // Member class

public class Ex05_18_생성자 {

	public static void main(String[] args) {

		Member mb = new Member(); // mb 객체생성 - 생성자 호출

		mb.setId("kim"); // 메서드 호출
		mb.setPasswd("1234");
		System.out.println(mb.getId());
		System.out.println(mb.getPasswd());

		Member mb2 = new Member(); // mb2 객체생성

		System.out.println(mb2.getId());
		System.out.println(mb2.getPasswd());

		mb2.setId("jung");
		mb2.setPasswd("3333");
		System.out.println(mb2.getId());
		System.out.println(mb2.getPasswd());

		// constructor Member(String, String) is undefined 생성자 정의가 안됨
		Member mb3 = new Member("hong", "7777"); // 2개의 문자열을 받을 수 있는 생성자로 감
		System.out.println(mb3.getId());
		System.out.println(mb3.getPasswd());

		Member mb4 = new Member("choi");	//1개의 문자열을 받을 수 있는 생성자로 감
		System.out.println(mb4.getId());
		System.out.println(mb4.getPasswd());
		
		System.out.println("=====================");
		
		
		
		//객체 배열 만들기
		Member[] arr = new Member[4];
		arr[0] = mb;
		arr[1] = mb2;
		arr[2] = mb3;
		arr[3] = mb4;
		
		for(int i =0; i<arr.length; i++) {
			System.out.println(arr[i].getId());
			System.out.println(arr[i].getPasswd());
		}
		System.out.println("----------");
		
		
		//위에랑 똑같이 출력
		arr[0] = new Member();
		arr[0].setId("kim"); // 메서드 호출
		arr[0].setPasswd("1234");
		System.out.println(arr[0].getId());
		System.out.println(arr[0].getPasswd());
		
		arr[1] = new Member();
		System.out.println(arr[1].getId());
		System.out.println(arr[1].getPasswd());
		
		arr[1].setId("jung");
		arr[1].setPasswd("3333");
		System.out.println(arr[1].getId());
		System.out.println(arr[1].getPasswd());
		
		arr[2] = new Member("hong", "7777");
		System.out.println(arr[2].getId());
		System.out.println(arr[2].getPasswd());
		
		arr[3] = new Member("choi");
		System.out.println(arr[3].getId());
		System.out.println(arr[3].getPasswd());
		
		System.out.println("----------");
		
		
		//또다른방법?
		Member[] arr2 = {new Member(),
						 new Member(),
						 new Member("hong", "7777"),
						 new Member("choi")

		};
		
		arr2[0].setId("kim");
		arr2[0].setPasswd("1234");
		
		for(int i =0; i<arr2.length; i++) {
			System.out.println(arr2[i].getId());
			System.out.println(arr2[i].getPasswd());
		}
		System.out.println("----------");
		
		
		//또?
		Member[] arr3 = {mb, mb2, mb3, mb4};
		
		for(int i =0; i<arr3.length; i++) {
			System.out.println(arr3[i].getId());
			System.out.println(arr3[i].getPasswd());
		}
		
		
		System.out.println("=====================");
		Member[] ar2 ={new Member(), new Member(), new Member("hong", "7777"), new Member("choi")};
		ar2[0].setId("kim"); 
		ar2[0].setPasswd("1234");
		ar2[1].setId("jung");
		ar2[1].setPasswd("3333");
		
		int i;
		for(i=0; i<ar2.length; i++) {
			System.out.println(ar2[i].getId());
			System.out.println(ar2[i].getPasswd());
			System.out.println();
		}
		
	} // main

}
