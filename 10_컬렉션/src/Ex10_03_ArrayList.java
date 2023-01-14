import java.util.ArrayList;
import java.util.Iterator;

class Person{
	private String id;
	private String pw;
	
	public Person(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	// 오버라이딩.
	public String toString() {
		return id+"/"+pw;
	}
	
} // Person



public class Ex10_03_ArrayList {

	public static void main(String[] args) {
		
		Person p1 = new Person("kim","1111");
		Person p2 = new Person("park","3333");
		Person p3 = new Person("lee","5555");
		
		// ArrayList엔 객체만 넣을 수 있당!
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
//		list.add(new Person("lee","5555")); 이런방식도된당
		
		// 생략도 되지만 공부용으로 작성.
		System.out.println(list.toString());
		// [Person@626b2d4a, Person@5e91993f, Person@1c4af82c]
		// 이렇게 나오는 이유!! 요소의 toString()이 나오니까 이렇게 나온당.
		
		int i;
		for(i=0; i<list.size(); i++) {
			Person p = list.get(i); // i번째에는 Person객체가 들어있으므로 가지고 오는것도 Person객체여야 한다.
			System.out.println(p);
		}
		System.out.println();
		
		// Iterator 도 제너릭타입.
		// Iterator는 반복자. 즉, ArrayList에 있는 요소들을 반복할 준비를 해준당.
		// 이 요소들은 Iterator 타입으로 바뀐다. 
		Iterator<Person> iter = list.iterator();
		while(iter.hasNext()) { // hasNext() -> boolean 리턴타입. 반복할 대상이 있는지 물어보는 메소드.
			Person p = iter.next(); // iter에 있는걸 하나 가져와서 Person객체 p 에 넣는다. 
			System.out.println(p); // 전체 출력
			System.out.println(p.getId() + ":" + p.getPw()); // 하나씩 가져와서 출력
		}
		
	} // main

}
