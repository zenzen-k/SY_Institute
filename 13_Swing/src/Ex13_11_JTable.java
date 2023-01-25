import java.awt.Container;
import javax.swing.*;

class ExJTable extends JFrame {
	
	// 파일입출력을 배웠기 때문에 읽어와서 써볼수있당.
	String[] title = {"사번","성명","부서"};
	String[][] data = {
						{"1","유재석","영업부"},
						{"2","정형돈","연구부"},
						{"3","이영자","총무부"}
						};	
	
	public ExJTable () {
		// JFrame을 사용할땐 작업영역 먼저!
		Container contentPane = getContentPane(); // getContentPane jframe이 가진 메서드이며 container리턴
		
		// 테이블 생성
		JTable table = new JTable(data,title); // (2차원배열, 1차원배열)
//		contentPane.add(table); // 테이블 같은 경우는 이렇게 올리면 제목이 안보인당.
		
		// ScrollPaneConstants 인터페이ㅡㅅ
		// 스크롤바를 항상보이게!!! v, h 
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED; //  : 필요할때
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; // : 항상
		// VERTICAL_SCROLLBAR_NEVER 절ㄷㅐ안나오게
		
		JScrollPane scroll = new JScrollPane(table,v,h); 
		contentPane.add(scroll);
		
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
} // ExJTable

public class Ex13_11_JTable {
	public static void main(String[] args) {
		new ExJTable();
	} // main
}
