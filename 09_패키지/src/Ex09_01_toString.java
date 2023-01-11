class Student {
	private String name;
	private int hakbun;
	
	public Student(String name, int hakbun) {
		// 모든 클래스는 Object클래스를 자동으로 상속받는다. 
		// 따라서 부모클래스를 우리가 설정하지 않아도 최고조상 클래스인 Object를 상속받기에 super();가 자동 호출 된다.
		super();
		this.name = name;
		this.hakbun = hakbun;
	}
	// 부모로부터 상속된 toString을 오버라이딩함. 
	// 부모의 toString은 public String toString()으로 정의되어 있기 때문에 public String으로 해주어야 함.
	// -> 오버라이딩은 선언부가 같아야 하기 떄문에
	public String toString() { 
		return name + "/" + hakbun;
	}
	
	// equals의 오버라이딩
	public boolean equals(Object obj) { // Object 자리에 Student를 작성해도 된다.
	// s2를 obj가 받고, s1은 this라는 변수가 받아준다.(this Object obj) this가 숨어있음
		// Object obj = new Student("슈가", 2007); > 현재 이렇게 물려받음. 
		// Object에는 변수가 없음!
		
		// 업캐스팅
		// 부모타입의 변수가 자식타입의 변수를 받았을 때에는 부모가 물려준 변수에만 접근한다.
		
		// 2번 방법.
		if(obj instanceof Student) {
			Student s = (Student)obj;
			return this.hakbun == s.hakbun && this.name.equals(s.name); // 정국학번(s1) == 슈가학번(s2)
												//문자열 비교는 equals !!!기억하자! 
		} else {
			return false;
		}
	}
} // Student

public class Ex09_01_toString {

	public static void main(String[] args) {
		Student s1 = new Student("정구", 2000);
		Student s2 = new Student("정국", 2000);
		
//		System.out.println(s1.str());
//		System.out.println(s2.str());
		
		// 부모로부터 상속받았기 때문에 사용가능!
		System.out.println(s1.toString()); // 문자열을 리턴. Student@515f550a 주소가 출력됐다.
		// toString() : 만들어진 객체의 주소를 문자열로 리턴해준다.
		// 참조변수만 사용해도 자동으로 사용되어 출력된다. (원래 메서드는 호출해야하지만 특이하게 자동으로 붙음)
		// 하지만 위에서 재정의 했음! 이런식으로 많이 사용된다.
		System.out.println(s1);
		System.out.println(s2);
		
		// equals 모든 클래스 객체를 다 받아줄거임~~~~~~~~
		boolean result = s1.equals(s2); // s1이 가진 equals를 사용함. s2를 넘겼다!. boolean을 리턴함.
		System.out.println("result:" + result); // false가 리턴 됨. -> 주소를 비교했기 때문에 주소가 다르다고 리턴함.
		// 위에서 equals가 학번을 비교하도록 재정의하고 나서는 true. 
	} // main

}
/*
 * public boolean equals​(Object obj)
 * Object obj = new Student()
 * -> 어떤 객체던 다 받아줄 수 있음.
 */