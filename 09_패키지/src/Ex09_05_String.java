
public class Ex09_05_String {

	public static void main(String[] args) {
		
		char ch;
		String str = "Slow And Strady Wins The Race";
		System.out.println(str.charAt(5));
		
		int[] alpha = new int[26];
		
//		for(int i = 0; i<str.length(); i++) {
//			for(int j = 0; j<alpha.length; j++) {
//				if(str.charAt(i) == j+97) {
//					alpha[j] ++;
//				}
//			}
//		}
//		
//		for(int i=0; i<alpha.length; i++) {
//			System.out.print((char)(i+97) + ":" + alpha[i] + "\n");
//		}
		
		System.out.println("----");
		
		//문자열 개수 length는 ()
		for(int i=0; i<str.length(); i++) {
			ch = str.charAt(i);
//			System.out.println(ch+":" + (int)ch); // 아스키 코드값 출력
			if(ch>='A' && ch<='Z') { // 대문자?
				alpha[ch-65] ++;
			}
			
			if(ch>='a' && ch<='z') // 아스키코드 범위를 적어주어서  ch != ' ' 의 공백 조건안줘도 된다
				alpha[ch-97] ++;
		}//for
		
		//배열의 개수 length는 괄호X
		for(int i=0; i<alpha.length; i++) {
			System.out.println((char)(i+97) + ":" + alpha[i]);
		}
		
		
	}

}
