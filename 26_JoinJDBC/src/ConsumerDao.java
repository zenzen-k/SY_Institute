import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ConsumerDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";

	Connection conn = null;

	public ConsumerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} // ConsumerDao 생성자

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // getConnection()

	public ArrayList<ConsumerBean> getAllConsumer() {
		getConnection();

		ArrayList<ConsumerBean> lists = new  ArrayList<ConsumerBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from consumer order by code";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				ConsumerBean pb = new ConsumerBean(rs.getString("code"), 
						rs.getString("cname"), 
						rs.getInt("cprice"), 
						rs.getString("caddr"));
				lists.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)
					conn.close();
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally
		return lists;
	} // getAllConsumer()

	public int insertConsumer(ConsumerBean cb) {
		getConnection();

		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "insert into consumer values(?,?,?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cb.getCode());
			ps.setString(2, cb.getCname());
			ps.setInt(3, cb.getCprice());
			ps.setString(4, cb.getCaddr());

			cnt = ps.executeUpdate();
		} catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("잘못된 입력값(부모키에 없습니다.)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)
					conn.close();
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally
		return cnt;
	} // insertConsumer()

	public int deleteConsumer(String code) {
		getConnection();
		
		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "delete consumer where code = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	} // deleteConsumer

	public int updateConsumer(String code, String upcode) {
		getConnection();
		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "update consumer set code = ? where code = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, upcode);
			ps.setString(2, code);
			cnt = ps.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("수정 불가 : 부모 키 없음");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	} // updateConsumer

	

} // ConsumerDao 클래스
