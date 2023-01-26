import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Ex14_02_IPTest {
	public static void main(String[] args) {
		String url;
		System.out.print("웹사이트 주소 입력:");
		InetAddress[] address;

		// 문자입력 안되는 System.in을 InputStreamReader 로 문자를 받을 수 있도록
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			url = br.readLine(); 
			// url = www.naver.com
			
			address = InetAddress.getAllByName(url); // static 이므로 클래스 이름으로 메소드 접근 가능함.
			// 생성자가 없다. getAllByName 메서드가 객체 여러개를 리턴해준다.
			// InetAddress 클래스가 아이피 주소를 받기 위한 클래스다.
			// 도메인 주소가 없으면 UnknownHostException가 발생하지만, IOException 예외가 더 큰 예외라 다 처리해준다.
			
			for(int i = 0; i<address.length; i++) {
				System.out.println(address[i]);
			}
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
}
