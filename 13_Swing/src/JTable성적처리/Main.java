package JTable성적처리;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{

	JTable table = null;
	JScrollPane scrollPane = null;
	Container contentPane = null;
	int cnt = 1;

	Vector<String> columnNames = null; // 타이틀
	Vector<Vector<String>> rowData = null; // 내용.

	String[] caption = { "이름:", "국어:", "영어:", "수학:" };

	JButton btnAdd, btnRemove, btnFout, btnExit;

	// 텍스트 필드 관리자 배열 - 객체배열
	JTextField[] tf = new JTextField[4];

	public Main(String title) {
		super(title);

		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();

		getFile();
		compose();

		/* 프레임 기본 설정 */
		setSize(700, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료
	} // 생성자

	/* 테이블 기본 화면 구성 설정 */
	private void compose() {
		contentPane = getContentPane(); // 작업영역 관리
		contentPane.setLayout(null); // 기본배치관리자도 사용하지 않겠다는 뜻
		table = new JTable(rowData, columnNames);
		scrollPane = new JScrollPane(table);

		contentPane.add(scrollPane);

		// 원하는 레이아웃 크기 직접 설정.
		// 가로 250, 세로 30인 위치로부터 시작해서 가로 400 세로 200만큼의 크기로 설정하겠다는 의미.
		scrollPane.setBounds(250, 30, 400, 200);

		/* 왼쪽부분 설정 - 라벨, 텍스트 입력창 */
		for (int i = 0; i < 4; i++) {
			JLabel lb = new JLabel(caption[i]); // 배열 caption에 있는 내용을 라벨로 설정함.
			lb.setBounds(10, (i + 1) * 30, 50, 20);
			contentPane.add(lb);

			// 입력받음
			tf[i] = new JTextField();
			tf[i].setBounds(70, (i + 1) * 30, 100, 20);
			contentPane.add(tf[i]);
		} // for
		
		/* 버튼설정 */
		btnAdd = new JButton("추가");
		btnAdd.setBounds(10, 160, 100, 20);
		contentPane.add(btnAdd);
		// 클래스 객체를 만들어줌!-> 액션퍼폼드메서드가 있는 위치를 작성
		btnAdd.addActionListener(new AddSungjuk(table, tf)); 
		// 테이블 정보와, 입력한 텍스트 필드 정보를 넘겨주어야 한다. (테이블에 추가하기 위해서)
		
		btnRemove = new JButton("삭제");
		btnRemove.setBounds(120, 160, 100, 20);
		contentPane.add(btnRemove);
		btnRemove.addActionListener(new RemoveSungjuk(table));
		// 테이블 정보만 넘김
		
		btnFout = new JButton("파일출력");
		btnFout.setBounds(10, 190, 100, 20);
		contentPane.add(btnFout);
		btnFout.addActionListener(new FilePrint(table));
		
		btnExit = new JButton("종료");
		btnExit.setBounds(120, 190, 100, 20);
		contentPane.add(btnExit);
		btnExit.addActionListener(this);

	} // compose()
	
	/* 종료 메서드 */
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	} // actionPerformed()
	
	
	/* 데이터 읽어오는 메서드 */
	private void getFile() {
		// 데이터를 읽어오기 위한 스트림 형성
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("c:\\sun\\table.txt");
			br = new BufferedReader(fr);

			String str;
			while ((str = br.readLine()) != null) {
				jTableMake(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) // null이 아니면 연결다리를 형성했다는 뜻!
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	} // getFile()

	/* 테이블 내용 구성. 읽어들인 한줄을 구분자 기준으로 나누어서 벡터 컬렉션에 저장. */
	private void jTableMake(String str) {
		String[] item = str.split("/");

		if (cnt++ == 1) {
			for (int i = 0; i < item.length; i++) {
				columnNames.add(item[i]);
			}
		} else {
			Vector<String> one = new Vector<String>();
			for (int i = 0; i < item.length; i++) {
				one.add(item[i]);
			}
			rowData.add(one); // 반복이 끝나면 내용에 one벡터를 넣는다.
		}

	} // jTableMake()

	/* main메소드 */
	public static void main(String[] args) {
		new Main("성적처리 프로그램");
	} // main()
}
