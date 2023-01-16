import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Movie {
	private String title;
	private int age;

	public Movie(String title, int age) {
		super();
		this.title = title;
		this.age = age;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// 오버라이딩
	public String toString() {
		return title + "," + age;
	}

} // Movie

public class Ex10_10_HashMap {

	public static void main(String[] args) {

		Map<String, Movie> map = new HashMap<String, Movie>();

		Movie m1 = new Movie("아바타", 12);
		Movie m2 = new Movie("압꾸정", 15);
		Movie m3 = new Movie("공조", 19);

		map.put("CGV", m1);
		map.put("롯데시네마", m2);
		map.put("서울극장", m3);

		// Movie의 toString을 오버라이딩 해주면 키(String.toString())와 값(Movie.toString())이 호출된다!
		// 형식은 { 키 = 값 , 키 = 값 }
		System.out.println(map);

		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 영화관 입력:");
		String theater = sc.next();

//		Movie m = map.get(theater); // 입력값을 바로 넣으면 된다,,!
//		System.out.println(m);

		if (map.get(theater) == null) {
			System.out.println("영화관을 잘못 입력하였습니다.");
		} else {
			System.out.println(map.get(theater));
		}
		
		// 나중에 들어오는 값으로 변경된다. 만약 해당되는 키를 찾지 못한다면 에러발생하지 않고 변경안됨.
		Movie m4 = new Movie("관상",12);
		map.replace("서울극장", m4);
		System.out.println(map);
		
		// 삭제 - 키값 입력하기.
		map.remove("CGV");
		System.out.println(map);
		
	}

}
