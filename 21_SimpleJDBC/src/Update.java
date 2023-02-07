import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "jspid";
			String pw = "jsppw";
			
			Connection conn = DriverManager.getConnection(url, id, pw);
			System.out.println("계정 접속 성공");
			
			int upNum=10;
			String upName = "써니";
			String upAddr = "인천";
			int conNum= 9;
			
			//String sql = "update test set num = 7 , name = '윤아', addr = '목표' where num = 3";
			//String sql = "update test set num ="+upNum+", name = '"+upName+"', addr = '"+upAddr+"' where num = "+conNum;
			String sql = "update test set num = ? , name = ?, addr = ? where num = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, upNum);
			ps.setString(2, upName);
			ps.setString(3, upAddr);
			ps.setInt(4, conNum);
			
			// 성공적으로 update 한 개수를 리턴한다.
			// 0 이 나왔다면 그냥 조건에 맞는게 없어서 못한거 . 수정실패는 아님
			int cnt = ps.executeUpdate();
			
			System.out.println("cnt:" + cnt);
			
			conn.close();
			System.out.println("계정 접속 해제");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 계정 접속/종료 실패");
		}

	}
}
