import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex12_05_FileInputStream {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("from.txt"); // 읽어들일 수 없는 파일은 에러가 뜨므로 미리 만들어두어야 한다.
//			fos = new FileOutputStream("to.txt"); // 작성할 파일은 미리 안만들어놔도 자동으로 생긴다.
//			fos = new FileOutputStream("to.txt",false);
			// false : 파일이 없으면 파일 자동생성. 기본값이다.
			// 파일이 존재하고, 미리 만들어진 파일에 다른 글이 작성되어 있다면, 내용이 초기화 되고 새로 생성이된다.

			fos = new FileOutputStream("to.txt", true);
			// true : 파일이 없으면 파일 자동생성
			// 파일이 존재하면 원래 있던 글에 텍스트를 추가로 작성한다.

			while (true) {
				int i = fis.read();
				if (i == -1) // 먼저 빠져나갈 수 있게 해야 EOF까지 문자로 출력이 안되고 바로 종료되니까 위에 작성해주는게 좋음
					break;

				System.out.print((char) i);

				fos.write(i);

			} // while

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {

			}
		}

	}
}
