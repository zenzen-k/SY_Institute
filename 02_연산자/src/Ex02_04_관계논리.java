
public class Ex02_04_관계논리 {

	public static void main(String[] args) {
		
		int a =20, b=20;
		
		// 관계 연산자 :< > <= >=
		boolean c = a<=b;	
		System.out.println("c:" + c);
		System.out.println("c:" + (a<b));
		System.out.println(a==b);	//같으면 참
		System.out.println(a!=b);	//같지않으면 참
		
		// 논리 연산자 : &&(and.모두 참일때만 참) ||(or. 하나라도 참이면 참) !(not. 부정. 결과를 반대로)
		c = a>10 && b>10;
		System.out.println("c:" + c);
		
		c = a>100 || b>10;
		System.out.println("c:" + c);
		
		c = !(a>100);	//20>100
		System.out.println("c:" + c);
		
		/*
		AND 연산자			OR연산자		
		T && T : T			T || T : T
		T && F : F			T || F : T
		F && T : F			F || T : T
		F && F : F			F || F : F
		*/
	}

}
