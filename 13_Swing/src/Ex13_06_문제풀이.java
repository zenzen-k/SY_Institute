import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Ex06_sub2 extends Frame implements ItemListener {

	String[] 대륙 = { "아시아", "유럽", "아프리카" };
	String[][] 나라 = { { "한국", "일본", "중국" }, { "영국", "스위스", "프랑스" }, { "이집트", "콩고", "우간다" } };
	Choice c1, c2;
	Label lb1, lb2;

	public Ex06_sub2(String title) {

		super(title);

		lb1 = new Label("대륙과 나라를 선택하세요");
		lb2 = new Label();

		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();

		p1.add(lb1);
		p1.setBackground(Color.pink);
		p2.setBackground(Color.lightGray);
		p3.setBackground(Color.gray);

		c1 = new Choice();
		c2 = new Choice();
		p2.add(c1);
		p2.add(c2);
		p3.add(lb2);

		int i;
		for (i = 0; i < 대륙.length; i++) {
			c1.add(대륙[i]);
		}
		c2.add("            ");

		c1.addItemListener(this);
		c2.addItemListener(this);

		add("North", p1);
		add("Center", p2);
		add("South", p3);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setSize(300, 200);
		setVisible(true);

	} // 생성자

	@Override
	public void itemStateChanged(ItemEvent e) {
		String str = "선택한 대륙과 나라는 : ";
		Choice obj = (Choice) e.getSource(); // 이벤트가 발생한 컴포넌트의 정보를 알아오기 위한 메서드
		if (obj == c1) {
			c2.removeAll();
			int index = c1.getSelectedIndex();
			for (int i = 0; i < 나라[index].length; i++) {
				c2.add(나라[index][i]);
			}
		} else {
			str += c1.getSelectedItem();
			str += "-" + c2.getSelectedItem();
			lb2.setText(str);
		}
		revalidate(); // 새로고침
	}

} // Ex06_sub2

public class Ex13_06_문제풀이 {
	public static void main(String[] args) {
		new Ex06_sub2("초이스 이벤트");
	}
}
