import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ProductsMain extends JFrame implements ActionListener {

	private String[] columnNames = { "아이디", "이름", "입고수량", "단가", "카테고리", "입고일" }; // 테이블의 제목으로 사용
	private Object[][] rowData; // 테이블에서 가져온 내용으로 만들 2차원 배열. 문자열도 있고 정수도 있으므로 Object 타입
	private JTable table = null;
	private JScrollPane scrollPane = null; // 테이블은 스크롤바를 가지는 패널로 올린다.

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
	JPanel pCenter = null; // 패널관리

	/* 클래스의 생성자. 가장 먼저 실행되어야 하는 것들. */
	public ProductsMain(String title) {
		super(title); // 부모의 생성자로 title을 넘긴다

		// 초기화면설정
		// 테이블의 값을 가져온다.
		dao = new ProductsDao();
		lists = dao.getAllProduct();

		// 가져온 데이터를 2차원 배열에 저장하기 위해서 rowData를 정의함. 아직 틀만 잡은 상태.
		rowData = new Object[lists.size()][columnNames.length];

		// 데이터 넣기. 해야할 내용이 많아서 메서드로
		fillData();

		table = new JTable(rowData, columnNames); // (내용, 컬럼명). rowData의 값을 table에 올린다.
		scrollPane = new JScrollPane(table); // 스크롤페인에 테이블을 올린다.

		// 작업 영역에 올리기
		compose();

		// 이벤트 처리를 위한 이벤트 메서드
		setevent();

		/* 보여지는 창 설정. 보이는건 마지막에 위치하는것이 좋다. */
		// super.setSize(500, 530); super 생략 가능
		setSize(500, 530);
		setLocation(350, 10); // 프레임창 띄웠을때의 위치. 꼭지점 기준
		setVisible(true);
		setResizable(false); // 창 크기 변경 고정.

	} // ProductsMain 생성자

	/* 이벤트 처리 */
	private void setevent() {
		// 위에서 해도 되지만 이벤트처리는 이 메서드에 모아서 하기 위해서
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X 를 눌러도 완전 종료가 되지 않아서 이 코드 작성해주기.

		// 버튼에 액션이벤트리스너를 부착을 해주어야 이벤트 처리가 가능하다. compose에서 부착해줄것.

		// 숫자만 입력할 수 있게하려고 KeyListener를 부착 후 KeyHandler 호출한다.
		// 키보드 한번 누를때마다 keyEvent 객체가 만들어져서 KeyReleased로 객체를 가지고 넘어간다.
		txtStock.addKeyListener(new KeyHandler());
		txtPrice.addKeyListener(new KeyHandler());

		table.addMouseListener(new MouseHandler());
	}

	/* 화면구성메서드 */
	private void compose() {
		// 1. 작업영역 가져오기
		Container contentPane = getContentPane();
		// 2번을 올리니까 사라져서 위치설정을 해줌
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 0, 490, 200); // 스크롤바가 안보여서 크기 줄임
		contentPane.add(scrollPane); // 작업영역에 스크롤페인을 올린다.

		/*
		 * 기본 배치 관리자 Frame : BorderLayout Panel : FlowLayout
		 */

		// 2. 패널 - 라벨, 텍스트필드 올리기
		pCenter = new JPanel();
		pCenter.setLayout(null); // 기본 배치관리자를 사용하지 않겠다
		// 기본배치관리자를 사용했다면 라벨,텍필이 옆으로 쭈루루루루룱 나온당.
		pCenter.setBounds(0, 220, 500, 200); // 위치설정
		contentPane.add(pCenter); // 작업영역에 패널을 올린다.
		pCenter.setBackground(Color.cyan); // 컬러를 넣는다.

		// 배치하는게 어렵기 때문에, 기본배치를 빼고 setBounds로 해주는게 좋긴하당

		// 라벨을 만들었음
		JLabel lbId = new JLabel("아이디");
		JLabel lbName = new JLabel("이름");
		JLabel lbStock = new JLabel("입고수량");
		JLabel lbPrice = new JLabel("단가");
		JLabel lbCategory = new JLabel("카테고리");
		JLabel lbInputdate = new JLabel("입고일자(yyyy/mm/dd)");

		int vertical_position = 20;

		// y값 하나만 변하므로 곱하기를 줘서 위치변화를 줌.
		// 패널에 올렸기 때문에 패널 꼭지점 기준으로 20~ 1*vertical_position
		lbId.setBounds(20, 1 * vertical_position, 150, 20);
		lbName.setBounds(20, 2 * vertical_position, 150, 20);
		lbStock.setBounds(20, 3 * vertical_position, 150, 20);
		lbPrice.setBounds(20, 4 * vertical_position, 150, 20);
		lbCategory.setBounds(20, 5 * vertical_position, 150, 20);
		lbInputdate.setBounds(20, 6 * vertical_position, 150, 20);

		// 미리 만들어 둔 텍스트필드의 위치설정을 해주어야 한다.
		txtId.setBounds(150, 1 * vertical_position, 120, 20); // 입력하면 안됨. 시퀀스로 자동생성
		txtName.setBounds(150, 2 * vertical_position, 120, 20);
		txtStock.setBounds(150, 3 * vertical_position, 120, 20);
		txtPrice.setBounds(150, 4 * vertical_position, 120, 20);
		txtCategory.setBounds(150, 5 * vertical_position, 120, 20);
		txtInputdate.setBounds(150, 6 * vertical_position, 120, 20);

		txtId.setText("0"); // 기본값으로 0을 넣음
		txtId.setEnabled(false); // 입력할 수 없게 함

		// 패널에 라벨을 올림. 만들기만해서는 안보인다 꼭 올려줄것 !@@
		pCenter.add(lbId);
		pCenter.add(lbName);
		pCenter.add(lbStock);
		pCenter.add(lbPrice);
		pCenter.add(lbCategory);
		pCenter.add(lbInputdate);

		// 패널에 텍스트 필드를 올림
		pCenter.add(txtId);
		pCenter.add(txtName);
		pCenter.add(txtStock);
		pCenter.add(txtPrice);
		pCenter.add(txtCategory);
		pCenter.add(txtInputdate);

		// 버튼을 올릴 패널 생성
		JPanel pSouth = new JPanel();
		// 기본배치관리자 설정하기
		pSouth.setLayout(new GridLayout(1, 4)); // 1행의 4열처럼 꽉 차게 배열된다
		pSouth.setBounds(0, 420, 500, 40); // 위치설정
		contentPane.add(pSouth); // 작업영역에 패널을 올린다.
		// pSouth.setBackground(Color.pink); // 컬러를 넣는다. -> 버튼이 꽉채워서 배경안보임 굳이 안써도 ㄱㅊ

		// 어제는 버튼 관리자만 만들어두었음
		// 버튼의 제목으로 올라갈 내용
		String[] btnTitle = { "등록", "수정", "삭제", "종료" };
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(btnTitle[i]); // i번째 방의 이름을 가진 버튼을 생성. i번째 버튼~
			btn[i].addActionListener(this); // 현재 클래스에 actionPerformed가 있다. -> 클래스가 ActionListener를 상속받아야한다.
			pSouth.add(btn[i]); // 패널에 버튼을 올린다.
		}

	} // compose()

	/* rowData 2차원 배열에 데이터를 넣는 메서드 */
	private void fillData() {
		// ArrayList -> 2차원 배열로 변경하는 작업
		Object[] arr = lists.toArray(); // toArray() : list를 배열로 변경해줌
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			ProductsBean pb = (ProductsBean) arr[i]; // Object로 받았으니 다운캐스팅해주어야 한다.
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

	// 버튼이 눌릴때마다 여기로 옴. 액션이벤트 객체 e 를가지고 온당
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("버튼 눌림");
		Object obj = e.getSource(); // 어떤 버튼이 눌렸는지에 대한 정보가 여기로 온다.

		// 어떤 버튼인지 분기문을 통해 확인
		if (obj == btn[0]) { // 등록버튼이니?
			System.out.println("등록 버튼");
			insertData(); // 등록버튼처리를 위한 메서드 호출
		} else if (obj == btn[1]) { // 수정버튼이니?
			System.out.println("수정 버튼");
			updateData();
		} else if (obj == btn[2]) { // 삭제버튼이니?
			System.out.println("삭제 버튼");
			deleteData();
		} else if (obj == btn[3]) { // 종료버튼이니?
			System.out.println("종료 버튼");
			dao.exit();
			System.exit(0);
		} // if

	} // actionPerformed()

	// 삭제버튼
	private void deleteData() {
		// 선택안하고 누르면 삭제할 레코드 선택하라는 메세지 출력하기
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "삭제할 레코드를 선택하세요", "에러발생", JOptionPane.YES_NO_CANCEL_OPTION);
		} 
		else {
			int id =  Integer.parseInt(txtId.getText());
			// int id = Integer.parseInt(table.getValueAt(row, 0).toString()); 
			// 선택한 행의 0번째(id)에 있는 값을 가져와서(.toString()) 정수형으로 변환
			int cnt = dao.deleteData(id);

			if (cnt > 0) {
				System.out.println("delete 성공");
				clearTextField();
				getAllProducts();
			} else
				System.out.println("delete 실패");
		}
	} // deleteData()

	// 수정버튼
	private void updateData() {
		// 테이블을 선택하면 텍스트필드에 해당 값이 들어오고 (아이디는 수정불가) 값을 바꾼 뒤 수정버튼을 클릭하면 해당 레코드 변경되는 작업
		// 현재 선택한 테이블의 레코드가 텍스트필드에 들어가 있는상태!

		// 누락체크
		boolean result = checkData();

		// 숫자만 입력했는지 체크
		// setevent() 메서드에 정의되어 있는데, 생성자에서 setevent()를 호출하고 있으므로 추가 작성내용 없음

		if (result) {
			// 데이터베이스에 업데이트
			// 텍스트 필드의 데이터값을 가져온다.
			String id = txtId.getText();
			String name = txtName.getText();
			String stock = txtStock.getText();
			String price = txtPrice.getText();
			String category = txtCategory.getText();
			String inputdate = txtInputdate.getText();

			ProductsBean pb = new ProductsBean();
			pb.setId(Integer.parseInt(id));
			pb.setName(name);
			pb.setStock(Integer.parseInt(stock));
			pb.setPrice(Integer.parseInt(price));
			pb.setCategory(category);
			pb.setInputdate(inputdate);

			int cnt = dao.updateData(pb);
			if (cnt > 0) {
				System.out.println("update 성공");
				// 텍스트 필드 비우기
				clearTextField();

				// JTable에 수정된 내용 다시 가져오기
				getAllProducts();
			} else
				System.out.println("update 실패");

		} // if(result)
//		
//		// 다시 호출하지 않으면 마우스 이벤트가 끝나버리더라,,
//		// 테이블을 새로 만들기 때문에 이벤트 처리를 다시해주어야 한당.
//		setevent();
	} // updateData()

	// 등록버튼
	private void insertData() {

		// 입력값을 제대로 입력했는지 체크
		boolean result = checkData();
		System.out.println("result : " + result);

		// 입력한 것으로 insert를 해야하므로 텍스트 필드에 입력한 값을 가져와야 한다.
		String id = txtId.getText();
		String name = txtName.getText();
		String stock = txtStock.getText();
		String price = txtPrice.getText();
		String category = txtCategory.getText();
		String inputdate = txtInputdate.getText();

		// 테스트 출력
		System.out.println(id); // 위에서 0을 기본값으로 넣었기 때문에 0이 출력된다.
		System.out.println(name);
		System.out.println(stock);
		System.out.println(price);
		System.out.println(category);
		System.out.println(inputdate);

		// 입력값이 문제없을 때 해야한다. checkData()
		if (result) {
			ProductsBean pb = new ProductsBean(0, name, Integer.parseInt(stock), Integer.parseInt(price), category,
					inputdate);
			// 또는 setter 메서드를 통해서 pb에 넘기기. 생성자가 길어지면 가독성별로니까 setter사용해주는게 좋당... ㅠ
			// pb.setName(name);

			int cnt = dao.insertData(pb); // 생성자에서 dao 객체 만들었었으므로 이렇게 사용가능함!
			if (cnt > 0) {
				System.out.println("insert 성공");

				// 삽입성공하면 텍스트필드에 있는 데이터를 삭제하는게 좋당. 이를 위한 메서드 호출
				clearTextField();

				// 성공했다면 다시 불러와야 하므로, 생성자에서 헀던 불러오는 작업을 다시 해주어야 한다.
				// 하지만 생성자는 한번만 오는것이므로 별도의 메서드를 만들어준다.
				getAllProducts();
			} else
				System.out.println("insert 실패");
		} // if

	} // insertData()

	private boolean checkData() { // 입력값 유효성 검사 (누락 체크)
		if (txtName.getText().length() == 0) {
			// this : 현재 프레임의 텍스트 필드
			// 이름을 입력하세요 : 메세지
			// 에러발생 : 프레임 제목창
			// JOptionPane -> 메세지창의 옵션.
			JOptionPane.showMessageDialog(this, "이름을 입력하세요", "에러발생", JOptionPane.INFORMATION_MESSAGE);
			txtName.requestFocus();
			return false;
		}

		if (txtStock.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "입고수량을 입력하세요", "에러발생", JOptionPane.ERROR_MESSAGE);
			txtStock.requestFocus();
			return false;
		}

		if (txtPrice.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "단가를 입력하세요", "에러발생", JOptionPane.WARNING_MESSAGE);
			txtPrice.requestFocus();
			return false;
		}

		if (txtCategory.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "카테고리를 입력하세요", "에러발생", JOptionPane.YES_NO_CANCEL_OPTION);
			txtCategory.requestFocus();
			return false;
		}

		if (txtInputdate.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "입고일자를 입력하세요", "에러발생", JOptionPane.INFORMATION_MESSAGE);
			txtInputdate.requestFocus();
			return false;
		}
		// 어떤 경우에도 걸리지 않으면 오류가 없는거니까 true를 리턴함
		return true;
	}

	private void clearTextField() {
		txtName.setText("");
		txtStock.setText("");
		txtPrice.setText("");
		txtCategory.setText("");
		txtInputdate.setText("");
	}

	// 데이터 다시 불러오기 메서드 (새로고침). 삽입성공하면 하는 일이당
	public void getAllProducts() {
		// 테이블의 업데이트 된 값을 가져온다.
		lists = dao.getAllProduct();

		// 가져온 데이터를 2차원 배열에 저장하기 위해서 rowData를 정의함. 아직 틀만 잡은 상태.
		rowData = new Object[lists.size()][columnNames.length];

		fillData(); // 데이터 넣기
		table = new JTable(rowData, columnNames); // 데이터와 컬럼
		scrollPane.setViewportView(table); // 스크롤페인에 올라오는 table을 새로고침하는 것. 여기까지 해주어야 한당.
		// scrollPane도 여기서 사용됨으로 변수를 밖에 선언했었다.

		setevent();
	} // getAllProducts()

	// 필요한 메서드만 만들기 위한 내부클래스, 아답터 작성.
	// 입고수량과 단가에 문자가 입력되었는지 보려고
	class KeyHandler extends KeyAdapter {
		public void keyReleased(KeyEvent e) { // 키가 눌렸다가 띄어졌을 때마다 호출된다.
			System.out.println("keyReleased");
			Object obj = e.getSource(); // 객체를 가져옴
			if (obj == txtStock) {
				try {
					Integer.parseInt(txtStock.getText());
				} catch (NumberFormatException nfe) { // 숫자로 바꿀수 없다면 문자를 넣은거임
					JOptionPane.showMessageDialog(txtStock, "숫자로 입력하세요", "에러발생", JOptionPane.YES_NO_CANCEL_OPTION);
					txtStock.setText(""); // 잘못입력된거 다 지우기
					txtStock.requestFocus(); // 이벤트를 받을 컴포넌트 강제 설정. 커서의 위치
				}
				// System.out.println("입고수량");
			} else {
				try {
					Integer.parseInt(txtPrice.getText());
				} catch (NumberFormatException nfe) { // 숫자로 바꿀수 없다면 문자를 넣은거임
					JOptionPane.showMessageDialog(txtPrice, "숫자로 입력하세요", "에러발생", JOptionPane.YES_NO_CANCEL_OPTION);
					txtPrice.setText(""); // 잘못입력된거 다 지우기
					txtPrice.requestFocus();
				}
				// System.out.println("가격");
			} // if
		} // keyReleased
	} // KeyHandler

	class MouseHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouseClicked");

			int row = table.getSelectedRow();
			System.out.println("row : " + row);
//			 // 내가 선택한 행의 0번째 열을 가져온다.
//			String id = (String)table.getValueAt(row, 0);
//			txtId.setText(id);
//			txtId.setText(table.getValueAt(row, 0).toString());
//			txtId.setText(String.valueOf(table.getValueAt(row, 0)));
			txtId.setText(String.valueOf(table.getValueAt(row, 0)));
			txtName.setText(String.valueOf(table.getValueAt(row, 1)));
			txtStock.setText(String.valueOf(table.getValueAt(row, 2)));
			txtPrice.setText(String.valueOf(table.getValueAt(row, 3)));
			txtCategory.setText(String.valueOf(table.getValueAt(row, 4)));
			txtInputdate.setText(String.valueOf(table.getValueAt(row, 5)));
		}
	} // MouseHandler

} // ProductsMain 클래스
