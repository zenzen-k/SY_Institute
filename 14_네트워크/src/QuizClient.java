import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient {
	public static void main(String[] args) throws IOException {

		Socket socket = null;

		try {
			socket = new Socket("localhost", 9191);

		} catch (UnknownHostException e) {
			System.err.println("없는 번호.. localhost 접근 불가");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("입출력 오류");
			System.exit(1);
		}

		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		// 클라이언트에서 입력 - y/n
		BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
		// 서버에서 보낸 out.println(outputLine);를 받아주어야 한다.
		String fromServer, fromUser = null; // 서버로부터 받아온 값을 저장
		while ((fromServer = in.readLine()) != null) {
			System.out.println("서버:" + fromServer); // 읽어온 값을 출력!
			if(fromServer.equals("QUIT")) {
				break;
			}
			
			fromUser = user.readLine(); // y or n -> 이걸 다시 서버로 전송.
			if(fromUser != null) {
				System.out.println("클라이언트:" + fromUser);
				out.println(fromUser); // 작성한 코드를 서버로 보낸당!
			}
		} // while
		
		// 더이상 사용하지 않을 때.
		out.close();
		in.close();
		user.close();
		socket.close();
	}
}
