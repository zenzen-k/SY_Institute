import java.util.Scanner;

public class Ex03_06_switch_case {

	public static void main(String[] args) {
		String fruit;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("과일을 입력하세요:");
		fruit = sc.next();
		System.out.println("입력된 과일:" + fruit);
		
		//실수형 변수는 switch에 사용 불가능함.
		/* 정수형 변수나 수식, String 변수 가능 */
		switch(fruit) {
		//문자열은 반드시 "" 안에 넣어줘야함
		//만약 apple case에 출력문과 break가 없다면 banana의 출력문이 수행되면서 break를 만나 switch문을 종료.
		//즉 비워놔도 됨
		case "apple" :	System.out.println("사과");	break;
		case "banana" : System.out.println("바나나");	break;
		case "orange" : System.out.println("오렌지");	break;
		default : System.out.println("그 밖의 과일");	break;
		}
		// 그렇다면 이런것도 생각할 수 있을듯?
		// 1~3은 a를 출력할때 case 1: case 2: case 3: System.out.print("a"); break;
		// 위처럼 하면 1입력 -> a 출력 이렇게 됨 응용해서 사용할 수 있을듯
		sc.close();
	}
}