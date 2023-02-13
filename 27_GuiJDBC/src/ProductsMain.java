import java.awt.Button;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ProductsMain extends JFrame{
	
	private String[] columnNames = {"아이디", "이름", "입고수량", "단가", "카테고리", "입고일"}; // 테이블의 제목으로 사용
	private Object[][] rowData; // 테이블에서 가져온 내용으로 만들 2차원 배열. 문자열도 있고 정수도 있으므로 Object 타입
	private JTable table = null;
	private JScrollPane scrollPane = null; //테이블은 스크롤바를 가지는 패널로 올린다.
	
	private JButton[] btn = new JButton[4]; // 버튼을 관리하는 버튼관리자 4개 만든상태!
	// Button b1,b2,b3,b4; 이거랑 같음!
	
	// 텍스트를 입력할 공간관리.
	private JTextField txtId = new JTextField();
	private JTextField txtName = new JTextField();
	private JTextField txtStock = new JTextField();
	private JTextField txtPrice = new JTextField();
	private JTextField txtCategory = new JTextField();
	private JTextField txtInputdate = new JTextField();
	
	// dao, lists 정의. 
	ProductsDao dao = null;
	ArrayList<ProductsBean> lists = null;
	
	/* 클래스의 생성자. 가장 먼저 실행되어야 하는 것들. */
	public ProductsMain(String title) {
		super(title); // 부모의 생성자로 title을 넘긴다
		
		// 테이블의 값을 가져온다.
		dao = new ProductsDao();
		lists = dao.getAllProduct();
		
		//가져온 데이터를 2차원 배열에 저장하기 위해서 rowData를 정의함. 아직 틀만 잡은 상태.
		rowData = new Object[lists.size()][columnNames.length];
		
		//데이터 넣기. 해야할 내용이 많아서 메서드로
		fillData();
		
		table = new JTable(rowData, columnNames); // (내용, 컬럼명). rowData의 값을 table에 올린다.
		scrollPane = new JScrollPane(table); // 스크롤페인에 테이블을 올린다.
		
		//작업 영역에 올리기
		compose();
		
		/* 보여지는 창 설정. 보이는건 마지막에 위치하는것이 좋다. */
		//super.setSize(500, 530); super 생략 가능
		setSize(500, 530);
		setLocation(350, 10); // 프레임창 띄웠을때의 위치. 꼭지점 기준
		setVisible(true);
//		setResizable(false); // 창 크기 변경 고정.
		
	} // ProductsMain 생성자
	
	/* 화면구상메서드 */
	private void compose() {
		// 1. 작업영역 가져오기
		Container contentPane = getContentPane();
		contentPane.add(scrollPane);
	}

	/* rowData 2차원 배열에 데이터를 넣는 메서드 */
	private void fillData() {
		// ArrayList -> 2차원 배열로 변경하는 작업
		Object[] arr = lists.toArray(); // toArray() : list를 배열로 변경해줌
		int j = 0;
		for(int i =0; i<arr.length; i++) {
			ProductsBean pb = (ProductsBean)arr[i]; // Object로 받았으니 다운캐스팅해주어야 한다.
			rowData[i][j++] = pb.getId(); // i:0 j:0
			rowData[i][j++] = pb.getName(); // i:0 j:1
			rowData[i][j++] = pb.getStock(); // i:0 j:2 ...
			rowData[i][j++] = pb.getPrice();
			rowData[i][j++] = pb.getCategory();
			rowData[i][j++] = pb.getInputdate();
			j = 0; // 다시 1행의 0열부터 시작해야 하므로 j는 0으로 해준다.
		}
	} // fillData()

	public static void main(String[] args) {
		new ProductsMain("상품 관리 프로그램"); // JFrame을 상속받은 클래스로 객체를 생성하면 프레임 생긴다.
	} // main
}
