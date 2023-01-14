import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Music {
	private String title;
	private String singer;
	private int price;

	public Music(String title, String singer, int price) {
		super();
		this.title = title;
		this.singer = singer;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}

	public String getSinger() {
		return singer;
	}

	public int getPrice() {
		return price;
	}

	public String toString() {
		return title + "," + singer + "," + price;
	}
	
} // Music

public class Ex10_04_ArrayList {
	public static void main(String[] args) {

		int i;
		String retry;
		//배열로
		Music[] mu = {  new Music("ditto", "뉴진스", 500), 
						new Music("Oh", "소녀시대", 600), 
						new Music("step", "카라", 700) };

		ArrayList<Music> list = new ArrayList<Music>();
		//ArrayList에넣기
		for (i = 0; i < mu.length; i++) {
			list.add(mu[i]);
		}
		
		//입력받아보기
		Scanner sc  = new Scanner(System.in);
		
		while(true) {
			System.out.print("제목:");
			String title = sc.next();
			
			System.out.print("가수명:");
			String singer = sc.next();
			
			System.out.print("가격:");
			int price = sc.nextInt();
			
			Music input = new Music(title, singer, price); // Music객체에 입력한 값을 넣음!
			list.add(input); // ArrayList 에 만든 객체를 넣음!
			
			System.out.print("계속?");
			retry = sc.next();
			if(retry.equals("n"))
				break;
		}

		
		// Iterator 사용법
		Iterator<Music> iter = list.iterator();
		while (iter.hasNext()) {
			Music m = iter.next(); // 다음 iter를 m에 넣기. -> 현재 iter는 Music 객체를 리턴하므로 받을 변수는 Music!
			System.out.println(m);
		}
		System.out.println("----");
		
		// 그냥 for문 사용법
		for(i=0; i<list.size(); i++) {
			System.out.println(list.get(i)); // -> 불러올때 get!!!! 까먹지 말쟈 ㅠ
			//또는
			System.out.print(list.get(i).getTitle() + ","); //-> 하나씩 출력.
			System.out.print(list.get(i).getSinger() + ","); //-> 하나씩 출력.
			System.out.println(list.get(i).getPrice()); //-> 하나씩 출력.
		}
		System.out.println("----");
		
		// 확장for문 사용법
		for(Music x : list) {
			System.out.println(x);
		}
		
		sc.close();
	} // main

}
