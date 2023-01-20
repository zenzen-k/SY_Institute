import java.awt.*;
import java.awt.event.*;

class Ex06_sub extends Frame {

	String[] 대륙 = { "아시아", "유럽", "아프리카" };
	String[][] 나라 = { { "한국", "일본", "중국" }, { "영국", "스위스", "프랑스" }, { "이집트", "콩고", "우간다" } };
	Choice c1, c2;
	Panel p1, p2, p3;
	Label lb1, lb2;
	int index1, index2;

	public Ex06_sub(String title) {

		super(title);
		// setTitle("초이스 이벤트"); // 이런 방식으로 제목을 달 수 있다.

		// 닫기 - 편하게 닫으려고 일단 추가함,,,
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// 라벨 객체 생성
		lb1 = new Label("대륙과 나라를 선택하세요");
		lb2 = new Label();

		// 패널 객체 생성
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();

		// 초이스 - 반복문 사용.
		// 첫번째 초이스의 변화가 생기면 두번째 초이스에 해당 대륙의 나라를 add함.
		// 두번째 초이스 변화가 생기면 "선택한 대륙과 나라는 : 유럽 - 프랑스" -> 출력(p3)
		c1 = new Choice(); // 초이스 객체 생성
		c2 = new Choice();

		p1.add(lb1); // 패널에 라벨 추가
		p3.add(lb2);

		p2.add(c1); // 패널에 초이스 추가
		p2.add(c2);

		// c1 초이스에 추가
		for (int i = 0; i < 대륙.length; i++) {
			c1.add(대륙[i]);
		}

		c1.addItemListener(new ItemC1());
		c2.addItemListener(new ItemC2());

		// 창 설정
		p1.setBackground(Color.pink);
		p2.setBackground(Color.lightGray);
		p3.setBackground(Color.gray);

		add("North", p1); // add("North",lb1); 을 해도됨. 대신 이러면 패널 없음
		add("Center", p2);
		add("South", p3);

		setSize(300, 200);
		setVisible(true);
	}

	class ItemC1 implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			index1 = c1.getSelectedIndex();
			c2.removeAll();

			for (int j = 0; j < 나라[index1].length; j++) {
				c2.add(나라[index1][j]);
			} // for

			// 새로고침해주기! -> 안하니까 적용이 안되어서 창을 움직이는 등의 모션을 해야만 값이 적용 되는 문제가 발생 했었음 ㅠㅠㅠ
			revalidate();
		} // itemStateChanged
	} // ItemC1

	class ItemC2 implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			index2 = c2.getSelectedIndex();
			lb2.setText("선택한 대륙과 나라는 : " + c1.getItem(index1) + " , " + c2.getItem(index2));
			revalidate();
		} // itemStateChanged
	} // ItemC2

} // Ex06_sub

public class Ex13_06_김아연 {
	public static void main(String[] args) {
		new Ex06_sub("초이스 이벤트");
	}
}


/* choice 박스에서 첫번째 값을 클릭하려고 하면 클릭 이벤트 자체가 발생하지 않더라. 다른 값을 클릭 한 뒤에 다시 첫번째 값을 클릭하면 이벤트가 발생한다.
 * 혹시나 해서 13_04파일도 시도해봤는데 마찬가지였다. 아마 choice 자체가 그런 듯? 
 * 약간 회원가입 창 볼때도 첫째줄에는 항상 성별을 선택해주세요 같은 문구가 떴던것 같다
 * 일단은 내 생각이고 좀 더 찾아보고 노션에 정리해보기..!
 * */
