class Parent {
	int x = 10;
	void method() {
		System.out.println("P_x:" + this.x); // x 라고 해도 됨
	}
}
class Child extends Parent {
	int x = 20;

	void method() {
		int x = 30;
		System.out.println("x=" + x); // 30
		System.out.println("this.x=" + this.x); // 20
		System.out.println("super.x=" + super.x); // 10
		
		super.method();
	}
}

public class Ex06_02_super {

	public static void main(String[] args) {
		
		Child c = new Child();
		c.method();
		
//		Parent p = new Parent();
//		p.method();
		
		
		
	}//main
} 
