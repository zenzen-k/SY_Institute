import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JoinDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	
	public JoinDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<JoinBean> join() {
		getConnection();
		
		ArrayList<JoinBean> lists = new ArrayList<JoinBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from producer natural join consumer";
		//String sql = "select * from producer inner join consumer on producer.code = consumer.code";
		//String sql = "select * from producer, consumer where producer.code = consumer.code";
		// 또는 필요한 컬럼만 가져와도 된다. select c.code, pname, cname, cprice, caddr from ~
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				JoinBean jb = new JoinBean(rs.getString("code"), 
											// 만약에 위에서 c.code 로 가져왔다면 별칭을 작성해주고 별칭을 사용해야한다.
											// . 을 쓸 수 없기 때문엥!
											rs.getString("pname"),
											rs.getString("cname"),
											rs.getInt("cprice"),
											rs.getString("caddr"));
			lists.add(jb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return lists;
	}
}
