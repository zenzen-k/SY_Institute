import java.sql.*;
import java.util.ArrayList;

/* 여러가지 데이터베이스 작업을 함 */
public class PersonDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "jspid";
	private String password = "jsppw";
	
	Connection conn = null;
	
	//main 메서드에서 객체를 만든다면 여기로 바로온당
	public PersonDao() {
		System.out.println("PersonDao 생성자");
		
		// 제일먼저 해야하는 작업을 가장 먼저 호출되는 곳에서 한다.
		// 1. 드라이버 로드
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			// 2. 단계도 여기서 해도 되지만, 오늘은 메서드 만들어보는 방향
			
		} catch (ClassNotFoundException e) { // 드라이버에 오타가 발생하거나, jar 파일 추가 안했을때.
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
		
	} // 생성자
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password); // 밖에 conn 변수 선언해줘야 다른 곳에서도 씀
			System.out.println("접속성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속실패");
		}
	} // getConnection 메서드
	
	/* select */
	public ArrayList<PersonBean> getAllPerson(){
		// 2단계를 실제로 한건 여기. 호출함으로써 접속이 되니까!
		getConnection();
		ArrayList<PersonBean> lists = new ArrayList<PersonBean>();
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			// 3단계 . SQL문 분석
			String sql = "select * from person order by num";
			ps = conn.prepareStatement(sql);
			// 처음에는 ps에 null값이 있다가 분석할 정보가 들어오면 분석을 한다
			
			// 4단계. SQL문 실행
			rs = ps.executeQuery();
			// ps와 마찬가지로 처음엔 null 이지만 정보가 들어오며 실행을 한다.
			// 실행 결과릉 ResultSet에 저장된당
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				//String birth =  rs.getString("birth"); // 문자열로 가져오면 시간까지 가져옴
				String birth =  String.valueOf(rs.getDate("birth")) ; // java.sql
				// setbirth가 String 타입이기 때문에 Date 타입의 birth를 문자열로 변경하기 위함.
				
				// System.out.println(num +"/"+ name +"/"+ age +"/"+ gender +"/"+ birth);
				// 콘솔 출력은 메인에서 할거임!
				// 따라서 PersonBean 객체를 만들어 저장
				PersonBean pb = new PersonBean();
				pb.setNum(num);
				pb.setName(name);
				pb.setAge(age);
				pb.setGender(gender);
				pb.setBirth(birth);
				// pb객체에 num,name 등등이 들어갔고 이것을 Arraylist에 넣음
				lists.add(pb);
				
			}// while
			
			System.out.println("접속종료");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 발생");
		} finally {
			try {
				// 5단계. 접속종료
				// 세가지 모두 종료해주는것이 좋다.
				if(conn!=null) // 접속 되었을 때 종료하쟈.
					conn.close();
				if(ps!=null)
					ps.close(); // 분석기 반납
				if(rs!=null)
					rs.close(); // 문장에 대한 결과 반납
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	} // getAllPerson 메서드
	
	/* 입력받은 성별을 조회한다. select ~ where ~ */ 
	public ArrayList<PersonBean> getPersonByGender(String gender){
		// 2. 계정접속
		getConnection();
		ArrayList<PersonBean> lists = new ArrayList<PersonBean>();
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		
		// 3. SQL문 분석
//		String sql = "select * from person where gender="+gender;
		String sql = "select * from person where gender=? order by num";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, gender);
			
			// 4. SQL문 실행
			rs = ps.executeQuery();
			
			while (rs.next()) { // 데이터가 없을 때까지 계속 반복~
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender2 = rs.getString("gender"); 
				// Duplicate local variable gender. gender 변수가 이미 있으므로 gender2 변수로 선언함
				// getString 안에 있는 건 컬럼명이니까 상관 ㄴㄴ
				String birth =  String.valueOf(rs.getDate("birth")) ;
				
				// 객체에 컬럼값을 넣는다. setter메서드를 이용함
				PersonBean pb = new PersonBean();
				pb.setNum(num);
				pb.setName(name);
				pb.setAge(age);
				pb.setGender(gender2);
				pb.setBirth(birth);
				
				lists.add(pb); // Arraylist 에 PersonBean 객체 넣음.
			}//while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5단계. 접속종료
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
		return lists; // lists를 가지고 리턴~
	} // getPersonByGender 메서드
	
	
	/* 데이터 삽입 insert */
	public int insertPerson(PersonBean pb){
		System.out.println("PersonDao insertPerson()");
		// 확인용 출력
		//System.out.println(pb.getNum());
		//System.out.println(pb.getName());
		//System.out.println(pb.getAge());
		//System.out.println(pb.getGender());
		//System.out.println(pb.getBirth());
		int cnt = -1;
		// 아래 실행문에서 실행하는 중 에러가 발생하면 값을 담을 수 없으므로 음수로 초기화
		
		PreparedStatement ps =null;
		
		// 2. 계정접속
		getConnection();
		
		// 3. SQL문 분석
		String sql = "insert into person values(perseq.nextval, ?, ?, ?, ? )";
		try {
			ps = conn.prepareStatement(sql);
			
			//위치홀더 값 채우기. 번호는 물음표기준이당
			// sql문에 넣을거니까 ps.set!!!!!!!!!!!!!!!!
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getAge());
			ps.setString(3, pb.getGender());
			ps.setString(4, pb.getBirth());
			
			// 4. SQL문 실행
			cnt = ps.executeUpdate(); // int cnt = 로 받아도 되고 안받아도 된다.
			// 만약 실패한다면 아무런 값도 넣을수조차 없다. 실행자체를 못하니까.
			
			// 아래 문장은 main의 insertPerson 메서드에서!
//			if(cnt>0)
//				System.out.println("insert 성공");
//			else
//				System.out.println("insert 실패");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 접속종료
				if(conn != null)
					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	} //insertPerson
	
	
	/* 정보 수정 update */
	public int updatePerson(PersonBean pb) {
		System.out.println("PersonDao updatePerson()");
		PreparedStatement ps = null;
		int cnt = -1;
		//2.계정접속
		getConnection();
		
		//3.sql문분석
		String sql = "update person set name=?, age=?, gender=?, birth=? where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getAge());
			ps.setString(3, pb.getGender());
			ps.setString(4, pb.getBirth());
			ps.setInt(5, pb.getNum());
			
			//4.sql문 실행
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//5.접속 종료
				if(conn != null)
					conn.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return cnt;
	} //updatePerson
	
	
	/*데이터 삭제 delete*/
	public int deletePerson(int num){
		int cnt = -1;
		PreparedStatement ps = null;
		
		//2 계정접속
		getConnection();
		
		//3 SQL문 분석
		String sql = "delete person where num="+num;
		try {
			ps = conn.prepareStatement(sql);
			
			//4 sql 실행
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
	} // deletePerson
}
