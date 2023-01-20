import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

class Fruit extends JFrame { // swing 사용할때에는 JFrame, 창은 닫히지만 프로그램 종료는 아님
	// Label : 글자, 그림 모두 가능

	String[] text = { "사과", "배", "체리" };
	
	// ImageIcon은 Icon의 자식이다.
	ImageIcon[] img = { new ImageIcon("images/apple.jpg"), new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg") };

	// swing의 label은 j가 붙는다.
	JLabel imgLabel = new JLabel(""); // 이미지가 들어가는 영역
	JRadioButton[] radio = new JRadioButton[3];

	// 라디오버튼은 한개만 선택하게 된다.
	public Fruit() {
		// 창 설정
		setTitle("라디오 버튼");
		setDefaultCloseOperation(EXIT_ON_CLOSE); // JFrame.EXIT_ON_CLOSE -> 프로그램 종료기능을 가진다.

		// 제목과 작업영역으로 나뉜다. 작업영역을 가져와 주어야 함.
		Container contentPane = getContentPane(); // 작업 영역을 관리
//		contentPane.setLayout(new BorderLayout()); -> 이런식으로 레이아웃 설정.

		JPanel p = new JPanel();
		p.setBackground(Color.gray);

		int i;
		
		Font font = new Font("궁서",Font.BOLD,30); // 폰트
		
		// 하나의 그룹으로 만들어서 하나만 선택되게 해야함
		ButtonGroup group = new ButtonGroup(); // 그룹객체생성
		for (i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			radio[i].setFont(font); // font객체로 폰트를 설정해라
			
			group.add(radio[i]); // 그룹에 추가하기.
			p.add(radio[i]); // 패널에 올리기
			
			radio[i].addItemListener(new MyItem()); // 해당 클래스에 있다면 this이지만, 내부클래스라는 다른 클래스에 있기 때문에 이렇게 작성해준다.
		} // for
		
		radio[1].setSelected(true); // 기본선택
		
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데정렬
		
		contentPane.add("North", p);
		contentPane.add(imgLabel, BorderLayout.CENTER);

		setSize(300, 400);
		setVisible(true);
	} // Fruit 생성자

	// 내부클래스
	class MyItem implements ItemListener {
		public void itemStateChanged(ItemEvent e) {

			if (radio[0].isSelected()) { // 사과
				imgLabel.setIcon(img[0]);
			} 
			else if (radio[1].isSelected()) { // 바나나
				imgLabel.setIcon(img[1]);
			} 
			else { // 체리
				imgLabel.setIcon(img[2]);
			}

		}
	} // MyItem

} // Fruit 클래스

public class Ex13_10_radioButton {
	public static void main(String[] args) {
		new Fruit();
	}
}
