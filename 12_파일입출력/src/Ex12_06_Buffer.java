import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex12_06_Buffer {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			// 폴더가 있을 때에는 파일이 자동생성.
			// 해당되는 폴더가 없을 때에는 파일을 발견할 수 없음
			// -> FileNotFoundException 이 에러가 뜨므로 예외처리를 해주는 것이다.
			fos = new FileOutputStream("data.txt"); // -> FileOutputStream 1차 스트림 이며, 자동생성. false 생략.

			/* buffer를 만드는 방법! */
			bos = new BufferedOutputStream(fos, 5); // 5개의 사이즈를 지정해줌
			// bos자리에 5개의 자리가 다 차면 fos와 연결된 data.txt에 보낸다.

			for (int i = 1; i < 9; i++) {
				bos.write(i + 48); // 아스키 코드값 1~8 출력이 불가능함.. 따라서 1의 아스키 코드값은 49 이므로 i+48을 작성
				// 5까지의 공간이 다 차면 txt에 데이터를 보냄. (이때 buffer는 깨끗해짐!)
				// 그리고 6, 7, 8을 담는데 아직 공간이 남아서 보내지 않았음.
				// 이것을 bos.close 로 연결을 끊는다면 2차스트림(bos)에 남은 데이터가 다 1차 스트림(fos)으로 보내진다.
				bos.flush(); // 또는 이렇게 작성해서 남은 데이터를 보내도 된다. (이때 close는 작성하지 않아도 됨.)
			}

		} catch (FileNotFoundException e) { // 파일을 발견할 수 없다는 에러
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 반 드 시 !
			try {
				bos.close(); // 2차 스트림을 닫으면, 1차 스트림(fos)까지 알아서 닫힌다.
			} catch (IOException e) {
				e.printStackTrace();
			}

		} // finally

	}

}
