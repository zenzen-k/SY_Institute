import java.util.ArrayList;
import java.util.Scanner;

class Card_2 {
	private String name;
	private String tel; // 전화번호

	public Card_2(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

} // Card


public class Ex10_05_문제풀이 {
	public static void main(String[] args) {
		
		// <Card_2>를 생략해줘도 되지만, 생략한다면 객체를 꺼낼 때 아래와 같이 형변환 작업이 필요하다.
		// Card_2 del = (Card_2)list.get(i);
		ArrayList<Card_2> list = new ArrayList<Card_2>();
		Scanner sc  = new Scanner(System.in);
		int selectNo, i;
		String name, tel;
		boolean flag = false;

		while(true) {
			// false로 초기화 해주지 않으면 2번, 삭제에서 true값이 계속 true값으로 변경되어 이름 잘못입력이 뜨지 않는다.
			flag = false;
			System.out.print("1.명함추가 2.명함삭제 3.명함수정 4.명함보기 5.종료:");
			selectNo =  sc.nextInt();
			if(selectNo == 1) {
				System.out.print("이름을 입력하세요 :");
				name = sc.next();
				System.out.print("전화번호를 입력하세요 :");
				tel = sc.next();
				Card_2 input = new Card_2(name, tel);
				list.add(input);
			}
			else if(selectNo == 2) {
				System.out.print("삭제할 이름을 입력하세요:");
				name = sc.next();
				for(i = 0; i<list.size(); i++) {
					Card_2 del = list.get(i);
					if(del.getName().equals(name)) {
						flag = true;
						list.remove(i);
						System.out.println("삭제되었습니다.");
					}
				} // for
				if(flag == false) {
					System.out.println("이름을 잘못입력하셨습니다.");
				}
			} 
			else if(selectNo == 3) {
				System.out.print("찾는 이름을 입력하세요 :");
				name = sc.next();

				for(i = 0; i<list.size(); i++) {
					Card_2 update = list.get(i);
					if(update.getName().equals(name)) {
						System.out.print("수정할 전화번호를 입력하세요 :");
						tel = sc.next();
						update.setTel(tel);
						System.out.println("수정되었습니다.");
						flag = true;
					} // if
				} //for
				if(flag == false) {
					System.out.println("이름을 잘못입력하셨습니다.");
				}
			}
			else if(selectNo == 4) {
				System.out.println("이름\t전화번호");
				//for(i = 0; i<list.size(); i++) {
					//Card_2 c = list.get(i);
				for(Card_2 c : list) {
					System.out.println(c.getName()+"\t"+c.getTel());		
				}
			}
			else if(selectNo == 5) {
				break;
			}
			else {
				System.out.println("1~5 번호만 입력 가능함");
			}


		} // while

		sc.close();
	}
}
