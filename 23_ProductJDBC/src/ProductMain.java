import java.util.ArrayList;
import java.util.Scanner;

public class ProductMain {
	// static 은 객체를 만들지 않아도 자동으로 변수가 생성된다!
	static ProductDao dao = new ProductDao();
	Scanner sc = new Scanner(System.in);
	
	public ProductMain() {
		init();
	} // ProductMain
	
	private void init() {
		while(true) {
			System.out.println("\n=== 메뉴 선택하기 ===");
			System.out.println("1. 모든 상품 조회");
			System.out.println("2. 특정 상품 조회(아이디)");
			System.out.println("3. 특정 상품 조회(카테고리)");
			System.out.println("4. 상품 추가");
			System.out.println("5. 상품 수정");
			System.out.println("6. 상품 삭제");
			System.out.println("7. 프로그램 종료");
			System.out.print("번호 입력 > ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
					ArrayList<ProductBean> lists = dao.getAllProduct();
					for(ProductBean pb : lists) {
						System.out.println(pb.getId() + "/" +
											pb.getName() + "/" +
											pb.getStock() + "/" +
											pb.getPrice() + "/" +
											pb.getCategory() + "/" +
											pb.getInputdate());
					} // for
					
					/* 일반for문 버전
					  for(int i=0; i<lists.size(); i++{
					  		ProductBean pb = lists.get(i)
					  System.out.println(pb.getId() + "/" +
											pb.getName() + "/" +
											pb.getStock()  + "/" +
											pb.getPrice()  + "/" +
											pb.getCategory()  + "/" +
											pb.getInputdate());
					  }
					 */
					
					break;
			case 2:
					getProductById();
					break;
			case 3:
					getProductByCategory();
					break;
			case 4:
					
					break;
			case 5:
					
					break;
			case 6:
					
					break;
			case 7:
					System.exit(0);
					break;
			default : System.out.println("1~7만 입력 가능");
			} // switch
		} //while
	} // init() 메서드

	
	private void getProductByCategory() {
		System.out.println("카테고리를 입력하세요 : ");
		String category = sc.next().toUpperCase();
		
		dao.getProductByCategory(category);
	}

	public void getProductById() {
		System.out.print("id를 입력하세요 : ");
		int id = sc.nextInt();
		
		ProductBean pb = dao.getProductById(id);
		if (pb == null) {
			System.out.println("없는 레코드 입니다.");
			return;
		}
		
		System.out.println(pb.getId() + "/" +
							pb.getName() + "/" +
							pb.getStock() + "/" +
							pb.getPrice() + "/" +
							pb.getCategory() + "/" +
							pb.getInputdate());
		
	} // getProductById() 메서드


	public static void main(String[] args) {
		new ProductMain();// -> static으로 해서 객체 안만들어도 ㄱㅊ
	} // main() 메서드
} // ProductMain 클래스
