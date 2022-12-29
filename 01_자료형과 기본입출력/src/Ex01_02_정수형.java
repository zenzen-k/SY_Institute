
public class Ex01_02_정수형 {
	public static void main(String[] args) {
		System.out.println(1+2);
		//변수 : 데이터를 보관하는 저장소
		
		/* 정수형 자료형(Type) */
		/* byte : 1byte, -128 ~ 127
		 * short : 2byte, -32,768 ~ 32,767
		 * int : 4byte, -2,147,483,648 ~ 2,147,483,647
		 * long : 8byte, -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 */
		//integer(정수)
		//초기화는 선언이 이루어진 후에 해야함
		int a;	//선언
		int b;
		//int a,b;
		//int a=1; (선언과 동시에 초기화)
		a = 1;	//초기화
		b = 2;
		System.out.println("a+b");
		System.out.println(a+b);
		
		//Duplicate 중복
		//byte a; 자료형이 달라도 변수명이 같으면 중복으로 사용 불가능. 변수명을 다르게 해주어야함.
		byte b1=10;	//변수명은 숫자로 시작X , 영문자,언더바로 시작가능함, 앵간하면 영문자,숫자,언더바(_)사용해주는게 좋음
		byte b2=20;
		int b3;
		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		//System.out.println(b3); -> initialized. 초기화가 안 되었다는 에러가 뜬다.
		//b3 = b1+b2; 
		//byte나 short, char 같은 int형보다 작은 데이터들은 연산에서 int형으로 자동형변환(promotion)이 되므로 현재 byte형인 b3을 int형으로 형변환해주어야 int형 결과를 담을 수 있음
		//b3을 int형으로 묵시적형변환(자동형변환)해줌 - 27번줄
		b3 = b1+b2;
		System.out.println("b3: " + b3);
		System.out.println("b1+b2=" + b1+b2);	//문자열 뒤의 + 기호는 연달아서 출력하라는 것으로 인식해버림. 따라서 연산의 의미로 처리하려면 ()를 이용하여 우선순위를 주어야함
		System.out.println("b1+b2=" + (b1+b2));

		int c = 1000000;
		int d = 2000000;
		long result = (long)c*d; //2조. 강제 형변환을 해주었음 -> long * int 가 됨. 계산결과가 둘중에 더 큰 자료형으로 저장함!
		System.out.println(result);	//다른 계산 결과가 출력. int * int 는 결과가 int. 2조라는 결과는 int에 담을 수 없기 때문에 다른 결과가 result변수에 들어감
		//따라서 c나 d 둘중에 하나를 잠시 long으로 강제형변환(casting)을 해주면 됨 - 40번줄
		//데이터에 맞는 자료형을 선언하는 것도 중요하지만, 계산도 올바르게 할 수 있도록 하는 것도 매우 중요하다!!
		
		//syso + ctrl + space : 빠른 작성 ( ctrl + space : 자동입력 )
		System.out.println();	//아무것도 출력하지 않고 엔터
		//System.out.println(w); -> w cannot be resolved to a variable : w 변수를 선언하지 않았다는 에러메세지
		System.out.println("result: " + result);	//"" : 문자열,	+ : 연속해서 출력
		
	}
}
