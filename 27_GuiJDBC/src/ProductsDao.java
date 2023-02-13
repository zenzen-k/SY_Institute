import java.sql.*;
import java.util.ArrayList;

public class ProductsDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";

	Connection conn = null;

	public ProductsDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}
	} // ProductsDao() 생성자

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("계정접속실패");
			e.printStackTrace();
		}
	} // getConnection()

	/* 전체조회 */
	public ArrayList<ProductsBean> getAllProduct() {
		getConnection();
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
	} // getAllProduct()

} // ProductsDao 클래스
