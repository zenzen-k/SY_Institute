/*글꼴변경 window-prefernces-general
  글자크기 ctrl + - 
  Package Explorer
  소괄호 () 중 {} 대 []
  ctrl + / : 주석 설정 or 해제
  ctrl + shift + / : 영역주석처리
    */


public class Ex01_01_출력문 {
	public static void main(String[] args) {
		//실행 단축키 : ctrl + F11 (안될 때 우클릭 - run as - java Application)
		//ctrl + alt + 방향키 : 복사+붙여넣기 동시에
		//ctrl + d : 라인삭제
		//alt + 방향키 : 라인이동(원하는 방향으로)
		//ctrl + i : 줄맞춤
		
		System.out.println(123); 	//숫자
		System.out.println("123");	//문자
//		System.out.println(가나다);	//error : 문자는 "" 사용해주어야 함.
		System.out.println("가나다");		
		System.out.println("a");
		System.out.println("가나다");
		
		System.out.println("a");
		System.out.println('a');	//한개의 문자는 작은따옴표('')사용 가능	
	}
}