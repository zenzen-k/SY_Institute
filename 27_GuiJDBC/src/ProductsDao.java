import java.sql.*;
import java.util.ArrayList;

public class ProductsDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";

	Connection conn = null;

	public ProductsDao() { //딱 한번온다.
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("계정접속실패");
			e.printStackTrace();
		}
	} // ProductsDao() 생성자

//	public void getConnection() {
//		try {
//			conn = DriverManager.getConnection(url, id, pw);
//		} catch (SQLException e) {
//			System.out.println("계정접속실패");
//			e.printStackTrace();
//		}
//	} // getConnection()

	/* 전체조회 */
	public ArrayList<ProductsBean> getAllProduct() {
		//getConnection();
		ArrayList<ProductsBean> lists = new ArrayList<ProductsBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from products order by id";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				// 아래처럼 작성하는 것은 복잡해보여서 익숙해지기 전에는 setter 메서드 사용을 권한다.
				ProductsBean pb = new ProductsBean(rs.getInt("id"), rs.getString("name"), rs.getInt("stock"),
						rs.getInt("price"), rs.getString("category"), String.valueOf(rs.getDate("inputdate")));
				lists.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if (conn != null)
//					conn.close();
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	} // getAllProduct()

	public int insertData(ProductsBean pb) {
		//getConnection();
		System.out.println("conn:"+conn); // null이 아니어야 접속된 것이다.
		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "insert into products values(prdseq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getStock());
			ps.setInt(3, pb.getPrice());
			ps.setString(4, pb.getCategory());
			ps.setString(5, pb.getInputdate());
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(conn != null)
//					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt; // 반드시 넘겨야 하는건 아닌뎅 성공실패 알아보고싶으면 넘기기
	} //insertData()

	public int updateData(ProductsBean pb) {
		//getConnection();
		
		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "update products set name = ?, stock = ?, price = ?, category = ?, inputdate = ? where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getStock());
			ps.setInt(3, pb.getPrice());
			ps.setString(4, pb.getCategory());
			ps.setString(5, pb.getInputdate());
			ps.setInt(6, pb.getId());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(conn != null)
//					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	} // updateData()

	public int deleteData(int id) {
		//getConnection();
		
		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "delete products where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(conn != null)
//					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	} // deleteData()

	public void exit() {
		if(conn!=null)
		try {
			conn.close();
			System.out.println("접속 종료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // exit()

} // ProductsDao 클래스
