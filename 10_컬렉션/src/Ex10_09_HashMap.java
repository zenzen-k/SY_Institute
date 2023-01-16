import java.util.HashMap;
import java.util.Set;

public class Ex10_09_HashMap {

	public static void main(String[] args) {
		
		// <키(key), 값(value)>
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		System.out.println(map.size());
		
		map.put("아이유", 30);
		map.put("정국", 40);
		map.put("아이유", 20);
		map.put("이무진", 20);
		
		System.out.println(map.size()); // 3
		System.out.println(map.toString()); //{정국=40, 이무진=20, 아이유=20}

		//map.get(1) -> 순서가 없으므로 인덱스 접근 안됨
		Integer v = map.get("이무진"); // -> 이렇게 키값으로 값을 접근함.
		System.out.println(v); // 따라서 20이 출력된다.
		
		boolean result1 = map.containsKey("정국");
		System.out.println(result1);
		
		boolean result2 = map.containsValue(40);
		System.out.println(result2);
		
		
		
		
		Set<String> s = map.keySet(); // Set을 리턴한다. -> 순서 X , 중복 X . 현재 map의 키가 String 이므로 이것도 함께 작성해주면 좋음
		System.out.println(s);

		
		int i;
		for(i=0; i<s.size(); i++) {
			//위치가 없으니까 s.get(1) 안된당!
//			System.out.print(map.get(s) + " "); // null 이 나온다.
			// s에는 현재 [정국, 이무진, 아이유] , 즉 키들이 통째로 들어와있기 때문이다.
		}
		System.out.println();
		
		for(String key : s) { // s를 꺼내면 String임! 현재 s에는 map의 키들이 들어가있다.
			System.out.println(key+":"+map.get(key));
		}
		
		
//		//전체삭제
//		map.clear();
//		System.out.println(map);
		
		//해당되는 키와 값의 쌍을 지운다.
		Integer inte = map.remove("이무진");
		// 지우는데 성공하면 그 값(value)가 리턴, 실패하면 null이 리턴된다.
		System.out.println("inte:" + inte);
		if(inte == null) {
			System.out.println("삭제 실패");
		}
		else {
			System.out.println("삭제 성공");
		}
		System.out.println(map);
	}

}
