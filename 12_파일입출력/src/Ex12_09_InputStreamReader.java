import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex12_09_InputStreamReader {
	public static void main(String[] args) {

		System.out.print("입력하세요 : ");

//		InputStream is = System.in; 
//		// System.in -> 키보드! 바이트 단위의 데이터~ 따라서 원래는 한글입력이 안 된다.
//		
//		InputStreamReader isr = new InputStreamReader(is); 
//		// 바이트 입력 -> 문자입력. ()안에는 바이트 입력에 해당되는 것을 작성한다. 한글입력도 가능하도록 바꿔주었음.
//		
//		BufferedReader br = new BufferedReader(isr);

		/* 위의 3줄을 한줄로 작성할 수 있당! */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 외우깅 !@@@
		// 이왕이면 버퍼 입력해서 속도 빠르게 하려고! + readLine() 메서드를 사용하기 위해!
		// Buffer 사이즈를 따로 설정하지 않았다면 기본 사이즈인 8192문자를 정할 수 있음. -> new BufferedReader(isr,8192);
		// 만약 한줄에 작성하고 버퍼 사이즈를 설정하고 싶다면
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in),10); -> 이렇게!! 사용후 닫아주기
		
		try {
			String str = br.readLine(); // 한줄 읽어들이는 메서드. 띄어쓰기 포함입력. BufferedReader 클래스에 있는 메서드다.
			// 엔터치기 전까지의 데이터를 읽어들인다.
			System.out.println(str);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
