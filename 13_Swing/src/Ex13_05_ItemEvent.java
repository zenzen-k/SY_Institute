import java.awt.Choice;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
// 패키지는 *안됨

class ExItemEvent extends Frame implements ItemListener {

	Choice ch;

	public ExItemEvent() {

		// 선택박스?
		ch = new Choice();
		ch.add("진달래");
		ch.add("개나리");
		ch.add("장미");
		ch.add("국화");
		ch.add("벚꽃");
		// 프레임에 추가
		add(ch);

		// 프레임창 설정
		setVisible(true);
		setSize(500, 300);

		// 현재 클래스(this)에 itemStateChanged() 가 있당! 알아서 넘어간답!
		// 자동으로 new ItemEvent 객체가 생성된다!
		ch.addItemListener(this);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
//		ItemEvent e = new ItemEvent(); 아이템 이벤트를 받을 수 있도록 이런게 자동으로 준비된다.
		System.out.println("초이스에 변화생김");
		int index = ch.getSelectedIndex(); // 선택한 위치번호 - 0번부터 시작함
		String item = ch.getItem(index); // 선택한 항목의 이름
		System.out.println(index + "/" + item);

	}

} // ExItemEvent

public class Ex13_05_ItemEvent {
	public static void main(String[] args) {

		new ExItemEvent();

	}
}

/*
 * Choice ItemEvent ch.addItemListener ItemListener interface 상속 public void
 * itemStateChanged(ItemEvent e) { }
 */
