import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	
	public ProductDao() {
		try {
			// 1단계 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}		
	} // ProductDao 생성자
	
	
	public void getConnection() {
		//2단계 계정 접속을 위한 준비
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("접속성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속실패");
		}
	} // getConnection() 메서드
	
	
	/* 1. 전체 상품 조회 */
	public ArrayList<ProductBean> getAllProduct() {
		getConnection();
		
		ArrayList<ProductBean> lists = new ArrayList<ProductBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from products order by id";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setStock(rs.getInt("stock"));
				pb.setPrice(rs.getInt("price"));
				pb.setCategory(rs.getString("category"));
				pb.setInputdate(String.valueOf(rs.getDate("inputdate")));
				
				lists.add(pb);
			} // while
			System.out.println("lists.size() : " + lists.size()); // test
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
		} //finally
		return lists;
	} // selectAllProduct() 메서드
	
	
	/* 2. 선택조회 - 아이디 */
	public ProductBean getProductById(int id){
		getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductBean pb = null;
		
		String sql = "select * from products where id=" + id;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// 한줄만 가져오니까 while문으로 반복을 굳이 안해도 된당.
			if (rs.next()) {
				pb = new ProductBean();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setStock(rs.getInt("stock"));
				pb.setPrice(rs.getInt("price"));
				pb.setCategory(rs.getString("category"));
				pb.setInputdate(String.valueOf(rs.getDate("inputdate")));
				// lists.add(pb); 되긴 하지만 하나밖에 없어서 굳이 안넣어도 된다.
			} // if
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
		return pb;
	} // getProductById() 메서드
	
	
	/* 3. 선택조회 - 카테고리 */
	public ArrayList<ProductBean> getProductByCategory(String category) {
		getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductBean pb = null;
		ArrayList<ProductBean> lists = new ArrayList<ProductBean>();
		
		//String sql = "select * from products where category = ?";
		// 입력받은거 대문자로 변경
		//String sql = "select * from products where category = upper(?)"; 
		// 입력되어있던 데이터 전체 소문자로 바꿔서 조회
		String sql = "select * from products where lower(category) = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			// 입력받은 것도 소문자로 변경
			ps.setString(1, category.toLowerCase());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pb = new ProductBean();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setStock(rs.getInt("stock"));
				pb.setPrice(rs.getInt("price"));
				pb.setCategory(rs.getString("category"));
				pb.setInputdate(String.valueOf(rs.getDate("inputdate")));
				
				lists.add(pb);
			} // while
			System.out.println("lists.size() : " + lists.size());
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
	} // getProductByCategory() 메서드
	
	
	/* 4. 상품 추가 */
	public int insertProduct(ProductBean pb) {
		getConnection();
		
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
				if(conn!=null)
					conn.close();
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally
		return cnt;
	} // insertProduct
	
	
	/* 5. 상품 수정 */
	public int updateProduct(ProductBean pb) {
		getConnection();
		
		int cnt = -1;
		PreparedStatement ps = null;
		
		String sql = "update products set name=?, stock=?, price=?, category=?, inputdate=? where id=?";
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
				if(conn!=null)
					conn.close();
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally
		return cnt;
	}
	
	
	/* 6. 상품 삭제 */
	public int deleteProduct(int id2) {
		getConnection();
		
		int cnt = -1;
		PreparedStatement ps = null;
		
		String sql = "delete products where id="+id2;
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
	} // deleteProduct 메서드

	
} // ProductDao 클래스
