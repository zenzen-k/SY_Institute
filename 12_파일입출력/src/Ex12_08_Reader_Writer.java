import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex12_08_Reader_Writer {
	public static void main(String[] args) {
		// FileOutputStream 작성
		
		FileWriter fw = null;
		FileReader fr = null;
		
		try {
			/* 스트림형성 */
			fw = new FileWriter("write.txt"); // , false가 생략.-> 새로 만들어짐 이미 있다면 초기화하고 다시 만들
														// true -> 덧붙여짐. (어제 했던거랑 동일함)
			fw.write("재미있는 자바수업!"); // 쓰기만 한다고 txt파일에 나오는게 아니다.
			fw.flush();
			
			fr = new FileReader("write.txt"); // 파일이 없으면 에러뜸. -> FileNotFoundException
			// FileNotFoundException 예외를 IOException이 잡아준다. 즉 더 큰 클래스(부모클래스)임을 알 수 있음
			// (catch로 추가해도 ㄱㅊ긴한데 해줄라믄 IOException이거 전에 해줘야함. 
			// IOException이 다 잡을 수 있어서 도달할 수 없는 예외라고 뜨기 때문엥!!!! )
			int i;
			while((i = fr.read()) != -1) { // 읽어온 값이 -1이 아닐때까지 반복! EOF를 만나면 -1 출력함!
				System.out.print((char)i);
//				System.out.print((char)fr.read()); // 얘는 왜 이상하게 나올까,,, ?
				// -> 조건문에서 재 읽고 다음거 출력이라 미 출력함 . 즉 한번만 읽어들여야 하기 떄문에 i변수에 넣고 출력하는것임!
			}
			
		} catch (IOException e) {
			// 어제는 FileOutputStream작성할 때 FileNotFoundException예외처리를 해주었었다. 
			// 어제의 바이트 스트림 작성때와 같은 이유다. 경로를 작성했을 때 폴더가 없을 때 IOException이 발생한다.(FileWriter)
			e.printStackTrace();
		} finally {
			try {
				fw.close(); // 이렇게 닫아주어야됨, 또한 닫고 나면 더 이상 작성이 불가능하다.
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
	} // main
}

/*
 * <왜 파일 입력은 되었는데 콘솔창에 출력이 안된걸까?>
 * fw.close 또는 fw.flush를 해야만 파일에 기록이 된다.
 * 하지만 위의 코드에서 읽어들인 후, 마지막에 close를 해주었기 때문에 파일에 기록이 완성되지 않은 상태에서 읽어들이려고 하니
 * 파일에는 EOF인 상태이므로 읽어들일것이 없어서 console창에 아무것도 출력되지 않은 것이다. !
 * 따라서 17번째 줄에 fw.flush를 작성하여 중간에 입력된 값을 파일로 내보내주어야 fr.read로 읽어올 수 있다 ! 
 */