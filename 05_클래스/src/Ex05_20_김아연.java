// 수업시간에 하지 않은 클래스를 만들기 (person, music, book)
// 멤버변수 최소 3개
class Snack {
	private String name;
	private String brand;
	private int price; // 가격
	private int stock; // 재고

	// default 생성자
	public Snack() {
		name = "새우깡";
		brand = "농심";
		price = 1500;
		stock = 10;
	}

	// 생성자
	public Snack(String name, String brand, int price, int stock) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
	}

	// setter메서드
	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// getter메서드
	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	// 전체 출력 메서드
	public void display() {
		System.out.println("이름:" + name);
		System.out.println("브랜드:" + brand);
		System.out.println("가격:" + price + "원");
		System.out.println("재고:" + stock);
		System.out.println();
	}
}

public class Ex05_20_김아연 {

	public static void main(String[] args) {
		// 객체 3개
		// 전체를 출력하는 메서드(1,3)
		// getter 통한 출력(2)

		// 1.default 생성자를 통한 주입 ()
		Snack sn1 = new Snack();

		// 2.생성자를 통한 주입 (값을 넣어서~)
		Snack sn2 = new Snack("홈런볼", "해태제과", 1800, 20);

		// 3.setter 메서드를 통한 주입
		Snack sn3 = new Snack();
		sn3.setName("빅파이");
		sn3.setBrand("크라운제과");
		sn3.setPrice(4500);
		sn3.setStock(30);

		
		// 1. 전체 출력 메서드
		sn1.display();
		// 2. getter 메서드를 이용한 출력
		System.out.println("이름:" + sn2.getName());
		System.out.println("브랜드:" + sn2.getBrand());
		System.out.println("가격:" + sn2.getPrice() + "원");
		System.out.println("재고:" + sn2.getStock());
		System.out.println();
		// 3. 전체 출력 메서드
		sn3.display();
		
		
		// 객체 배열 추가
		Snack[] arr = { new Snack("포카칩","오리온",3000,5),
						new Snack("초코파이","롯데",4000,15),
						new Snack("미쯔","오리온",800,25)};
		// 객체 배열 출력
		for(int i=0; i<arr.length; i++) {
			arr[i].display();
		}
		
	}

}
