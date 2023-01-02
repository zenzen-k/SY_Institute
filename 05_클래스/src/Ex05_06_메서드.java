class Fruit {
	void apple() {
		System.out.println("apple");
	}
	static void banana() {
		System.out.println("banana");
	}
}//Fruit

public class Ex05_06_메서드 {
	
	public static void main(String[] args) {
		
		//4가지 과일 메서드 호출
		Fruit fr1 = new Fruit();
		fr1.apple();
		
		fr1.banana();
		Fruit.banana();
		
		Ex05_06_메서드 fr2 = new Ex05_06_메서드();
		fr2.orange();
		
		fr2.melon();
		melon();
		Ex05_06_메서드.melon();
		
	}//main
	
	void orange() {
		System.out.println("orange");
	}
	static void melon() {
		System.out.println("melon");
	}

}
