// 다중상속, 3개클래스, 멤버변수 클래스당 최소2개 이상, super()반드시 사용, 모든 멤버변수는 private, 
class Machine {
	private String mchnType; // 게임 실행 기계 종류
	private String platf; // 실행 플랫폼

	public Machine(String mchnType, String platf) {
		this.mchnType = mchnType;
		this.platf = platf;
	}

	public void display() {
		System.out.println("기계타입:" + mchnType);
		System.out.println("플랫폼:" + platf);
	}

} // Machine

class Game extends Machine {
	private String gname;
	private String genre;
	private int rtn; // 나이 제한

	public Game(String mchnType, String platf, String gname, String genre, int rtn) {
		super(mchnType, platf);
		this.gname = gname;
		this.genre = genre;
		this.rtn = rtn;
	}

	public void display() {
		super.display();
		System.out.println("게임이름:" + gname);
		System.out.println("게임장르:" + genre);
		System.out.println("연령제한:" + rtn + "세");
	}

} // Game

class Purchase extends Game {
	private String ESD; // 구매사이트
	private int price;

	public Purchase(String mchnType, String platf, String gname, String genre, int rtn, String ESD, int price) {
		super(mchnType, platf, gname, genre, rtn);
		this.ESD = ESD;
		this.price = price;
	}

	public void display() {
		super.display();
		System.out.println("유통망:" + ESD);
		System.out.println("가격:" + price + "원");
	}
} // Purchasec

public class Ex06_08_김아연 {
	public static void main(String[] args) {

		Purchase game1 = new Purchase("PC", "window", "데이브 더 다이버", "경영 시뮬레이션", 12, "steam", 24000);
		game1.display();
		System.out.println("------");
		
		Purchase game2 = new Purchase("console", "PlayStation 5", "GTA5", "오픈 월드 액션 어드벤처", 19, "playstaionStore", 33000);
		game2.display();
	}

}
