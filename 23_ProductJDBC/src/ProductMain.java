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
					showProducts(lists);
					break;
			case 2:
					getProductById();
					break;
			case 3:
					getProductByCategory();
					break;
			case 4:
					insertProduct();
					break;
			case 5:
					updateProduct();
					break;
			case 6:
					deleteProduct();
					break;
			case 7:
					System.exit(0);
					break;
			default : System.out.println("1~7만 입력 가능");
			} // switch
		} //while
	} // init() 메서드
	
	
	/* 6. 상품 삭제 */
	private void deleteProduct() {
		System.out.print("삭제할 id를 입력하세요 : ");
		int id = sc.nextInt();
		
		int cnt = dao.deleteProduct(id);
		if(cnt>0)
			System.out.println("삭제 성공");
		else if(cnt==0)
			System.out.println("조건 오류");
		else
			System.out.println("삭제 실패");
	}
	
	
	/* 5. 상품 수정 */
	private void updateProduct() {
		System.out.print("수정될 id를 입력하세요 : ");
		int id = sc.nextInt();
		
		System.out.print("상품명 입력:");
		String name = sc.next();
		
		System.out.print("재고수량 입력 : ");
		int stock = sc.nextInt();
		
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		
		System.out.print("분류 입력 : ");
		String category = sc.next();

		System.out.print("입고일 입력 : ");
		String inputdate = sc.next();
		
		ProductBean pb = new ProductBean();
		pb.setId(id);
		pb.setName(name);
		pb.setStock(stock);
		pb.setPrice(price);
		pb.setCategory(category);
		pb.setInputdate(inputdate);
		
		int cnt = dao.updateProduct(pb);
		System.out.println("cnt : " + cnt);
		if(cnt>0)
			System.out.println("수정 성공");
		else if(cnt==0)
			System.out.println("조건 오류");
		else
			System.out.println("수정 실패");
		
	} // updateProduct() 메서드
	
	
	/* 4. 상품 추가 */
	private void insertProduct() {
		System.out.println("id는 자동 추가 됩니다.");
		System.out.print("상품명 입력:");
		String name = sc.next();
		
		System.out.print("재고수량 입력 : ");
		int stock = sc.nextInt();
		
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		
		System.out.print("분류 입력 : ");
		String category = sc.next();

		System.out.print("입고일 입력 : ");
		String inputdate = sc.next();
		
		ProductBean pb = new ProductBean();
		pb.setName(name);
		pb.setStock(stock);
		pb.setPrice(price);
		pb.setCategory(category);
		pb.setInputdate(inputdate);
		
		int cnt = dao.insertProduct(pb);
		
		System.out.println("cnt : " + cnt);
		if(cnt>0)
			System.out.println("삽입 성공");
		else
			System.out.println("삽입 실패");
		
	} // insertProduct() 메서드
	
	
	/* 3. 특정 상품 조회(카테고리) */
	private void getProductByCategory() {
		System.out.print("카테고리를 입력하세요 : ");
		String category = sc.next();
		
		ArrayList<ProductBean> lists = dao.getProductByCategory(category);
		
		showProducts(lists);
	} // getProductByCategory 메서드
	
	
	/* 2. 특정 상품 조회(아이디) */
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

	
	/* 출력메서드 */
	public void showProducts(ArrayList<ProductBean> lists){
		for(ProductBean pb : lists) {
			System.out.println(pb.getId() + "/" +
							pb.getName() + "/" +
							pb.getStock() + "/" +
							pb.getPrice() + "/" +
							pb.getCategory() + "/" +
							pb.getInputdate());
		}
	} // showProducts() 메서드
	
	
	public static void main(String[] args) {
		new ProductMain();// -> static으로 해서 객체 안만들어도 ㄱㅊ
	} // main() 메서드
} // ProductMain 클래스
