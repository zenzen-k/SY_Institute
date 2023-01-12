import java.util.StringTokenizer;

public class Ex09_12_StringTokenizer {

	public static void main(String[] args) {
		
		// 구분자("/")를 기준으로 앞에 있는 문자열을 분리시키는 클래스.
		// 분리된 문자열은 '토큰'이라고 부른다.
		// 구분자는 여러개가 될 수 있다.
		// 구분자를 작성하지 않으면 공백 기준으로 분리함.
		// 다른 구분자가 있을 땐 공백 구분자가 생기지 않아서 공백을 추가하고 싶을 땐 같이 추가해주어야 한다.
		StringTokenizer str = new StringTokenizer("2023/01/12,16:01","/,: ");
		
		int count = str.countTokens();
		System.out.println("count:"+count);
		
		// token을 가지고 있는지 물어보는 메소드. 끊어낼게 있는지 물어봄.
		while(str.hasMoreTokens()) { // 아직 토큰이 더있으면 true.
			String s = str.nextToken(); // 한개의 토큰을 가져옴
			System.out.println(s);
		}
		System.out.println();
		
		// 문자열을 쪼개는. 구분자를 하나만 넣을 수 있음.
		// String[] 을 리턴함. 배열이다.
		String str1 = "2023/01/12,16:01";
		String[] arr = str1.split("/");
		
		int i;
		for(i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
