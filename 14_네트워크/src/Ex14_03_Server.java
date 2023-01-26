import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex14_03_Server {
	public static void main(String[] args) throws IOException {
		
		// 서버소켓
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(5555); // 서버에서 포트번호를 만들어둠
			
		} catch (IOException e) {
			System.out.println("5555번 포트번호는 사용할 수 없습니다.");
			System.exit(1); // 문제가 생겨 정상종료가 아닌 강제종료
		}
		
		// 클라이언트 소켓
		Socket clientSocket = null;
		
		try {
			System.out.println("Server ready..");
			// 클라이언트가 접속하길 기다림
			clientSocket = serverSocket.accept(); 
			// 클라이언트가 접속한다면 해당 클라이언트의 정보가 Socket타입인 clientSocket 에 담긴다.
		} catch (IOException e) {
			System.out.println("accept 실패");
		}
		
		/* 스트림형성 */
		// 접속을 시도한 클라이언트에게 데이터를 보내기 위한 연결다리 형성
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
		
		// 클라이언트가 보낸 데이터를 읽어 들이기 위한 다리
		BufferedReader in = new BufferedReader(
									new InputStreamReader(
											clientSocket.getInputStream()));
		
		// 클라이언트가 보내온 데이터를 읽음
		String inputLine = in.readLine();
		System.out.println("클라이언트가 보내온 데이터:" + inputLine);
		
		// 더이상 사용하지 않을 때
		out.close();
		in.close(); // IOException
		clientSocket.close(); // IOException
		serverSocket.close(); // IOException
	}
}
