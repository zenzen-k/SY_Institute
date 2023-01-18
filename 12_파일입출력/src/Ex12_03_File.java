import java.io.File;
import java.io.IOException;

public class Ex12_03_File {
	public static void main(String[] args) {

		File f1 = new File("A"); // 확장자가 없으니 폴더!
		// File f1 = new File("C:\\java_zen\\12_파일입출력\\A");
		// 어느 드라이브 어느 파일인지 안쓴다면 자동으로 현재 작업중인 파일 위치로 된다.
		// 따라서 현재 위치를 대상으로 하고 싶다면 굳이 위치작성 없이 폴더나 파일만 작성하면 된다.
		File f2 = new File("B");
		File f3 = new File("C");
		File f4 = new File(f1, "aa.txt"); // C:\java_zen\12_파일입출력\A\aa.txt 라는말

		// 현재 없는 폴더로 객체를 만들었음..
		// f1이 존재하는지 boolean으로 리턴함
		boolean result = f1.exists();
		System.out.println("result:" + result);

		if (f1.exists()) {
			f1.renameTo(f2); // ()안에 파일 객체를 넣어야 한다.
		} 
		else {
			f1.mkdir(); // 폴더를 만드는 메서드
			System.out.println("폴더 생성함");
			try {
				f4.createNewFile();
				System.out.println("파일 생성함");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//else
		
		if(f3.exists()) {
			f3.delete(); // 삭제하는 메서드. 지워졌다면 true, 지우지 못했다면 false 를 리턴한다.
			// 존재하지 않을때 지워도 에러는 안나지만 안전하게 if문안에 존재하면 지우는걸로 해주는게 좋음
			// 또한 폴더 안에 폴더나 파일들이 있다면 삭제되지 않는다.
		}
		
		
	} // main
}
