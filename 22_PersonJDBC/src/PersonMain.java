import java.util.ArrayList;
import java.util.Scanner;

/* 콘솔창에서 할 일 */
public class PersonMain {

	Scanner sc = new Scanner(System.in);
	PersonDao dao = new PersonDao(); // PersonDao 객체 생성

	public PersonMain() {
		System.out.println("PersonMain 생성자");
		init();
	}

	// 메서드는 퍼블릭으로 많이 함
	public void init(){
		System.out.println("init");
		int menu;

		while(true) {
			System.out.println("=== 메뉴 선택하기 ===");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.성별로 조회");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");

			System.out.print(">> 메뉴 번호 입력 : ");
			menu = sc.nextInt();

			switch (menu) {
			case 1: System.out.println("1.전체 정보 조회");
					ArrayList<PersonBean> lists = dao.getAllPerson();
					
					System.out.println("전체 레코드 수:" + lists.size());

					for(int i=0; i<lists.size(); i++) {
						PersonBean pb = lists.get(i);
						System.out.println(pb.getNum() + "/"
										+ pb.getName() + "/"
										+ pb.getAge() + "/"
										+ pb.getGender() + "/"
										+ pb.getBirth() + "/");
					} // for
					
					break;
			case 2: System.out.println("2.성별로 조회");
					break;
			case 3: System.out.println("3.정보 수정");
					break;
			case 4: System.out.println("4.정보 삭제");
					break;
			case 5: System.out.println("5.정보 추가");
					break;
			case 6: System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
			default : System.out.println("1~6 사이의 번호만 입력 가능함");
			}//switch
		}//while
	} // init 메서드

	public static void main(String[] args) {
		new PersonMain();


	}
}
