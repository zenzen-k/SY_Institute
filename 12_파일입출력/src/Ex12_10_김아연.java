import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex12_10_김아연 {
	public static void main(String[] args) throws IOException { // 예외처리! main을 호출한 곳으로 예외를 던진다. -> 
		// 슬래시 똑같이 들어감! 단어랑 뜻 voca.txt에 저장
		// 공백도 넣을 수 있게 함~ apple pie/사과 파이 처럼
		// 3. 프로그램종료합니다도 출력해쥬기
		Scanner sc = new Scanner(System.in);
		FileWriter fw;
		BufferedWriter bw = null;
		FileReader fr;
		BufferedReader br = null;
		String str;
		boolean flag = false;

		while (true) {
			System.out.print("1.단어입력 2.단어검색 3.종료");
			System.out.print(">>");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.print("단어/뜻 입력>>");
				// 키보드 입력은 바이트 입력이므로 문자입력으로 바꾸고 버퍼를 사용해서 속도를 빠르게함.
				br = new BufferedReader(new InputStreamReader(System.in));
				str = br.readLine();
				// 파일 출력
				fw = new FileWriter("voca.txt", true);
				// 입력한br을 voca파일에 작성하기 위해 객체를 만들고 true를 사용함으로써 계속 뒤에 붙여넣기 하려함
				bw = new BufferedWriter(fw); // 입력한 애플파일 str을 voca에 작성하기 위한 연결다리!!
				bw.write(str + "\n"); // bw에 내가 입력한 단어를 출력하는 것.
				// bw.write("\r\n");
				// bw.newLine();

				bw.flush(); // 버퍼에 저장된 데이터를 voca파일에 보낸다!
				break;

			case 2:
				System.out.print("검색 단어 입력>>");
				// 키보드 입력
				br = new BufferedReader(new InputStreamReader(System.in));
				str = br.readLine(); // 검색할 단어
				// 파일 읽어오기
				fr = new FileReader("voca.txt"); // 파일객체
				br = new BufferedReader(fr); // 입력받은 파일을 읽어오기 위한 연결다리
				// br에서 읽는다는것은 결국 fr에서 읽는다는 소리
				
				// EOF를 만날때까지 한줄씩 읽어온다!. 
				flag = false;
				String line;
				while ((line = br.readLine()) != null) {
					// 내가 한 방식
//					if (str.equals(line.substring(0, line.indexOf("/")))) {
//						String a = line.substring(line.indexOf("/") + 1);
//						System.out.println("단어>" + str);
//						System.out.println("단어의 뜻>" + a);
//						flag = true;
//						break;
//					}
					// 강사님이 한 방식
					String[] token = line.split("/"); // 구분자를 기준으로 방 2개짜리 배열에 sky , 하늘이 들어간다.
					if(token[0].equals(str)) {
						System.out.println("단어>" + str); // str대신 token[0]을 입력해도 된다. 
						System.out.println("단어의 뜻>" + token[1]);
						// 구분자를 기준으로 방 2개가 생기니까 앞에 0번방은 sky, 1번방은 하늘 이 들어간당!
						flag = true;
						break;
					}
				}
				// 처리할 문장이 한줄일떈 안묶어도 됨
				if (!flag) {// flag가 false일때 !를 만나서 부정이 되어 true가 된다.
							// true일때는 false가 되니까 문장실행 X
					System.out.println("찾는 단어 없음"); 
					}
				break;

			case 3:
				System.out.println("프로그램을 종료합니다.");
				
				// 연결다리가 형성되었다면 닫겠다!
				if(bw != null)
					bw.close();
				if(br != null)
					br.close();
				System.exit(0); // 0은 정상종료, 1은 강제종료
			} // switch
		} // while
	} // main 메소드
}
