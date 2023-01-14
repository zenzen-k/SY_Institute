import java.util.ArrayList;
import java.util.Scanner;

class Card {
	private String name;
	private String tel; // 전화번호

	public Card(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String toString() {
		return name + "\t" + tel;
	}
	
}// Card

public class Ex10_05_김아연 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 아래 메뉴를 계속 반복한다.
		// 1 - 입력정보로 new Card 객체를 만든다. -> 이 객체들로 ArrayList를 만들기
		// 2 - 이름만 입력하고 삭제. /잘못입력한거에 대해서 출력
		// 3 - ArrayList에서 몇번째 위치? -> 이름 입력하면 해당 명함의 전화번호를 바꾼당. /잘못입력한거에 대해서 출력
		// 4 - 리스트 출력
		// 5 - 종료
		// 다른번호 입력하면 잘못입력 출력

		ArrayList<Card> list = new ArrayList<Card>();
		String name, tel;
		int i;
		

		do {
			System.out.print("1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:");
			int num = sc.nextInt();

			if (num == 1) {
				System.out.print("이름을 입력하세요 : ");
				name = sc.next();
				System.out.print("전화번호를 입력하세요 : ");
				tel = sc.next();
				Card cd = new Card(name, tel);
				list.add(cd);
			} // if 1
			
			else if (num == 2) {
				boolean flag = false;
				System.out.print("이름을 입력하세요 : ");
				name = sc.next();
				
				for(i=0; i<list.size(); i++) {
					if(list.get(i).getName().equals(name)) {
						list.remove(i);
						System.out.println("삭제되었습니다.");
						flag = true;
						break;
					}					
				}
				if(flag == false)
					System.out.println("이름을 잘못입력하셨습니다.");
			} // if 2
			
			else if (num == 3) {
				boolean flag = false;
				System.out.print("이름을 입력하세요 : ");
				name = sc.next();
				
				for(i=0; i<list.size(); i++) {
					if(list.get(i).getName().equals(name)) {
						System.out.print("수정하실 전화번호는 : ");
						tel = sc.next();
						Card cd = new Card(list.get(i).getName(), tel);
						list.set(i, cd);
						System.out.println("수정되었습니다.");
						flag = true;
						break;
					}					
				}
				if(flag == false)
					System.out.println("이름을 잘못입력하셨습니다.");
				
			} // if 3
			
			else if (num == 4) {
				System.out.println("이름\t전화번호");
				for(Card c : list) {
					System.out.println(c);
				}

			} // if 4
			else if (num == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} // if 5 
			else {
				System.out.println("잘못입력하셨습니다.");
			} // else
			System.out.println();
		} while (true);

	}
}
