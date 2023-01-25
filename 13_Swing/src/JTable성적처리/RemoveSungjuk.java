package JTable성적처리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RemoveSungjuk implements ActionListener{
	JTable table;
	
	public RemoveSungjuk(JTable table) {
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("삭제버튼 클릭함");
		
		int row = table.getSelectedRow(); // getSelectedRow : 선택한 행번호
		System.out.println("선택한 행:" + row);
		
		if(row == -1)
			return; // 행을 찍지 않고 클릭한다면 아래의 코드를 실행하지 않고 다시 돌아간다.
		
		// 그냥 JTable인 table을 사용하면 removeRow() 메서드를 사용할 수 없다.
		// 따라서 addRow()와 removeRow()메서드를 사용하기 위해서 getModel로 테이블 모델을 가져온 후 DefaultTableModel 객체로 생성해준다.
		// DefaultTableModel 은 TableModel의 자식이므로 다운캐스팅 해주어야 한다.
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(row);
		
	}
}
