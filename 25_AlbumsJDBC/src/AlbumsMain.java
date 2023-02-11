import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlbumsMain {
	
	AlbumsDao dao = new AlbumsDao();
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public AlbumsMain() {
		init();
	}
	
	public void init() {
		
		while(true) {
			System.out.println("======메뉴 선택하기======");
			System.out.println("1.모든 정보 조회");
			System.out.println("2.조건 검색");
			System.out.println("3.가격 범위 조건 검색(가격:내림차순, 가수:오름차순)");
			System.out.println("4.앨범 수정");
			System.out.println("5.앨범 삭제");
			System.out.println("6.앨범 추가");
			System.out.println("7.정렬");
			System.out.println("8.그룹화");
			System.out.println("9.프로그램 종료");
			System.out.print("메뉴 선택 >> ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1 :
					ArrayList<AlbumsBean> list = dao.getAllAlbums();
					showAlbums(list);
					break;
			case 2 :
					getAlbumsSearch();
					break;
			case 3 :
					getAlbumByRange();
					break;
			case 4 :
					updateAlbums();
					break;
			case 5 :
					deleteAlbums();
					break;
			case 6 :
				try {
					insertAlbums();
				} catch (IOException e) {
					e.printStackTrace();
				}
					break;
			case 7 :
					align();
					break;
			case 8 :
					groupbyAlbums();
					break;
			case 9 :
					System.exit(0);
					break;
			default : System.out.println("1~8 사이의 숫자를 입력하세요");
					break;
			}//switch
			
		}//while
		
	}//init
	
	// 8. 그룹화
	private void groupbyAlbums() {
		String company = null;
		System.out.print("그룹화 할 회사명 입력 : ");
		try {
			company = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AlbumsBean ab = dao.groupbyAlbums(company);

		if (ab != null)
			System.out.println(ab.getCompany() + " " + ab.getPrice());
		else
			System.out.println("입력한 회사가 존재하지 않습니다.");
	} // groupbyAlbums()

	// 7. 정렬
	private void align() {
		int num = 0;
		String column = null, order = null;
		
		System.out.println("정렬 할 항목 선택하세요.");
		System.out.print("번호:1  노래제목:2  가수명:3  \n번호입력>> ");
		num = sc.nextInt();
		switch(num) {
		case 1: column = "num"; break;
		case 2: column = "song"; break;
		case 3: column = "singer"; break;
		default : System.out.println("1~3 사이의 번호를 입력하세요"); 
					return;
		} // switch
		
		System.out.println("정렬 방법을 선택하세요");
		System.out.print("오름차순:1  내림차순:2   \n번호입력>> ");
		num = sc.nextInt();
		switch(num) {
		case 1: order = "asc"; break;
		case 2: order = "desc"; break;
		default : System.out.println("1~2 사이의 번호를 입력하세요");
					align(); return;
		}
		ArrayList<AlbumsBean> lists = dao.align(column, order);
		showAlbums(lists);
	} // orderbyAlbums()

	// 3. 가격 범위 조건 검색
	private void getAlbumByRange() {
		int start = 0, end = 0;
		try{
			do {
				try {
					System.out.print("시작등수 입력 : ");
					start = Integer.parseInt(br.readLine());
					System.out.print("끝등수 입력 : ");
					end = Integer.parseInt(br.readLine());
					break;
				} catch(NumberFormatException e) {
					System.out.println("숫자를 입력하세요");
				}
			} while(true); // while
		} catch(IOException e) {
			e.printStackTrace();
		}
		ArrayList<AlbumsBean> lists = dao.getAlbumByRange(start, end);
		showAlbums(lists);
	} // priceRankAlbums()

	// 5. 삭제
	private void deleteAlbums() {
		System.out.print("삭제할 번호 입력 : ");
		int num = sc.nextInt();
		
		result(dao.deleteAlbums(num));
	} // deleteAlbums()
	
	// 4. 수정
	private void updateAlbums() {
		int num =0, price = 0;
		String song = null , singer = null, company = null, pub_day = null;

		System.out.println("수정할 번호 입력 : ");
		num = sc.nextInt();
		 // 섞어서 해도 ㄱㅊ br, sc
		System.out.print("노래제목 입력 : ");
		try {
			song = br.readLine();
			System.out.print("가수명 입력 : ");
			singer = br.readLine();
			System.out.print("회사 입력 : ");
			company = br.readLine();
			do {
				try {
					System.out.print("가격 입력 : ");
					price = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("숫자로 입력하세요 : ");
					continue;
				}
			} while(true) ; // while
			System.out.print("입고 일자 입력(yyyy/mm/dd 형식으로) : ");
			pub_day = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AlbumsBean ab = new AlbumsBean(num, song, singer, company, price, pub_day);
		result(dao.updateAlbums(ab));
	} // updateAlbums()

	// 6. 앨범 추가
	private void insertAlbums() throws IOException {
		String song = null, singer = null, company = null, pub_day  = null;
		int price = 0;
		
		System.out.println("번호는 시퀀스로 입력됩니다(생략)");
		// 모두 공백 받을 수 있도록 br로 해도 ㄱㅊ

		System.out.print("노래제목 입력 : ");
		song = br.readLine();
		System.out.print("가수명 입력 : ");
		singer = br.readLine();
		System.out.print("회사 입력 : ");
		company = br.readLine();

		do {
			try {
				System.out.print("가격 입력 : ");
				price = Integer.parseInt(br.readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력하세요 : ");
				continue;
			}
		} while(true) ; // while

		System.out.print("입고 일자 입력(yyyy/mm/dd 형식으로) : ");
		pub_day = sc.next();
		
		AlbumsBean ab = new AlbumsBean(0, song, singer, company, price, pub_day);
		result(dao.insertAlbums(ab));
	} // insertAlbums()

	// 2.조건조회
	private void getAlbumsSearch() {
		System.out.println("제목검색:1     가수검색:2     회사검색:3");
		System.out.print("검색할 항목을 선택 : ");
		int num = sc.nextInt();
		String column = null;
		String search = null;
		
		switch(num) {
		case 1:
				System.out.print("검색할 제목 입력 :");
				column = "song";
				break;
		case 2:
				System.out.print("검색할 가수 입력 :");
				column = "singer";
				break;
		case 3:
				System.out.print("검색할 회사 입력 :");
				column = "company";
				break;
		default: System.out.println("1~3사이의 번호만 입력하세요");
//				return; -> 다시 init으로 돌아감.
				// 또는 재귀호출을 사용하여 다시 검색할 항목을 입력하도록 사용할 수도 있당.
				// init -> gAS -> 4입력하면 default 에서 걸림 -> gAS 호출 -> 2번나옴 -> 
				// 돌아오면서 아래의 search 변수를 만나게 된다. 다시 init으로 돌아가게 return; 을 작성
				// 자신을 부른 곳으로 돌아간다.
				getAlbumsSearch();
				return;
		}//switch
		try {
			search = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<AlbumsBean> lists = dao.getAlbumsSearch(column, search);
		showAlbums(lists);
		
	}//getAlbumsSearch()

	// 출력
	private void showAlbums(ArrayList<AlbumsBean> list) {
		System.out.println("번호\t노래제목\t가수\t회사\t가격\t발매일");
		for(AlbumsBean ab : list) {
			System.out.println(ab.getNum() + "\t" +
								ab.getSong() + "\t" +
								ab.getSinger() + "\t" +
								ab.getCompany() + "\t" +
								ab.getPrice() + "\t" +
								ab.getPub_day());
		}
	} // showAlbums()
	
	// 결과출력
	private void result(int cnt) {
		System.out.print("cnt : " + cnt);
		if(cnt == 0)
			System.out.println(" / 조건오류");
		else if (cnt >0)
			System.out.println(" / 성공");
		else
			System.out.println(" / 실패");
	} // result()
	
	public static void main(String[] args) {
		new AlbumsMain();
	}
}
