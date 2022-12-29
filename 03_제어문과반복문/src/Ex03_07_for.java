import java.util.Scanner;

public class Ex03_07_for {

	public static void main(String[] args) {
		/* for문의 형식
		for(초기식;조건식;증감식) {
			반복할문장1;
			반복할문장2;
		} */
		
		//조건식이 거짓이 되기 전까지 계속 문장을 반복하여 실행한다.
		//닫는 괄호를 만나면 증감식으로 가서 i를 증가시킴.
		//그리고 조건식이 참이면 중괄호 안으로~ 거짓이면 중괄호를 빠져나옴
		int i;
		for(i=1; i<=5; i++) {
			System.out.println("자바:" + i);
		}
		System.out.println("for문 밖:" + i);
		 
		System.out.println("--------------");
		
		
		for(i=1; i<=10; i++) {	//증감식은 i=i+1 이렇게 해도 된다. 
			System.out.println("i=" + i);
		}
		
		System.out.println();
		//1~10까지의 수 중 2의 배수 출력
		for(i=2; i<=10; i=i+2) {	//1~10까지의 수 중 2의 배수 출력
			System.out.println("i=" + i);
		}
		
		System.out.println();
		//1~10까지의 수 중 2의 배수 출력
		for(i=1; i<=10; i++) {	//for문 안에도 if문을 사용할 수 있다.
			if(i%2==0) {
				System.out.println("i=" + i);
			}//if
		}//for
		
		
		System.out.println("--------------");
		
		
		// 1+2+3+4+5+6+7+8+9+10
		int sum = 0+1+2+3+4+5+6+7+8+9+10;
		System.out.println("sum="+sum);
		
		sum = 0;
		sum = sum+1; //1
		sum = sum+2; //3
		sum = sum+3; //6
		sum = sum+4; //10
		sum = sum+5; //15
		sum = sum+6; //21
		sum = sum+7; //28
		sum = sum+8; //36
		sum = sum+9; //45
		sum = sum+10; //55
		System.out.println("sum="+sum);
		
		sum = 0;
		for(i=0; i<=10; i++) {	//i<11
			sum += i;	//복합대입연산자
		}
		System.out.println("sum="+sum);
		
		sum =0;
		//1부터 1000까지 합계 구하기
		for(i=1; i<=1000; i++) {
			sum += i;
		}
		System.out.println("sum="+sum);
		
		
		System.out.println("===========");
		
		//1-100사이의 수 중 5의 배수이면서 7의 배수를 출력
		System.out.print("5와 7의 배수는 ");
		for(i=1; i<=100; i++) {
			if(i%5==0 && i%7==0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("입니다.");
		System.out.println("===========");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("단입력:");
		int dan = sc.nextInt();
		
		for (i = 1; i < 10; i++) {
			System.out.println(dan + "*" + i + "=" + (dan * i));
		}

	}

}
