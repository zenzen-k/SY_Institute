import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ExWindowAdapter2 extends Frame {
	public ExWindowAdapter2() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// 엑스 버튼 눌렀을 때
				System.out.println("창이 닫힘");
				System.exit(0); // 프로그램 종료
			}

			public void windowActivated(WindowEvent e) {
				// 창을 내렸다가 다시 활성화 되었을때
				System.out.println("창이 활성화됨");
			}
		}); // 내부클래스를 별도로 정의하지 않고 이렇게 직접 정의하는 것도 가능하다.
	}

} // ExWindowAdapter2

public class Ex13_09_WindowAdapter {
	public static void main(String[] args) {
		Frame ex = new ExWindowAdapter2();

		ex.setSize(300, 300);
		ex.setTitle("WindowAdapter 이벤트");
		ex.setVisible(true);
	}
}
