import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

class ExPanel extends Frame {

	public ExPanel() {

		setSize(400, 300);

		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		Button b3 = new Button("버튼3");

		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();

		// 버튼뿐만 아니라 패널도 함께 flowLayout으로 잡힌다.
//		setLayout(new FlowLayout());

		p1.add(b1); // 패널에 버튼을 올림.
		p2.add(b2);
		p3.add(b3);

		
		// 패널에 색상을 올림 - 색상을 올릴때에는 전체 소문자 or 전체 대문자. 섞어서 사용 금지
		p1.setBackground(Color.pink);
		p2.setBackground(Color.gray);
		p3.setBackground(Color.darkGray);

		// 버튼에 색상을 올림
		b1.setBackground(Color.CYAN);

		
		// 프레임에 패널을 올리는 3가지 방법. + 패널의 위치를 변경한다.
		add("North", p1);
		this.add("Center", p2);
		super.add("South", p3);

		setVisible(true);
	}

} // ExPanel

public class Ex13_03_Panel {
	public static void main(String[] args) {
		new ExPanel();
	}
}
