package JTable성적처리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FilePrint implements ActionListener {
	JTable table;

	public FilePrint(JTable table) {
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/* 내가 한 방식 */
		// c:\\sun\\table_write.txt
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//		FileWriter fw = null;
//		BufferedWriter bw = null;
//		try {
//			fw = new FileWriter("c:\\sun\\table_write.txt");
//			bw = new BufferedWriter(fw);
//			
//			for (int i = 0; i < model.getRowCount(); i++) {
//				for (int j = 0; j < model.getColumnCount(); j++) {
//					Object obj = model.getValueAt(i, j);
//					bw.write((String)obj + " ");
//				}
//				bw.newLine(); // 줄바꿈
//			}
//
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		} finally {
//			try {
//				bw.close();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		}

		/* 강사님 방식 */
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("c:\\sun\\table_write.txt");
			bw = new BufferedWriter(fw);

			int rowCount = table.getRowCount();
			int colCount = table.getColumnCount();

			for (int col = 0; col < colCount; col++) {
				String colName = table.getColumnName(col); // 테이블의 제목을 가져옴
				if(col != colCount-1) {
					bw.write(colName + "/");
				} else {
					bw.write(colName);
					bw.newLine();
				}
			}

			for (int row = 0; row < rowCount; row++) {
				for (int col = 0; col < colCount; col++) {
					Object obj = table.getValueAt(row, col);
					if(col != colCount-1) {
						bw.write((String)obj + "/"); // write에는 Object를 넣을 수 없으므로 String 으로 다운캐스팅
					} else {
						bw.write((String)obj);
						bw.newLine();
					}
				} // 안쪽 for
			} // for

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(bw!=null)
					bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
}
