import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* 여러가지 데이터베이스 작업을 함 */
public class PersonDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "jspid";
	private String password = "jsppw";
	
	Connection conn ;
	
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
		
		try {
			// 3단계 . SQL문 분석
			String sql = "select * from person";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// 4단계. SQL문 실행
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String birth =  rs.getString("birth");
				
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
			
			// 5단계. 접속종료
			conn.close();
			System.out.println("접속종료");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 발생");
		}
		
		return lists;
	} // getAllPerson 메서드
	
}
