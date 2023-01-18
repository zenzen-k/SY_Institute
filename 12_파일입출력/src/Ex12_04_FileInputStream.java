import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex12_04_FileInputStream {
	public static void main(String[] args) throws FileNotFoundException, IOException { 
		// 호출한 곳으로 예외를 던지는데, main에서 호출했다면 JVM이 예외를 처리한다.
		
		// "작업대상을 객체로 만듬."
		File f = new File("c:\\sun\\abc.txt");
		
		// 해당 파일을 읽어오려면 자바파일과 해당 위치에 있는 파일을 연결해줄것이 필요하다.
		// 즉, 이 연결다리를 스트림 이라고 하며 FileInputStream을 사용한다.
		// "스트림 형성을 했다" 라고 말함.
		FileInputStream fis = new FileInputStream(f);
//		FileInputStream fis = new FileInputStream("c:\\sun\\abc.txt"); // 직접 넣어도 된다.
		
		while(true) {
			int i = fis.read(); // 한개만 읽는다. 읽은 단어를 아스키코드로 바꾼다.
			if(i == -1) // 아무것도 없으면 -1이 나옴.
				break;
			
			System.out.println(i + " : " + (char)i);
		} // while
		
		fis.close();
	}
}

// EOF (End Of File) 파일의 끝이다 라는 상태가 파일 마지막에 들어가 있다.
// 예를들어 abc.txt 파일의 마지막에는 눈에 보이지 않지만 EOF정보가 있고,
// read에서 이 EOF를 읽으면 -1이 들어간다.