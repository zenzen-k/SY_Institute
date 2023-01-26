import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex14_03_Client {
	public static void main(String[] args) throws IOException {
		
		// 클라이언트에서 받는 소켓
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader user = null;
		
		try {
			// 클라이언트가 어떤 주소를 가지는 서버에 접속하려는지 작성해준다.
			// 내컴퓨터의 아이피 주소는 127.0.0.1, localhost, 실제 내 아이피 주소로 작성가능하다.
			socket = new Socket("localhost",5555); // 내 컴퓨터와 포트번호 5555와 연결
			// 다른 컴퓨터 연결 시 "localhost" 부분에 해당 아이피 주소를 넣으면 된다.
			
			// 서버와연결
			// 클라이언트가 서버쪽으로 데이터를 내보내기 위한 연결다리
			out = new PrintWriter(socket.getOutputStream());
			// 클라이언트가 서버로부터 받은 데이터를 읽어오기 위한 연결다리
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		} catch (UnknownHostException e) { // 없는 주소일 때의 예외
			System.err.println("localhost 접근 불가");
			System.exit(1);
		} catch (IOException e) { // 서버가 준비하지 않은 다른 포트 번호 작성, 이미 사용중인 번호 작성했을 때 예외
			System.err.println("입출력 오류");
			// 에러가 났을 때 빨간 글자로 출력해준다.
			System.exit(1);
		} 
		
		// 키보드와의 연결다리. 키보드로부터 입력을 받는다.
		user = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자입력:");
		// 읽어온 데이터를 fromUser 에 넣는다.
		String fromUser = user.readLine();
		System.out.println("클라이언트가 입력한 문자:" + fromUser);
		// out이라는 연결다리를 통해 데이터를 서버로 출력한다.
		out.println(fromUser); // 서버에게 출력
		
		out.close();
		in.close();
		socket.close();
		user.close();
	}
}
