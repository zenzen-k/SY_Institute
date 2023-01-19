import java.awt.Frame;

public class Ex13_01_Frame {
	public static void main(String[] args) {
		
		Frame f = new Frame("기본창 만들기"); // 타이틀. 아무것도 없는()생성자를 작성하면 제목없는 프레임이 생긴다.
		// Window 부모 클래스로부터 상속받은 메서드 (setSize, setLocation, setVisible ...)
		f.setSize(400, 300); // 가로, 세로 크기 설정
		f.setLocation(100, 300); // 보여지는 위치 설정. 가장 왼쪽 위쪽을 기준으로 가로100, 세로300 떨어진 자리에 생김
		f.setVisible(true); // 창보이기
		
	}
}
