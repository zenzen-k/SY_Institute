abstract class Shape{ // 추상 메서드를 가지고 있는 클래스도 추상클래스임. 둘다 미완성~
	public Shape() {
		System.out.println("Shape 생성자");
	}
	public void make() { // 정의
		System.out.println("도형 그리기");
	}
	
	public abstract void draw(); // 미완성 메서드 { } 가 없음.  -> 추상메서드. abstract 작성해줌
	public abstract void delete();
} // Shape

// 추상클래스를 상속받으면 미완성인 추상메서드까지 상속을 받게된다. 따라서 자식클래스도 abstract를 붙여주거나 완성시켜주어야함.
// 1. abstract 붙이기(abstract class Circle extends Shape) 또는
// 2. 자식 클래스에서 완성하기
class Circle extends Shape{ 
	public Circle() {	
		System.out.println("Circle 생성자");
	}
	public void draw() {
		System.out.println("원을 그린다.");
	}
	public void delete() {
		System.out.println("원을 지운다.");
		
	}
	
} // Circle

class Triangle extends Shape{
	public Triangle() {
		System.out.println("Triangle 생성자");
	}
	public void draw() { 	// 접근제어자를 부모보다 더 큰것을 사용하면 안된다.
		System.out.println("삼각형을 그린다.");
	}
	public void delete() {
		System.out.println("삼각형을 지운다.");
		
	}
} //Triangle


public class Ex06_12_추상 {
	public static void main(String[] args) {
//		new Shape(); // 미완성 클래스로는 객체를 만들 수 없다.
		// 미완성 메서드를 가진 미완성 클래스이지만, 자식클래스의 생성자를 통해서 부모클래스의 생성자로 넘어올수는 있다!
		Circle c = new Circle();
		// 숨어있는 super()에 의해서 부모 클래스의 생성자도 호출된당
		c.draw();
		c.delete();
		
		Triangle t  = new Triangle();
		t.draw();
		t.delete();
		
		//업캐스팅
		Shape[] arr = {new Circle(),new Triangle()};
		// 생성자 먼저 2개씩 출력 
		for(int i =0; i<arr.length; i++) {
			arr[i].draw();
			arr[i].delete();
		}
	}
}

/*
 * 클래스에 메서드가 아주 많다고 가정하자. 이때, draw()와 delete()가 아주 필수적인 메서드중 하나이다. 이럴 때 미완성으로
 * (추상메서드)로 해준다면, 핵심되는 중요한 메서드를 작성하지 않게 되면 미완성된 메소드라고 에러가 뜨기 때문에 까먹지 않고 완성할 수 있게 된다!
 * 즉, 반드시 강제로 오버라이딩 시키기 위한!
 * 또 전체적인 통일성도 줄 수 있음
 */