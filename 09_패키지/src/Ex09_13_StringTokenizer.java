import java.util.StringTokenizer;

public class Ex09_13_StringTokenizer {

	public static void main(String[] args) {
		StringTokenizer str = new StringTokenizer("3+2+7+9", "+");

		int i, sum = 0;

		//나눌 토큰이 남을때까지 반복
		while (str.hasMoreTokens()) {
			sum += Integer.parseInt(str.nextToken());
		}

		System.out.println(sum);

//		int num = str.countTokens(); // num에 넣지 않으면 하나씩 토큰이 사라져서 이런방법 써봄.		
//		for(i=0; i<num; i++) {
//			sum += Integer.parseInt(str.nextToken());
//		}
		
		
		//split 메서드 사용 - 다시해보기
		String str2 = "3+2+7+9";
		String[] arr = str2.split("\\+");
		sum = 0;
		for(i=0; i<arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		System.out.println(sum);
	}

}
