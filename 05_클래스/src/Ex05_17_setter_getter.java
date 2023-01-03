class Book2 {
	private String title;
	private String author;
	private int price;
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		if(price > 0)
			this.price = price;	//양수값만 받을 수 있도록 조건을 넣음
			//만약 음수의 가격을 넣으면 price에 값이 들어가지 않기 때문에 기본값인 0이 출력된다.
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
}
public class Ex05_17_setter_getter {

	public static void main(String[] args) {
		
		Book2 b = new Book2();
		b.setTitle("나미야 잡화점의 기적");
		b.setAuthor("히가시노 게이고");
		b.setPrice(13000);
		
		System.out.println(b.getTitle());
		System.out.println(b.getAuthor());
		System.out.println(b.getPrice());
	}

}
