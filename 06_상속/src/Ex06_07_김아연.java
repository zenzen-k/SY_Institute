//과제~ 
// 06_01 1번예제
class Sports2 {
	private String name;
	private int inwon;
	//생성자
	public Sports2(String name, int inwon) {
		this.name = name;
		this.inwon = inwon;
	}
	//출력
	public void display() {
		System.out.print(name + "," + inwon);
	}
	
} // Sports2

class Baseball2 {
	// Sports2를 포함(상속X)
	Sports2 s;
	private double ta;
	//생성자
	public Baseball2(String name, int inwon, double ta) {
		s = new Sports2(name, inwon);
		this.ta = ta;
	}
	//출력
	public void display() {
		s.display();
		System.out.println("," + ta); // this.ta
	}
} // Baseball2


public class Ex06_07_김아연 {
	public static void main(String[] args) {
		Baseball2 b = new Baseball2("야구", 9, 0.567);
		b.display();
	} // main
}
