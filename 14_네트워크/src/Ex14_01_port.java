import java.io.IOException;
import java.net.ServerSocket;

public class Ex14_01_port {
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		
		for(int i = 0 ; i <65535; i++) {
			try {
				ss = new ServerSocket(i); // IOException
				ss.close(); // 파일입출력에서 파일과 연결다리를 끊어내듯이 클라이언트와 서버의 연결을 끊는다.
				// close 할때도 IOException이 발생할 수 있다.
				// 둘다 예외처리 해주기!
			} catch (IOException e) {
				System.out.println(i+"번 포트는 이미 사용중입니다.");
			}
		}
	}
}
