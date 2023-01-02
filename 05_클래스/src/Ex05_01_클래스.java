// Person이라는 클래스를 생성
class Person { // Person class 선언. 클래스명은 첫글자는 대문자로 작성한다. 숫자나 밑줄(_) 사용 가능함. 숫자로 시작X
	String name; // 멤버변수(인스턴스 변수) : 클래스 안에 선언한 변수. 객체(인스턴스)를 만들어야 생성되는 변수이기 떄문에 인스턴스 변수라고도 함
	int age;
	double height;
	static String nation; //공유변수	//똑같은 정보를 넣고 싶을 때에는 static을 사용함. nation이라는 공간이 하나만 생성된다. 여러 객체가 공유함
}

public class Ex05_01_클래스 {

	public static void main(String[] args) {
		/* 클래스는 자바의 핵심적인것! */
		/*
		 * 클래스 : 기본 데이터 타입의 한계로 인해 만들어짐. (변수 한개에 하나의 데이터만 넣을 수 있다는 한계점) 변수 하나에 여러개의 자료형과
		 * 데이터들을 담고 싶은데 이것을 "클래스"로 묶어 관리함. !!!! 즉, 클래스란 내가 만들어서 사용하는 자료형이다. ->
		 * "사용자 정의 자료형" 클래스 = 설계도 = 틀
		 * 
		 */

//		Person e;	//반드시 클래스를 선언해야 e변수를 선언할 수 있당.
		// int a;를 선언하는 순간 메모리 공간이 만들어지지만 Person e;를 한다고 공간이 생성되지 않는다.
		Person woman = new Person(); // 메모리 공간 생성 시점. 즉 name, age, height 멤버변수들의 공간이 만들어진다.
		// 위와 같은 new Person(); 메모리할당하는 것을 "객체를 만든다"고 한다.
		// man 변수는 참조변수라고 하며, 객체의 주소(참조값)를 가지고 있다. 데이터가 들어가있는것이 X.

		// 클래스 객체, 참조변수.멤버변수 = 값;
		woman.name = "아이유";
		woman.age = 30;
		woman.height = 189.2;
		Person.nation = "대한민국";

		// 출력할때에도 참조변수를 이용해야한다.
		System.out.println(woman); // 주소는 클래스명도 함께 나옴. ex) Person@515f550a
		System.out.println(woman.name);
		System.out.println(woman.age);
		System.out.println(woman.height);
		System.out.println(woman.nation);
		System.out.println("------------");

		// 클래스를 이용하여 여러개의 객체를 만들 수 있다
		Person man = new Person();	//new를 할때마다 다른 메모리주소가 할당이 된다.
		// instance 인스턴스. 객체와는 조금 차이는 있으나 비슷한 용어. 여기서는 인스턴스(객체)를 만든다로 봐도 무방함
		man.name = "이종석";
		man.age = 40;
		man.height = 162.3;

		System.out.println(man); // Person@76ccd017의 참조값을 가진 주소생성
		System.out.println(man.name);	//woman.name, man.name 둘다 name이지만 다른 주소를 가졌기 때문에 다름
		System.out.println(man.age);
		System.out.println(man.height);
		System.out.println(man.nation);	//위에서 선언하지 않았어도 공유변수이기 때문에 woman으로 넣은 대한민국 값이 출력된다. 
		System.out.println(Person.nation);
	}

}
