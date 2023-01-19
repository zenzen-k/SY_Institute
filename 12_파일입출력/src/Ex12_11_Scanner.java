import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex12_11_Scanner {
	public static void main(String[] args) throws FileNotFoundException {
		// 그동안 사용했던 Scanner의 생성자는 Scanner(InputStream source) 였음.
		// System.in은 InputStream타입!!!
//		Scanner sc = new Scanner(System.in);

		// 생성자를 보면 파일객체를 넘길수도 있다.
//		Scanner sc = new Scanner(new File("file.txt")); //FileNotFoundException
		Scanner sc = new Scanner(new File("file.txt")).useDelimiter(","); // useDelimiter 쉼표(,)를 구분자로 끊어 낸다.
		int num, sum = 0, i = 0;
		while (sc.hasNextInt()) {
			num = sc.nextInt();
			sum += num;
			System.out.println(num);
			i++;
		}
		System.out.println("sum:" + sum);
		System.out.println("avg:" + (double)sum / i);
	} // main
}
