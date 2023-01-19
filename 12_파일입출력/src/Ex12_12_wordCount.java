import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex12_12_wordCount {
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("lyrics.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String str;
		int count = 0;
		
		String lyrics = ""; // null이 아닌 ""로 초기화. null로 초기화하면 null뒤에 붙어서 나온다.
		while ((str = br.readLine()) != null) { // 한줄을 읽을때에는 null을 만난다.
			//System.out.println(str); // readLine은 엔터치기 전까지의 데이터를 가져오니까 엔터를 여기서 쳐준당~!
			lyrics += str + " ";
			count++;
		}
		System.out.println("linecount:" + count);
		System.out.println(lyrics); // 한번에 출력
		
		// 내가 한 방법...
//		String[] a = null;
//		for(int i=0; i<lyrics.length(); i++) {
//			a = lyrics.split(" ");
//		}
		
		// 굳이 for문 안써도 된다...ㅠㅠ 바부
		String[] arr = lyrics.split(" ");
		System.out.println("전체단어갯수:"+arr.length);
		
		
		
		/* 해시맵으로 단어 개수 작성해보기 */
		Map<String, Integer> m = new HashMap<String, Integer>();
		
//		Integer num = 1;
//		int i;
//		for(i = 0; i<arr.length; i++) {
//			if(m.containsKey(arr[i])) {
//				m.put(arr[i], m.get(arr[i])+1);
//			} else {
//				m.put(arr[i], num);
//			}
//		}
		
		
		int i; 
		for(i=0;i<arr.length; i++) {
			String a = arr[i].toLowerCase(); // 대소문자 구분없이 하려고 추가해봄!
			if(m.get(a) == null) {
				m.put(a, 1);
			} else {
				Integer v = m.get(a);
				m.put(a, v + 1);
//				m.put(arr[i], m.get(arr[i])+1);
			}
		}
		
		Set<String> words = m.keySet();
		for(String key : words) { // 키만 가져온당
			System.out.println(key + ":" + m.get(key));
		}
		
		System.out.println("중복제거한 횟수 : " + words.size());
		
	} // main
}
