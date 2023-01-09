class Animal{
	public void bark() {
		System.out.println("bark bark");
	}
}// Animal

class Dog extends Animal{
	public void bark() {
		System.out.println("멍멍");
	}
}//Dog


public class Ex06_09_다형성 {

	public static void main(String[] args) {
		
		int i = (int)3.7; // double(8) => int(4) 다운캐스팅
		double j = 3; // int(4) => double(8) 업캐스팅
		System.out.println(i);
		System.out.println(j);
		
		
		Animal a = new Animal();
		a.bark();

		Dog d = new Dog();
		d.bark();
		
		//자식객체를 받는 부모타입의 참조변수
		Animal d2 = new Dog(); // Dog(자식) -> Animal(부모) 업캐스팅 
//		Animal d2 = (Animal)new Dog();
		d2.bark();

		d = (Dog)d2;
//		d = (Dog)a; // Dog(자식) = Animal(부모). 부모를 자식에 넣으려고 하는 것은 다운캐스팅. 다운캐스팅은 강제로 써줘야함!
		d.bark(); // 또한, 다운캐스팅은 업캐스팅을 한 뒤에 사용이 가능하므로 다운캐스팅을 할 수 없다.
	}

}
