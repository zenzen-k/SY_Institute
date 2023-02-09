import java.sql.*;
import java.util.ArrayList;

public class BookDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	
	/* 1단계 - 드라이버 로드 */
	public BookDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}
	} // 생성자
	
	
	/* 2단계 - 계정접속 */
	public void getConnect(){
		try {
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
	} // getConnect
	
	
	/* 1.전체조회 */
	public ArrayList<BookBean> getAllBook() {
		getConnect();
		
		ArrayList<BookBean> lists = new ArrayList<BookBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from book order by no";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BookBean bb = new BookBean();
				bb.setNo(rs.getInt("no"));
				bb.setTitle(rs.getString("title"));
				bb.setAuthor(rs.getString("author"));
				bb.setPublisher(rs.getString("publisher"));
				bb.setPrice(rs.getInt("price"));
				bb.setPub_day(String.valueOf(rs.getDate("pub_day")));
				
				lists.add(bb);
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
	} // getAllBook
	
	
	/* 3.정보수정 */
	public int updateBook(BookBean bb) {
		getConnect();
		
		PreparedStatement ps = null;
		int cnt = -1;
		
		String sql = "update book set title=?, author=?, publisher=?, price=?, pub_day=? where no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getTitle());
			ps.setString(2, bb.getAuthor());
			ps.setString(3, bb.getPublisher());
			ps.setInt(4, bb.getPrice());
			ps.setString(5, bb.getPub_day());
			ps.setInt(6, bb.getNo());
			
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
	} // updateBook
	
	
	/* 4.정보삭제 */
	public int deleteBook(int no) {
		getConnect();
		
		int cnt = -1;
		PreparedStatement ps = null;
		
		String sql = "delete book where no="+no;
		try {
			ps = conn.prepareStatement(sql);
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
	} // deleteBook
	
	
	/* 5.정보추가 */
	public int insertBook(BookBean bb) {
		getConnect();
		
		int cnt = -1;
		PreparedStatement ps = null;
		
		String sql = "insert into book values(bseq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getTitle());
			ps.setString(2, bb.getAuthor());
			ps.setString(3, bb.getPublisher());
			ps.setInt(4, bb.getPrice());
			ps.setString(5, bb.getPub_day());
			
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
	} // insertBook
}
