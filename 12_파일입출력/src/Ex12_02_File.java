import java.io.File;

public class Ex12_02_File {
	public static void main(String[] args) {

		File win = new File("c:\\windows\\");
		System.out.println("win : " + win); // win : c:\windows 출력. -> toString()이 오버라이딩 되어있다.
		
		// 디렉토리 = 폴더/ win변수가 가지고 있는것이 폴더인지 참 거짓을 boolean 형으로 리턴
		boolean result1 = win.isDirectory();
		System.out.println("result1 : " + result1);
		
		// 조건식?참:거짓
		String result2 = win.isDirectory() ? "폴더" : "파일" ; // 폴더나 파일을 변수값에 담을 것이니 변수의 자료형은 String이다.
		System.out.println("result2 : " + result2);
		
		result2 = win.isFile() ? "파일" : "폴더" ;
		System.out.println("result2 : " + result2);
		
		// win변수의 목록
		String[] lists = win.list();
		System.out.println(lists.length);
		
		
		for(int i = 0 ; i<lists.length; i++) {
			File kind = new File(win, lists[i]);
			if(kind.isDirectory()) { // lists.indexOf(".") == -1 이런 신박한 방법도 있다
				System.out.println("폴더 : " + lists[i]);
			}
			else {
				System.out.println("파일 : " + lists[i]);
			}
		} // for
		
	}// main
}
