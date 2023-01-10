interface Copymachine{
// 인터페이스 : 몸체가 없는 추상 메서드와 상수로만 구성된 클래스. 완성된 메서드가 있으면 안된다.
// 클래스 안에서는 abstract를 작성해주어야 하나, 인터페이스 안에는 어자피 추상메서드만 들어가기 때문에 안붙여도 된다.
	void copy(); // 인터페이스에는 public abstract가 자동으로 들어온다.
	int age = 30;
//	final int age = 30; //final이 자동으로 들어감. 상수
	
	
}

interface Printmachine{
	public void print();
}

interface Faxmachine{
	public void fax();
} //Faxmachine


class AA{
	
} // AA


// 인터페이스를 사용함으로서 어떤 틀, 양식을 가지고 있기 때문에 표준화가 가능해진다.
class Compound extends AA implements Copymachine, Printmachine, Faxmachine{//복합기
	
	public Compound() {
		System.out.println("Compound 생성자");
	}
	
	
	
	//int age = 30; 상속!
	
	@Override
	public void copy() {
		System.out.println("복사한다.");
	}

	@Override
	public void fax() {
		System.out.println("팩스보낸다.");
	}
	
	@Override
	public void print() {
		System.out.println("프린트한다.");
	} 
	
	
} //Compound
public class Ex06_14_interface {
	public static void main(String[] args) {
		
		Compound c = new Compound();
		c.copy();
		c.fax();
		c.print();
		//The static field Copymachine.age should be accessed in a static way : static 방식으로 접근해라.
		System.out.println(c.age);
		//따라서 아래처럼 인터페이스명.변수 / 클래스명.변수 -> 이런방식의 접근
		System.out.println(Copymachine.age);
		System.out.println(Compound.age);
		
//		c.age = 70;
		//assigned (할당)
		//The final field Copymachine.age cannot be assigned : final 변수라서 값을 다시 할당할 수 없다. 
		
		System.out.println();
		
		// 부모가 가지고 있지 않은 메서드는 사용할 수 없으므로 에러가 뜸.
		Copymachine c2 = new Compound();
		c2.copy();
//		c2.fax();
//		c2.print();
		
	}

}


/*
 * 추상클래스 특징
 * 추상 메서드만 있을 수도 있고 정의된 메서드도 있을 수 있다.
 * 생성자를 만들 수 있다.
 * 
 * 인터페이스는 추상메서드와 상수로만 구성되어 있음!
 * 생성자를 만들 수 없다.
 */
