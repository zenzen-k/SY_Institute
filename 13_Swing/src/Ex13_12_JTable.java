import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class JTable_Sub extends JFrame {

	JTable table = null;
	JScrollPane scrollPane = null;
	Container contentPane = null;
	int cnt = 1;

	Vector<String> columnNames = null; // 타이틀
	Vector<Vector<String>> rowData = null; // 내용.
	// <Vector<String>> : 문자열이 여러개 들어가는 벡터를 만들라는 의미다. -> "중첩벡터"라고 한다.

	public JTable_Sub(String title) {
		super(title);
		// 객체 생성!
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();

		getFile();
		compose();

		setDefaultCloseOperation(EXIT_ON_CLOSE); // 완전 프로그램 종료

		setSize(500, 200);
		setVisible(true);
	} // 생성자

	private void compose() { // 화면설정
		contentPane = getContentPane(); // 작업영역 관리
		table = new JTable(rowData, columnNames); // 테이블 생성
		scrollPane = new JScrollPane(table); // 테이블에 스크롤바를 생성함

		contentPane.add(scrollPane, BorderLayout.CENTER); // 스크롤 패널을 작업영역에 올림

		// 버튼 추가
		JButton btn = new JButton("출력");
		btn.addActionListener(new TablePrint(table));
		contentPane.add(btn, BorderLayout.SOUTH);
	} // compose

	private void getFile() { // 파일 읽어오기
		File f = new File("c:\\sun\\table.txt");
		FileReader fr = null;
		BufferedReader br = null; // 한글 읽어오기
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			// 파일로부터 한줄씩 읽어오기
			String str;
			while ((str = br.readLine()) != null) {
				jTableMake(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // getFile

	private void jTableMake(String str) { // 벡터에 저장
		// 길이가 고정되지 않으므로 컬렉션을 사용해야한다. (JTable의 생성자 중 벡터 사용)
		// JTable(Vector<? extends Vector> rowData, Vector<?> columnNames)
		// 중첩벡터, 1차원벡터
		String[] item = str.split("/");

		if (cnt++ == 1) { // 비교가 끝나면 증가함
			for (int i = 0; i < item.length; i++) {
				columnNames.add(item[i]);
			}
		} else {
			Vector<String> one = new Vector<String>();
			for (int i = 0; i < item.length; i++) {
				one.add(item[i]);
			}
			rowData.add(one);
		}
	} // jTableMake

} // JTable_Sub

class TablePrint implements ActionListener {
	JTable table;

	public TablePrint(JTable table) {
		this.table = table; // 멤버변수 테이블에 매개변수로 받은 테이블을 넣음
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 테이블 내용을 콘솔창에 출력
		int rowCount = table.getRowCount(); // 몇행?
		int columnCount = table.getColumnCount();
		System.out.println(rowCount + "," + columnCount); // 제목없이 내용만 포함. 5행 4열

//		Object obj = table.getValueAt(0, 0);
//		System.out.println(obj);
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				System.out.print(table.getValueAt(i, j) + "\t");
			}
			System.out.println();
		}

	}

} // TablePrint

public class Ex13_12_JTable {
	public static void main(String[] args) {
		new JTable_Sub("JTable 예제");
	}
}
