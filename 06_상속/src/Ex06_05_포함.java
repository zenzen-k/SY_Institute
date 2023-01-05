class Person3 {
	private String name;
	int age;

	public Person3() {

	}

	public Person3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
}// Person3

class Worker /*extends Person3*/{
	Person3 p; // 참조변수
	String job;
	
	public Worker(String name, int age, String job) {
//		this.name = name; // name cannot be resolved or is not a field : 아예 사용할수없음!
		p = new Person3(name, age);
		// 상속이 아닌 Worker클래스 안에 Person3 객체를 포함시켰다 해서 포함관계라고 한다.
		this.job = job;
	}
	
	public void display() {
		System.out.println("name:" + p.getName());
		System.out.println("age:" + p.age);
		System.out.println("job:" + job);
	}
	
	
}//Worker

	

public class Ex06_05_포함 {
	public static void main(String[] args) {
		Worker w = new Worker("슈가", 70, "가수");
		//w변수에 있는 주소를 따라가면, Person3객체의 주소를 가진 p참조변수와, job 변수가 있다.
		w.display();
		
	}
}
