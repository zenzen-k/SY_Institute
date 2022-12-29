
public class Ex01_06_출력문 {
	public static void main(String[] args) {	//main 입력 후 ctrl + space 입력하면 자동완성!
		
		/*기본자료형*/
		int a = 123;
		char b = 'A';
		float c = 98.765f;
		/*문자열자료형*/
		String d = "아이유";
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
		System.out.println();
		
		/* 서식문자 : %d, %c, %f ... */
		System.out.printf("a=%d\n",a);	//%d : 출력할 정수형 변수의 값. \n : 줄바꿈
		System.out.printf("a=%5d\n",a);	//%5d : 5칸을 잡고 a변수를 출력함. 자릿수를 지정. 앞에 2자리가 공백처리 됨
		System.out.printf("b=%c\n",b);	//%c : 출력할 문자형 변수의 값.
		System.out.printf("b=%d\n",(int)b);	//정수형으로 강제 형변환(int) 후 출력(%d).
		System.out.printf("c=%f\n",c);	//%f : 출력할 실수형 변수의 값. 컴퓨터는 실수계산을 완벽하게 하지 못하기 때문에 약간의 계산 오차가 있을 수 있음 -> c=98.764999
		System.out.printf("c=%.2f\n",c);//%.2f : 소수점 2자리까지의 값을 반환함. 
		System.out.printf("c=%10.2f\n",c);	//10칸을 잡고 소수점 2자리까지의 값을 반환함. -> c=     98.76
		System.out.printf("d=%5s\n",d);	//%s : 문자열 출력
		
		System.out.println("안녕\\하세요\t\t 저의 이름은\n \"아이유\"입니다.");	//\t : tab만큼 떨어짐. \\ : 역슬래시 출력. \" : 따옴표 출력
		System.out.println("안녕하세요 저의 '이름'은 아이유입니다.");	// 작은 따옴표는 상관없음 !
		
		System.out.printf("안녕하세요 저의 이름은 %s입니다.\n혈액형은 %c형입니다.",d,b);
		
		
	}
}
