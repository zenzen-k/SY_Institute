import java.util.ArrayList;
import java.util.Scanner;

public class Ex10_02_ArrayList {

	public static void main(String[] args) {
		
		int[] a = {1,2,3}; // 배열에는 자료형도 되고 클래스도 들어갈수있당~ Integer
		int[] b = new int[5];
		
		// generic방식처럼 지금 어떤 자료형을 할지 작성
		ArrayList<String> s1 = new ArrayList<String>();
		
		int size = s1.size();
		System.out.println("size:" + size); // 0. 공간은 만들었지만 데이터를 넣지 않아서 아직 크기가 0임
		
		s1.add("태연"); // 0번째
		s1.add("수영");
		s1.add("유리");
		s1.add("수영");
		size = s1.size();
		System.out.println("size:" + size); //데이터 개수 출력, 4개. 중복을 허용한다.
		
//		s1.add("써니"); // 이렇게 하면 맨뒤에 데이터가 들어감
		s1.add(1,"써니"); // 특정 위치에 값을 삽입할 수 있다.
		//add (E, a) E는 요소로 지정한 타입을 말한다.
		
		
		System.out.println(s1.toString()); // 재정의가 되어있다.
		
		String g = s1.get(0);
		System.out.println("g변수:" + g); // 태연 출력
		
		
		ArrayList<String> add = new ArrayList<String>();
		add.add("웬디"); // 0
		add.add("슬기"); // 1
		
		// add(Collection <?> ()); 컬렉션을 넣을 수있당. 
		// 덩어리 추가 가능! add컬렉션에 있던 웬디와 슬기가 추가되었다.
		s1.addAll(add);
		System.out.println(s1.toString());
		
		size = s1.size();
		System.out.println(size); // 7개지만 0~6번.
		
		
		//remove (Object) -> 다 넣을 수 있음!
		s1.remove(1); // 2번째 있는 써니 삭제
//		s1.remove("수영"); // 첫번째 수영만 지워진다
		//모든 수영을 지우는 방법.
		ArrayList<String> delete = new ArrayList<String>();
		delete.add("수영");
		s1.removeAll(delete);
		
		System.out.println(s1.toString());
		
		s1.add("웬디");
		System.out.println(s1);
		
		// indexOf 데이터가 있으면 해당 위치를 출력, 없으면 -1
		int index1 = s1.indexOf("웬디"); // 첫번째 웬디의 위치 출력 만약! 없는 값이라면 -1이 나온다.!!!!
		int index2 = s1.lastIndexOf("웬디"); // 마지막 웬디의 위치 출력
		System.out.println(index1+","+index2);
		
		if(index1 == -1) {
			System.out.println("웬디가 없습니다.");
		}
		
		// contains 데이터가 있으면 true를 출력, 없으면 false
		boolean result = s1.contains("슬기");
		System.out.println("result:" + result); //포함하면 true, 없으면 false
		if(result == false) {
			System.out.println("웬디가 없습니다.");
		}
		
		// 2번방에 있는 데이터와 값을 변경한다.
		s1.set(2, "윤아");
		System.out.println(s1);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요:");
		String name = sc.next();
		
		// 회원명 찾기
		if(s1.indexOf(name) != -1) {
			System.out.println("가입한 회원입니다.");
		}
		else {
			System.out.println("가입하지 않은 회원입니다.");
		}
		
		System.out.println("-----");
		
		boolean flag = false;
		int i;
		for(i=0; i<s1.size(); i++) { // i<4
			if(s1.get(i).equals(name)) {
				System.out.println("가입한 회원입니다.");
				flag = true;
				break;
			}
		}
		if (flag == false)
			System.out.println("가입하지 않은 회원입니다.");
		
		
		System.out.println("------------");
		
		
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		s2.add(100);
		s2.add(new Integer(200)); // 원래 작성법이지만, 알아서 100 -> new Integer(100)으로 바뀐다. 오토박싱~
		s2.add(300);
		
		System.out.println("s2 size:" + s2.size());
		System.out.println(s2); // 오버라이딩 되어있으므로 참조값이 아닌 Integer의 값이 출력된다.
		
		Integer g2 = s2.get(0);
		System.out.println("g2:" + g2);
		
		
	}

}
