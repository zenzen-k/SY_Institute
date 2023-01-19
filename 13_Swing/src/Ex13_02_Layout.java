import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

class Ex13_02_Sub extends Frame{
	
	public Ex13_02_Sub (String title) {
		super(title); // 부모에게 넘기기
		setSize(400,300); // super.setSize()로 해도 상관없음!!!!
		
		// 버튼생성
		Button east = new Button("east"); // ""안의 글자가 버튼위로 올라간거!
		Button west = new Button("2");
		Button south = new Button("south");
		Button north = new Button("north");
		Button center = new Button("center");
		
//		setLayout(new FlowLayout()); // 배치 설정하는 메서드. 물 흐르듯 배치한다고해서 FlowLayout이라고 한다.
//		setLayout(new BorderLayout()); // 기본값. 동서남북중앙 이렇게 배치하는 방식이다.
		setLayout(new GridLayout()); // 1행으로 주륵~
//		setLayout(new GridLayout(2,3)); // 2행 3열
		
		
//		 아래 3가지 방법 다 가넝!!! 
		super.add(east); // 부모 프레임에 east 버튼을 올려라
		add(west);
		this.add(south);
		super.add(north);
		super.add(center);
		
		// BorderLayout 의 배치 사용법. 방향을 잡아주지 않으면 다 가운데 겹쳐서 생성된다.
//		add(east,BorderLayout.EAST); // 방향설정 동쪽
//		add(west,BorderLayout.WEST); // 서 ..
//		add(south,BorderLayout.SOUTH);
//		add(north,BorderLayout.NORTH);
//		add(center,BorderLayout.CENTER);
		
		// BorderLayout 의 배치 사용법2
		// 만약 FlowLayout으로 위에서 설정해놓고 방향해도 에러는 뜨지 않지만 그냥 무시해버림!
//		add("East",east); // 방향을 앞에, 버튼객체를 뒤에. 첫글자 대문자
//		add("West",west);
//		add("South",south);
//		add("North",north);
//		add("Center",center);
		
		setVisible(true);
	}
	
} // sub



public class Ex13_02_Layout {
	public static void main(String[] args) {
		
		Ex13_02_Sub ex = new Ex13_02_Sub("Layout 예제"); // 프레임을 상속받은!!
		
		ex.setVisible(true);
		
	}
}
