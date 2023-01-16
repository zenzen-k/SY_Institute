import java.util.HashSet;
import java.util.Iterator;

public class Ex10_07_HashSet {

	public static void main(String[] args) {
		
		HashSet<String> hs = new HashSet<String>();
		System.out.println(hs.size());
		
		hs.add("수지");
		hs.add("웬디");
		hs.add("수지"); // 들어가지 않는 값.
		hs.add("윤아");
		
		// 중복을 허용하지 않기 때문에, 3이 나온다.
		System.out.println(hs.size()); // 3
		System.out.println(hs); // [수지, 웬디, 윤아]
//		System.out.println(hs.get(0)); // 따로 순서를 가지고 있지 않기 때문에 이런 방식의 호출이 불가능하다.
		for(String s : hs) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		Iterator<String> iter = hs.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " "); 
		}
		System.out.println();
		
//		hs.add(1, "아이유"); 이런거안됨~! 위치때문에!
		// addAll은 사용가능!
		
		boolean result = hs.contains("웬디");
		System.out.println("result:" + result);
		
		hs.clear();
		hs.remove("윤아");
		result = hs.isEmpty();
		System.out.println(result);
		
	}

}
