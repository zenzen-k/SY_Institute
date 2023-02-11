import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumsDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	
	public AlbumsDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}
	} // AlbumsDao
	
	public void getConnect() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("계정 접속 실패");
			e.printStackTrace();
		}
	} //getConnect
	
	// 1.전체조회
	public ArrayList<AlbumsBean> getAllAlbums() {
		getConnect();
		
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from albums order by num";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AlbumsBean ab = new AlbumsBean(
						rs.getInt("num"),
						rs.getString("song"),
						rs.getString("singer"),
						rs.getString("company"),
						rs.getInt("price"),
						String.valueOf(rs.getDate("pub_day"))
						);
				
//				ab.setNum(rs.getInt("num"));
//				ab.setSong(rs.getString("song"));
//				ab.setSinger(rs.getString("singer"));
//				ab.setCompany(rs.getString("company"));
//				ab.setPrice(rs.getInt("price"));
//				ab.setPub_day(String.valueOf(rs.getDate("pub_day")));
				
				lists.add(ab);
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
		}
		
		return lists;
	} // getAllAlbums
	
	// 2.조건조회
	public ArrayList<AlbumsBean> getAlbumsSearch(String column, String search) {
		getConnect();
		
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// select * from albums where lower(song) like lower('%L%');
		// 또는 입력값은 Main클래스에서 입력받을 때 아예 바꿔서 넘길 수도 있다.
		String sql = "select * from albums where lower(" + column + ") like ? order by num";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, '%'+search.toLowerCase()+'%');
			rs = ps.executeQuery();
			
			while (rs.next()) {
				AlbumsBean ab = new AlbumsBean(
						rs.getInt("num"),
						rs.getString("song"),
						rs.getString("singer"),
						rs.getString("company"),
						rs.getInt("price"),
						String.valueOf(rs.getDate("pub_day"))
						);
				
				lists.add(ab);
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
		}
		return lists;
	} // getAlbumsSearch()
	
	// 6. 앨범추가
	public int insertAlbums(AlbumsBean ab) {
		getConnect();
		
		int cnt = -1;
		PreparedStatement ps = null;
		
		String sql = "insert into albums values(albumseq.nextval, ?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, ab.getSong());
			ps.setString(2, ab.getSinger());
			ps.setString(3, ab.getCompany());
			ps.setInt(4, ab.getPrice());
			ps.setString(5, ab.getPub_day());
			
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
		}
		return cnt;
	} // insertAlbums()
	
	// 4. 앨범수정
	public int updateAlbums(AlbumsBean ab) {
		getConnect();
		
		int cnt = -1;
		PreparedStatement ps = null;
		
		String sql = "update albums set song=?, singer=?, company=?, price=?, pub_day=? where num=?";
		
		try {
			
			// 수정할 때 불가피한 상황이 생길 수 있는데, 수정사항이 많을경우에는 자동저장을 하지 않는게 좋다.
			// 아래처럼 수정.
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, ab.getSong());
			ps.setString(2, ab.getSinger());
			ps.setString(3, ab.getCompany());
			ps.setInt(4, ab.getPrice());
			ps.setString(5, ab.getPub_day());
			ps.setInt(6, ab.getNum());
			
			cnt = ps.executeUpdate();
			
			// 커밋하여 저장.
			conn.commit();
			
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
		}
		return cnt;
	} // updateAlbums()
	
	// 5. 앨범삭제
	public int deleteAlbums(int num) {
		getConnect();
		
		//conn.setAutoCommit(true);
		
		int cnt = -1;
		PreparedStatement ps = null;
		String sql = "delete albums where num = " + num;
		
		try {
			// 삭제할때도 마찬가지.
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			cnt = ps.executeUpdate();
			
			conn.commit();
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
		}
		return cnt;
	} // deleteAlbums()

	public ArrayList<AlbumsBean> getAlbumByRange(int start, int end) {
		getConnect();
		
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from (select num, song, singer, company, price, pub_day, "
				+ "rank() over(order by price desc, singer asc) as rank "
				+ "from albums) where rank between "+start+" and "+end;
//		String sql = "select * from (select num, song, singer, company, price, pub_day, "
//				+ "rank() over(order by price desc, singer asc) as rank "
//				+ "from albums) where rank between ? and ?";
		// 함수 없이 등수 구하는 top 구문써보깅!
		
		try {
			ps = conn.prepareStatement(sql);
//			ps.setInt(1, start);
//			ps.setInt(2, end);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AlbumsBean ab = new AlbumsBean(
						rs.getInt("num"),
						rs.getString("song"),
						rs.getString("singer"),
						rs.getString("company"),
						rs.getInt("price"),
						String.valueOf(rs.getDate("pub_day"))
						);
				lists.add(ab);
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
		}
		return lists;
	}

	public ArrayList<AlbumsBean> align(String column, String order) {
		getConnect();
		
		ArrayList<AlbumsBean> lists = new ArrayList<AlbumsBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from albums order by " + column + " " + order;
		//String sql = "select * from albums order by " + column + " ?";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AlbumsBean ab = new AlbumsBean(
						rs.getInt("num"),
						rs.getString("song"),
						rs.getString("singer"),
						rs.getString("company"),
						rs.getInt("price"),
						String.valueOf(rs.getDate("pub_day"))
						);
				lists.add(ab);
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
		}
		return lists;
	} // align

	public AlbumsBean groupbyAlbums(String company) {
		
		getConnect();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		AlbumsBean ab = null;
		
		//String sql = "select company, avg(price) from albums where company like '%" + company + "%' group by company";
		// 별칭을 작성할 수도 있당.
		String sql = "select company, avg(price) as avgprice from albums where company like '%" + company + "%' group by company";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ab = new AlbumsBean();
				ab.setCompany(rs.getString("company")) ;
				ab.setPrice(rs.getInt("avgprice")); // 별칭입력해쥬깅. 별칭만들었으면 꼭 별칭써줘야함
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
		}
		return ab;
	} // groupbyAlbums


}
