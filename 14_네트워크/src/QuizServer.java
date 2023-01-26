import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {
	public static void main(String[] args) throws IOException {
		
		// 서버 소켓
		ServerSocket serverSocket = null;
		
		try {
			System.out.println("Server ready..");
			serverSocket = new ServerSocket(9191);
			System.out.println("접속 성공");
			
		} catch (IOException e) {
			System.err.println("9191번 사용중. 사용 불가");
			System.exit(1);
		}
		
		// 클라이언트 소켓
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("accept실패");
			System.exit(1);
		}
		
		//보내기위한, 읽기위한 두개 다 필요함
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true); // 클라이언트로 보냄
		// 입력한 글자가 버퍼에 알아서 쌓이는데 알아서 내보내라른 의미로 true를 작성해준다.
		
		// 클라이언트로부터 서버로 읽어들일 때 byte 스트림이다. 이것을 InputStreamReader를 통해서 한글 읽을 수 있도록 문자스트림으로 바꾼것이당
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // 클라이언트로부터 받음
		
		// 문제 객체 생성
		QuizBank bank = new QuizBank();
		String outputLine = bank.process(null); // 맨 처음에는 보낼 값이 없당. -> 퀴즈를 시작합니다가 리턴됨!
		out.println(outputLine); // outputLine을 클라이언트로 보낸당.
		
		String inputLine;
		// 서버가 out.println(fromUser); 를 받아줘야한당
		while((inputLine = in.readLine()) != null) {
			outputLine = bank.process(inputLine); // 클라이언트로부터 받은 값을 bank클래스의 process 메소드의 매개변수로 보냄.
			out.println(outputLine); // process 메서드에서 답과 일치한지 확인한 뒤, 리턴값을 받아온 후 클라이언트로 보낸다.
			
			if(outputLine.equals("QUIT"))
				break;
		}
		
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
