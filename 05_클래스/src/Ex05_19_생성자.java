class Music {
	private String title;
	private String singer;
	private String genre;
	private int price; // 연산하지 않는 생년월일이나 전화번호는 문자열로 표현하지만 금액같은 것은 int로 표현한다.

	// default 생성자
	public Music() {
		this.title = "분홍신"; // this. 붙여도 되고 안 붙여도 되고
		singer = "아이유";
		genre = "발라드";
		price = 1000;
	}

	// 생성자
	public Music(String title, String singer, String genre, int price) {
		this.title = title; // this. 필수
		this.singer = singer;
		this.genre = genre;
		this.price = price;
	}

	// setter메서드
	public void setTitle(String title) {
		this.title = title;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	// getter메서드
	public String getTitle() {
		return title;
	}

	public String getSinger() {
		return singer;
	}

	public String getGenre() {
		return genre;
	}

	public int getPrice() {
		return price;
	}

	public void display() {
		System.out.println("노래제목:" + title);
		System.out.println("가수명:" + singer);
		System.out.println("장르:" + genre);
		System.out.println("가격:" + price);
		System.out.println();
	}
}

public class Ex05_19_생성자 {

	public static void main(String[] args) {

		// 디폴트 생성자를 통한 주입 : 분홍신 아이유 발라드 1000
		Music m1 = new Music();
		System.out.println(m1.getTitle());
		m1.display();

		// 생성자를 통한 주입
		Music m2 = new Music("사건의지평선", "윤하", "댄스", 3000);
		System.out.println(m2.getSinger());
		m2.display();

		// setter : 어머나 장윤정 트로트
		Music m3 = new Music();
		m3.setTitle("어머나");
		m3.setSinger("장윤정");
		m3.setGenre("트로트");
		m3.setPrice(5000);
		
		System.out.println(m3.getPrice());
		m3.display();

	} // main

}
