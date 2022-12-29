
public class Ex01_03_문자형 {
	public static void main(String[] args) {	
		System.out.println(1);
		//character (문자)
		char ch = 'B';	//char형 변수에 문자를 넣을 때에는 반드시 작은 따옴표를 사용해야 함. '' : 한개의 문자 , "" : 문자열
		System.out.println(ch);
		System.out.println("ch=" + ch + "입니다");
		// 모든 문자마다 각자의 고유 숫자값이 있다. ->아스키코드 라고 함.
		System.out.println(ch + 1);	// 'B' + 1 -> char + int = int , 2byte + 4byte = 4byte. int형으로 자동 형변환된다.
		System.out.println(67);
		System.out.println((char)(ch+1));	// 결과값인 67에 해당하는 문자 C가 출력된다.
		System.out.println((char)67);	//위와 동일
		/* 아스키코드 
		A : 65
		B : 66
		a : 97
		b : 98  */
		
		/* */
		System.out.println('B'+1);	// 67
		System.out.println("B"+1);	// B1
		System.out.println((char)('B'+1));
		
		ch=66;	//숫자를 넣어도 된다. 66에 해당하는 문자 B가 들어감.
		System.out.println(ch);
		
		long k=10000000000L;	//10의 숫자를 넣게되면 int형으로 본다. int형 이상의 숫자는 long형임을 나타내주어야 하기 때문에 맨 뒤에 L을 작성하여 long형 데이터임을 나타냄	
		
		
	}
}