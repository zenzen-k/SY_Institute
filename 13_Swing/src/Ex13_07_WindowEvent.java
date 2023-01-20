import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class ExWindow extends Frame implements WindowListener {

	// 이렇게 윈도우 인터페이스를 상속받다보니까 필요없는것도 완성을 해야했다.
	// -> 이런 단점으로 인해 Adapter 클래스가 나옴. -> 윈도우 외에도 너무 많은 것을 상속 받는 클래스가 있을 때, 필요한것만 사용할
	// 수 있게

	public ExWindow() {
		this.addWindowListener(this); // 앞의 this는 Frame. 윈도우 리스너 추가 (현재 클래스안에 있다는 의미의 this)
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// 처음 창이 열렸을때 ?
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 엑스 버튼 눌렀을 때
		System.out.println("창이 닫힘");
		System.exit(0); // 프로그램 종료
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// 창을 내렸다가 다시 활성화 되었을때
		System.out.println("창이 활성화됨");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

} // ExWindow

public class Ex13_07_WindowEvent {
	public static void main(String[] args) {

		ExWindow ex = new ExWindow();

		ex.setSize(300, 300);
		ex.setTitle("Window 이벤트");
		ex.setVisible(true);
	}
}
/*
 * 윈도우 창 변화가 생겼을 때 윈도우 이벤트 객체가 생성 객체를 가지고 해당 메소드로 간당.
 */
