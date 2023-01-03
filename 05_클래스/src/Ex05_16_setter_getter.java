class Person2 { // Person클래스는 이미 Ex05_01_클래스에서 정의함
	private String name; // private 을 사용한 변수는 다른 클래스에서 사용할 수 없다
	private int age;
	private double height;
	
	//보통 메서드는 public을 많이 사용한다. private을 사용해버리면 setName메서드 조차 호출할 수 없어 사용하지 않는다.

	//setter메서드 : set+대문자+변수 이렇게 써주는것이 좋음!
	//setter메서드는 보통 넘어오는 값을 받아서 그것을 private 변수에 넣음. 따라서 매개변수가 필요하며 리턴값이 필요 없으므로 리턴타입은 보통 void로 한다.
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	//setter메서드를 통해서 넣은 변수값을 리턴해주는 getter메서드
	public String getName(){
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getHeight() {
		return height;
	}
}

public class Ex05_16_setter_getter {

	public static void main(String[] args) {
		// 아주중요!

		Person2 p = new Person2();
		p.setName("이승기");
		p.setAge(40);
		p.setHeight(178.3);
		
		/*
		p.name = "이승기"; // The field Person2.name is not visible : Person2에 .name이 보이지 않는다!
		p.age = 40;
		p.height = 178.3;

		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.height);
		*/
		
		String name = p.getName();
		System.out.println(name);
		
		int age = p.getAge();
		System.out.println(age);
		
		double height = p.getHeight();
		System.out.println(height);
		System.out.println(p.getHeight()); //바로 호출해도 됨
	}

}
