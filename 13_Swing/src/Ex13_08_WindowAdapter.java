import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ExWindowAdapter extends Frame {
	public ExWindowAdapter() {
		this.addWindowListener(new MyWindow()); // 여기서 객체를 MyWindow에 만든당. 객체를 만들어야 상속이 되니까ㅏ~
	}

	// WindowAdapter를 상속받는 클래스가 필요해서 내부클래스를 만든거임
	class MyWindow extends WindowAdapter { // 내부 클래스가 WindowAdapter를 상속. 여기에 필요한 메소드만 작성했다.
		public void windowClosing(WindowEvent e) {
			// 엑스 버튼 눌렀을 때
			System.out.println("창이 닫힘");
			System.exit(0); // 프로그램 종료
		}

		public void windowActivated(WindowEvent e) {
			// 창을 내렸다가 다시 활성화 되었을때
			System.out.println("창이 활성화됨");
		}
	}
} // ExWindowAdapter

public class Ex13_08_WindowAdapter {
	public static void main(String[] args) {
		Frame ex = new ExWindowAdapter();

		ex.setSize(300, 300);
		ex.setTitle("WindowAdapter 이벤트");
		ex.setVisible(true);
	}
}
