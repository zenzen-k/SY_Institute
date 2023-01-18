import java.io.File;

public class Ex12_01_File {

	public static void main(String[] args) {

		File f1 = new File("c:\\sun\\abc.txt"); // abc.txt 파일을 추가. 경로작성. 윈도우에서는 파일 구분자가 \ 이다. 리눅스 - /
//		File f2 = new File();

		// 어느 운영체제에서 돌리던간에 거기에 맞는 구분자를 사용할 수 있도록 해줌. 즉, 자동으로 현재 운영체제에 맞는 구분자로 작성해준다.
		String a = File.pathSeparator;
		char b = File.pathSeparatorChar;
		String c = File.separator;
		char d = File.separatorChar;

		File f2 = new File("c:" + File.separator + "sun" + File.separator + "abc.txt");

		System.out.println("a:" + a); // ";"
		System.out.println("b:" + b);
		System.out.println("c:" + c); // "\"
		System.out.println("d:" + d); // '\'

		File f3 = new File("c:\\Sun", "abc.txt"); // 폴더와 파일을 2개로 나눠서 작성 가능
		File f4 = new File("c:\\sun"); // 폴더만 가지고는 길이를 구할 수 없음!
		File f5 = new File(f4, "abc.txt"); // 이렇게 자주 사용하는 폴더만 만들어놓고(f4) 사용할 수 있당!

		System.out.println(f1.length());
		System.out.println(f2.length());
		System.out.println(f3.length());
		System.out.println(f5.length());
		// 엔터는 그줄의 맨 앞으로 갔다가 그 밑으로 커서를 내린다. 따라서 length 에 2가 추가됨.
		// 한글은 하나당 3자리를 차지함. / 영어나 숫자는 한자리를 차지함.
		// 없는 파일의 길이를 구하라고 작성하면 0이 출력된다.
	}

}
