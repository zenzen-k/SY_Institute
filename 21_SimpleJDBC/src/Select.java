import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
	public static void main(String[] args) {
		
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "jspid";
			String pw = "jsppw";
			
			// 1. 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			// 2. 계정 접속
			Connection conn = DriverManager.getConnection(url, id, pw);
			System.out.println("계정 접속 성공");
			
			
			// 3. SQL문 분석
			String sql = "select * from test"; // 그냥 글자
			PreparedStatement ps = conn.prepareStatement(sql);
			// conn jspid계정에 접속했다는 정보가 들어있당
			// sql 쿼리 문으로 사용할 수 있도록 분석한 정보를 ps 변수에 저장.
			// 즉, PreparedStatement는 분석한 정보를 담을 수 있는 타입
			
			
			// 4. SQL문 실행
			ResultSet rs = ps.executeQuery(); // SQL 문 실행하라는 의미. ResultSet 타입의 변수에 결과가 담긴다.
			 
			/* rs 안에 들어가는 2줄,,
						   NUM NAME                 ADDR
					---------- -------------------- --------------------
         					1 kim                  서울
         					2 hong                 부산
			 */
			
			while(rs.next()) { // rs가 관리하는 레코드가 있을때까지 반복해랑
				// 한줄 한줄씩 읽어와서 봄! 한줄 다 읽으면 조건문으로 가서 더 읽을 레코드가 있는지 본다.
				int num = rs.getInt("num"); // "컬럼명" 작성.
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				System.out.println(num+"/"+name+"/"+addr);
				
			} // while
			
			
			// 5. 접속 해제
			conn.close();
			System.out.println("연결 해제");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 계정 접속/종료 실패"); // 계정 접속, 종료, SQL문 분석
		} 
		
	}
}
