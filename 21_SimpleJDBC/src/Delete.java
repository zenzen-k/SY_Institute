import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 계정접속
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "jspid";
			String pw = "jsppw";
			
			Connection conn = DriverManager.getConnection(url, id, pw);
			
			// 3. SQL 구문 분석
			int delNum = 10;
			String sql = "delete from test where num = " + delNum;
			// String sql = "delete from test where num = 10";
			// String sql = "delete from test where num = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, delNum);
			
			// 4. SQL 구문 실행
			int cnt = ps.executeUpdate();
			System.out.println("cnt:" + cnt);
			
			// 5. 연결해제
			conn.close();
			System.out.println("계정 접속 해제");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 연결 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("계정 접속/해제, SQL구문 분석/실행 실패 ");
		}
		
	}
}
