import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {
	
	BookDao dao = new BookDao();
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 바이트 입력을 문자입력으로 받을 수 있도록 바꿈.

	public BookMain() {
		init();
	}
	
	private void init() {
		while(true) {
			System.out.println("\n=====메뉴 선택하기=====");
			System.out.println("1. 전체 정보 조회");
			System.out.println("2. 조건 조회");
			System.out.println("3. 정보 수정");
			System.out.println("4. 정보 삭제");
			System.out.println("5. 정보 추가");
			System.out.println("6. 프로그램 종료");
			System.out.print(">> 메뉴 번호 입력 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
					ArrayList<BookBean> lists = dao.getAllBook();
					showBook(lists);
					break;
			case 2:
					getBookBySearch();
					break;
			case 3:
					updateBook();
					break;
			case 4:
					deleteBook();
					break;
			case 5:
					insertBook();
					break;
			case 6:
					System.exit(0);
					break;
			default: 
					System.out.print("1~6 사이의 번호를 입력하세요.");
			} // switch
		} // while
	} // init
	
	/* 2. 조건 조회 */
	private void getBookBySearch() {
		String column = null;
		String searchWord = null;
		
		System.out.println("제목:1  저자:2  출판사:3  번호입력>>");
		int searchNum = sc.nextInt();
		
		switch(searchNum) {
		case 1: 
				System.out.println("조회할 제목 : ");
				column = "title";
				break;
		case 2: 
				System.out.println("조회할 저자 : ");
				column = "author";
				break;
		case 3: 
				System.out.println("조회할 출판사 : ");
				column = "publisher";
				break;
		default : System.out.println("1~3사이의 번호만 입력하세요.");
				return;
		
		}
		// 어쩃든 스위치문 나가니까 입력을 여기서 한번에 받아도 ㄱㅊ
		searchWord = sc.next();
		
		// searchWord 가 포함된~, column은 컬럼명!
		ArrayList<BookBean> lists = dao.getBookBySearch(column, searchWord);
		if (lists.size() == 0)
			System.out.println("찾는 정보가 없습니다.");
		else
			showBook(lists);
	} // getBookBySearch

	/* 삽입/삭제/수정 결과 출력 */
	private void result(int cnt) {
		System.out.println("cnt : " + cnt);
		if(cnt>0)
			System.out.println("성공");
		else if(cnt==0)
			System.out.println("조건 오류");
		else
			System.out.println("실패");
	}
	
	/* 삽입 */
	private void insertBook() {
		System.out.println("번호는 시퀀스로 입력됩니다(생략)");
		System.out.print("책제목 입력 : ");
//		String title = sc.next();
		String title = null;
		try {
			title = br.readLine();
			// 공백포함 문자열을 받기 위해서. readLine()
			// nextLine() 도 되지만 좀 수정해야한당
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("저자 입력 : ");
		String author = sc.next();
		
		System.out.print("출판사 입력 : ");
		String publisher = sc.next();
		
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		
		System.out.print("출간일(yyyy/mm/dd 형식) 입력 : ");
		String pub_day = sc.next();

		// Bean 에서 생성자를 만든다면 아래처럼 해도 된다.
		// 0을 쓴 이유 : no는 사용하지 않지만 일단 보내야 해서 정수의 기본값인 0을 넣음
		BookBean bb = new BookBean(0,title,author,publisher,price,pub_day);
//		bb.setTitle(title);
//		bb.setAuthor(author);
//		bb.setPublisher(publisher);
//		bb.setPrice(price);
//		bb.setPub_day(pub_day);
		
		int cnt = dao.insertBook(bb);
		
		result(cnt);
	} // insertBook
	
	
	/* 삭제 */
	private void deleteBook() {
		System.out.print("삭제할 번호 입력 : ");
		int no = sc.nextInt();
		
		int cnt = dao.deleteBook(no);
		
		result(cnt);
		
	} // deleteBook
	
	
	/* 수정 */
	private void updateBook() {
		System.out.print("수정할 번호 입력 : ");
		int no = sc.nextInt();
		
		System.out.print("책제목 입력 : ");
		String title = null;
		try {
			title = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("저자 입력 : ");
		String author = sc.next();
		
		System.out.print("출판사 입력 : ");
		String publisher = sc.next();
		
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		
		System.out.print("출간일(yyyy/mm/dd 형식) 입력 : ");
		String pub_day = sc.next();
		
		BookBean bb = new BookBean(no,title,author,publisher,price,pub_day);
//		bb.setNo(no);
//		bb.setTitle(title);
//		bb.setAuthor(author);
//		bb.setPublisher(publisher);
//		bb.setPrice(price);
//		bb.setPub_day(pub_day);
		
		int cnt = dao.updateBook(bb);
		
		result(cnt);
	} // updateBook
	
	
	/* 출력 */
	private void showBook(ArrayList<BookBean> lists) {
		System.out.println("번호\t책제목\t저자\t출판사\t가격\t출판일");
		for(BookBean bb : lists) {
			System.out.println(bb.getNo() +"\t"+
							bb.getTitle() +"\t"+
							bb.getAuthor() +"\t"+
							bb.getPublisher() +"\t"+
							bb.getPrice() +"\t"+
							bb.getPub_day());
		}//for
	} // showBook
	
	
	public static void main(String[] args) {
		new BookMain();
	} // main
}
