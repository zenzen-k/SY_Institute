import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ProducerDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	
	public ProducerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} // ProducerDao 생성자
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // getConnection

	public ArrayList<ProducerBean> getAllProducer() {
		getConnection();
		
		ArrayList<ProducerBean> lists = new  ArrayList<ProducerBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from producer order by code";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProducerBean pb = new ProducerBean(rs.getString("code"), 
												rs.getString("pname"), 
												rs.getInt("pprice"));
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
	} // getAllProducer

	public int insertProducer(ProducerBean pb) {
		getConnection();
		
		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "insert into producer values(?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getCode());
			ps.setString(2, pb.getPname());
			ps.setInt(3, pb.getPprice());
			
			cnt = ps.executeUpdate();
			
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
	} // insertProducer

	public int deleteProducer(String code) {
		getConnection();
		
		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "delete producer where code = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)
					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	} // deleteProducer()

	public int updateProducer(String code, String upcode) {
		getConnection();
		
		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "update producer set code = ? where code = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, upcode);
			ps.setString(2, code);
			cnt = ps.executeUpdate();
		} catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("수정할 수 없음 : 자식 레코드 발견");
		}
		catch (SQLException e) {
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
		} // finally
		return cnt;
	} // updateProducer()
	
} // ProducerDao
