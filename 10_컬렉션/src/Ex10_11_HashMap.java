import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex10_11_HashMap {
	public static void main(String[] args) {
		
		Map<String, String> dic = new HashMap<String, String>();
		dic.put("apple", "사과");
		dic.put("banana", "바나나");
		dic.put("pineapple", "파인애플");
		dic.put("strawberry", "딸기");
		dic.put("watermelon", "수박");
		
		System.out.println(dic);
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("찾는 단어는?(q입력시 종료) ");
			String word = sc.next();
			word = word.toLowerCase(); // 소문자로 변경. get에 바로 작성하는 것 보다는 별도로 만들어주는게 안전하다.
			
			if(word.equals("q")) 
				break;

			if(dic.get(word) == null) {
				System.out.println("잘못입력하셨습니다.");
			}
			else {
				System.out.println("뜻 : " + dic.get(word));
			}
			System.out.println();
		}while(true);//while
		
		System.out.println("프로그램을 종료합니다.");
		
		sc.close();
	}
}
