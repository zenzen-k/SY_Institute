class Person { // extends Object
	private String name;
	private int age;
	private char bloodType; // AB형은 넣을 수 없음. 일단 임의로 해보는것

	public Person(String name, int age, char bloodType) {
		super();
		this.name = name;
		this.age = age;
		this.bloodType = bloodType;
	}

	public boolean equals(Object o) {
		// Object o = new Person("태연",50,'O');
		if (o instanceof Person) { // 다운캐스팅을 할 수 있니?!
			Person p = (Person) o; // 다운캐스팅 함!!
			if (this.age == p.age && this.bloodType == p.bloodType) { // this는 p1의 주소를 받고, o.age에는 p2가 들어간다.
				return true;
			}
			else {
				return false;				
			}
		}
		else {
			return false; // if문이 참이 아닐때 리턴값도 작성해주어야 한다. 안그러면 에러뜸
			// 왜냐하면 boolean을 리턴해주어야 하는데, 위에 if가 참이 아닌 경우를 작성해주어야 해서
		}
	}

} // Person

public class Ex09_02_equals {

	public static void main(String[] args) {
		Person p1 = new Person("윤아", 50, 'A');
		Person p2 = new Person("태연", 50, 'A');
		
		boolean result = p1.equals(p2); // result 변수에 equals 메소드

		System.out.println("result:" + result);
		
		if(result) {
			System.out.println("나이와 혈액형이 같습니다.");
		} else {
			System.out.println("나이와 혈액형이 같지 않습니다.");
		}
		

		// Object equals 비교
	}

}
