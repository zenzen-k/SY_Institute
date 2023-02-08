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
										+ pb.getBirth());
					} // for
					
					break;
			case 2: System.out.println("2.성별로 조회");
					/* 조건을 콘솔에 입력하여 조회 할 거임 따라서 getPersonByGender() 메소드 정의 후 호출*/
					// dao 클래스가 아닌 현재 클래스의 getPersonByGender 메서드 이다.
					getPersonByGender();
					break;
			case 3: System.out.println("3.정보 수정");
					updatePerson();
					break;
			case 4: System.out.println("4.정보 삭제");
					deletePerson();
					break;
			case 5: System.out.println("5.정보 추가");
					// 현재 클래스의 insertPerson 호출한거! Dao클래스랑 헷갈리믄 안댕
					insertPerson();
					break;
			case 6: System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
			default : System.out.println("1~6 사이의 번호만 입력 가능함");
			}//switch
		}//while
	} // init 메서드
	
	/*데이터 삭제 delete*/
	private void deletePerson() {
		System.out.print("삭제 할 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		int result = dao.deletePerson(num);
		
		System.out.println("result:" + result);
		if(result > 0)
			System.out.println("delete 성공");
		else if(result == 0)
			System.out.println("조건에 맞는 레코드 없음");
		else
			System.out.println("delete 실패");
	} // deletePerson

	/* 데이터 수정 update */
	public void updatePerson() {
		// 조건으로 사용 할
		System.out.print("번호 입력 : ");
		int num = sc.nextInt();
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("성별 입력 : ");
		String gender = sc.next();
		
		System.out.print("생일 입력 : ");
		String birth = sc.next();
		
		PersonBean pb = new PersonBean();
		pb.setName(name);
		pb.setAge(age);
		pb.setGender(gender);
		pb.setBirth(birth);
		pb.setNum(num);
		
		int result = dao.updatePerson(pb);
		System.out.println("result : " + result);
		
		// 성공실행결과 출력
		if(result > 0)
			System.out.println("update 성공");
		else if(result == 0)
			System.out.println("조건에 맞는 레코드 없음");
		else
			System.out.println("update 실패");
	} // updatePerson

	/* 데이터 입력(추가) insert */
	private void insertPerson() {
		System.out.println("번호는 시퀀스로 자동 입력됩니다.");
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("성별 입력 : ");
		String gender = sc.next();
		
		System.out.print("생일 입력 : ");
		String birth = sc.next();
		
		//dao.insertPerson(name,age,gender,birth);
		PersonBean pb = new PersonBean();
		pb.setName(name);
		pb.setAge(age);
		pb.setGender(gender);
		pb.setBirth(birth);
		// num은 아무값도 없으므로 int의 기본값인 0이 들어가 있당.
		
		// 하나의 객체로 묶어서 값을 보낸 뒤 실행결과를 받는다.
		int result = dao.insertPerson(pb);
		System.out.println("result : " + result);
		
		// 성공실행결과 출력
		if(result > 0)
			System.out.println("insert 성공");
		else
			System.out.println("insert 실패");
		//실패한다면 실행자체를 못하여 아무런 값도 넣을수조차 없다. 따라서 초기화 한 -1 이 출력된다
		
	}//insertPerson 메서드

	/* 성별조회 */
	public void getPersonByGender() {
		System.out.print("찾는 성별 입력 : ");
		String gender = sc.next(); // 입력받음
		// 받는 변수명은 중요하지않당! 하지만 의미있게 작성하기~
		ArrayList<PersonBean> lists = dao.getPersonByGender(gender);
		
		for(PersonBean x : lists) {
			System.out.println(x.getNum()+"/"+x.getName()+"/"+x.getAge()+"/"+x.getGender()+"/"+x.getBirth());
		}
	} // getPersonByGender 메서드

	public static void main(String[] args) {
		new PersonMain();
	} // main 메서드
}
