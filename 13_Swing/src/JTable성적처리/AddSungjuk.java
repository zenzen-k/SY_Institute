package JTable성적처리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddSungjuk implements ActionListener{
	JTable table;
	JTextField[] tf;
	String[] strArr = new String[4];
	public AddSungjuk(JTable table, JTextField[] tf) {
		this.table = table;
		this.tf = tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("추가버튼 클릭함");
		
		for(int i=0; i<strArr.length; i++) {
			strArr[i] = tf[i].getText(); // 문자열 배열에 넣음
		}
		
		// getModel() 를 이용하면 테이블 모델을 가져온다.
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		// DefaultTableModel 클래스 안에 addRow()메서드가 있다.
		model.addRow(strArr); // 배열에 있는 것을 Object[] 형태로 작성한다.
		
		for(int i=0; i<tf.length; i++) {
			tf[i].setText("");
//			tf[i].removeAll(); // 이건 안됨..ㅎ
		}
	}
}
