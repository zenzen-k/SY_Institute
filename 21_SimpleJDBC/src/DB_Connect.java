import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {
	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로드
			// 오라클을 설치하면 자동으로 드라이버가 설치 됨.
			// 설치되어 있는 드라이버 로드를 해야 함.
			Class.forName("oracle.jdbc.driver.OracleDriver"); // forName->static 메서드
			// 오라클이라는 폴더 안에 JDBC 라는 폴더가 있으며 그안에 driver 폴더안에 OracleDriver 클래스가 있다.
			// 해당 위치에 드라이브가 없다면 ClassNotFoundException 오류가 발생된다.
			// 즉, 위 드라이버 로드를 위해서는 0단계, jar 화일을 추가해야한다.
			
			// ojdbc8.jar 의 위치
			// C:\Oracle\product\12.2.0\dbhome_1\jdbc\lib
			
			
			System.out.println("드라이버 로딩 성공");
			
			// jdbc : 오라클과 자바가 통신하기 위한 프로토콜
			// localhost 내 컴퓨터
			// 1521 포트번호
			// orcl : 전역 데이터베이스 이름. 초반 오라클 설치에 설정한 이름이다.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "jspid";
			String pw = "jsppw";
			
			// 2. 계정 접속
			// getConnection 메서드를 이용하여 계정에 접속할 수 있다.
			// Connection 을 리턴하므로 Connection 타입의 변수에 담음
			// conn 변수에는 이 계정에 접속이 되었다는 정보가 들어간다.
			Connection conn = DriverManager.getConnection(url, id, pw);
			
			// 만약 없는 계정으로 로그인을 시도한다면 오류 발생함.
			// SQLException: ORA-01017: 사용자명/비밀번호가 부적합, 로그온할 수 없습니다.
			System.out.println("DB와의 연결 성공");
			
			/* 여기서 여러가지 DB 작업을 한다.*/
			
			
			// 5. 접속 종료
			conn.close();
			System.out.println("DB와의 연결끊기 성공");
			
			
		} catch (ClassNotFoundException e) { // Class.forName 문자에 오류가 있거나 jar 화일이 없을 때
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
			
		} catch (SQLException e) { //DriverManager.getConnection 올바르지 않은 id나 pw 입력
			e.printStackTrace();
			System.out.println("DB와의 연결 실패");
		}
		
	}
}
