class Book {
	String title;
	String author;
	int price;
	static String publisher;
}

public class Ex05_02_클래스 {

	public static void main(String[] args) {
		
		Book.publisher = "쌍용출판사";
		
		Book a1 = new Book(); // 객체생성
		a1.title = "토지";
		a1.author = "박경리";
		a1.price = 5000;

		System.out.println(a1.title);
		System.out.println(a1.author);
		System.out.println(a1.price);
		System.out.println(Book.publisher);
		System.out.println();

		Book a2 = new Book();
		a2.title = "1984";	// title은 Sting이기 때문에 숫자여도 문자열로 작성해야함.
		a2.author = "김철수";
		a2.price = 3000;
		
		System.out.println(a2.title);
		System.out.println(a2.author);
		System.out.println(a2.price);
		System.out.println(Book.publisher);
	}

}
