class Product_kay {
	private String code;
	private String name;

	public Product_kay(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public void display() {
		System.out.println("code:" + code);
		System.out.println("name:" + name);
	}
}// Product_kay

class Book_kay extends Product_kay { // extends
	private int price;
	private String publisher;

	public Book_kay(String code, String name, int price, String publisher) {
		super(code, name);
		this.price = price;
		this.publisher = publisher;
	}

	public void display() {
		super.display();
		System.out.println("price:" + price);
		System.out.println("publisher:" + publisher);
	}

}// Book_kay

class NoteBook_kay extends Product_kay {
	private String os;
	private String ram;

	public NoteBook_kay(String code, String name, String os, String ram) {
		super(code, name);
		this.os = os;
		this.ram = ram;
	}

	public void display() {
		super.display();
		System.out.println("os:" + os);
		System.out.println("ram:" + ram);
	}

}// NoteBook_kay

public class Test2_김아연 {

	public static void main(String[] args) {
		// 1번출력
		Product_kay p1 = new Product_kay("P1", "제품명");
		Product_kay p2 = new Book_kay("B2", "재미있는자바", 3000, "쌍용출판사");
		Product_kay p3 = new NoteBook_kay("N3", "갤럭시북", "window10", "16GB");
		
		p1.display();
		System.out.println();
		p2.display();
		System.out.println();
		p3.display();
		System.out.println();

		System.out.println("======");

		// 2번출력. 배열로 반복하여 출력
		Product_kay[] p4 = {new Product_kay("P1", "제품명"),
							new Book_kay("B2", "재미있는자바", 3000, "쌍용출판사"),
							new NoteBook_kay("N3", "갤럭시북", "window10", "16GB")};
		
		for(int i=0; i<p4.length; i++) {
			p4[i].display();
			System.out.println();
		}

	}

}
