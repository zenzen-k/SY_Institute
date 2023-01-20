import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ExActionEvent extends Frame implements ActionListener { // 액션을 위한 인터페이스 상속

	Button b1, b2, b3, b4;

	public ExActionEvent() { // 익명클래스 방식~

		b1 = new Button("노란색");
		b2 = new Button("빨강색");
		b3 = new Button("파란색");
		b4 = new Button("분홍색");

		setLayout(new FlowLayout());
		// 프레임에 추가~~
		add(b1);
		add(b2);
		add(b3);
		add(b4);

		// 액션이 발생했당! 알려쥬기
		b1.addActionListener(this); // this : 현재 클래스를 보면 actionPerformed가 있당!
		// actionPerformed()메서드가 있는 위치를 작성해주기 위해서 this 라고 작성한 것
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		// Button이 클릭외었을 때 자동으로 ActionEvent가 발생되면서
		// new ActionEvent()의 객체가 알아서 생성된다.

		// 닫기 버튼
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}); // addWindowListener
		
		// 프레임설정
		setVisible(true);
		setSize(400, 300);
	}

	// 부모 인터페이스로부터 받은 미완성 메서드~!~!~! 완성해주기~~
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌림");

		// 이벤트 소스 : 이벤트가 발생한 컴포넌트
		Object obj = e.getSource(); // e.getSource() : 어느 이벤트 소스에서 이벤트가 발생한거니? 물어봄!
		// Object는 최고 조상이니까 모든 버튼 정보 받아줄수 있당
		if (obj == b1) {
			setBackground(Color.yellow);
		} else if (obj == b2) {
			setBackground(Color.red);
		} else if (obj == b3) {
			setBackground(Color.blue);
		} else if (obj == b4) {
			setBackground(Color.pink);
		}
	}

} // ExActionEvent

public class Ex13_04_ActionEvent {
	public static void main(String[] args) {
		new ExActionEvent();

	} // main
}

// 이렇게 버튼을 눌렀을때 발생한 이벤트를 액션이벤트라고 한당.
// addActionListener메서드 불러주고
// implements ActionListener 이거 상속받구
// public void actionPerformed(ActionEvent e) 메서드 완성해주기!

// 이렇게 예외처리 할때에도 예외객체가 자동으로 생성되면서 catch로 보내졌었다.
