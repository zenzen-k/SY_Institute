import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex12_10_김아연 {
	public static void main(String[] args) throws IOException {
		// 슬래시 똑같이 들어감! 단어랑 뜻 voca.txt에 저장
		// 공백도 넣을 수 있게 함~ apple pie/사과 파이 처럼
		// 3. 프로그램종료합니다도 출력해쥬기
		Scanner sc = new Scanner(System.in);
		FileWriter fw;
		BufferedWriter bw;
		FileReader fr;
		BufferedReader br;
		String str;
		boolean flag = false;
		
		while(true) {
			System.out.println("1.단어입력 2.단어검색 3.종료");
			System.out.print(">>");
			int input = sc.nextInt();
			switch(input) {
			case 1 : 
				System.out.print("단어/뜻 입력>>");
				br = new BufferedReader(new InputStreamReader(System.in));
				str = br.readLine();
				// 파일 출력
				fw = new FileWriter("voca.txt",true);
				bw = new BufferedWriter(fw);
				bw.write(str+"\n");

				bw.close();
				break;
				
			case 2 : 
				System.out.print("검색 단어 입력>>");
				br = new BufferedReader(new InputStreamReader(System.in));
				str = br.readLine();
				// 파일 읽어오기
				fr = new FileReader("voca.txt");
				br = new BufferedReader(fr);
				
				String n;
				while((n = br.readLine()) != null) {
					flag = false;
					if(str.equals(n.substring(0,n.indexOf("/")))) {
						String a = n.substring(n.indexOf("/")+1);
						System.out.println("단어>"+str);
						System.out.println("단어의 뜻>"+a);
						flag = true;
						break;
					}
				}
				if(flag == false) {
					System.out.println("찾는 단어 없음");
				}
				br.close();
				break;

			case 3 : 
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			if(input == 3) {
				break;
			}
		}
		
		
		
	} // main
}
