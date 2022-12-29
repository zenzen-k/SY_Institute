
public class Ex02_03_증감 {

	public static void main(String[] args) {
		
		int a=5, aa;
		
		System.out.println("a=" + a);
		/*a의 1증가 연산*/		// a=a+1;  a+=1;  a++;
		++a;	 //이러한 단독사용은 연산자가 앞에 있나 뒤에 있나 차이가 없다
		System.out.println("a=" + a);
		
		/*전위연산자*/
		a=5;
		System.out.println("a=" + a);
		aa = ++a;
		System.out.println("a=" + a + ", aa=" + aa);
		//a의 값을 '먼저'증가 후에 aa에 대입함
		
		/*후위연산자*/
		a=5;
		System.out.println("a=" + a);
		aa = a++;
		System.out.println("a=" + a + ", aa=" + aa);
		//a의 값을 aa에 대입 하고 '나중에' 증가
		
		
		/*감소 연산*/
		/*전위연산자*/
		a=5;
		System.out.println("a=" + a);
		aa = --a;
		System.out.println("a=" + a + ", aa=" + aa);
		//먼저 a를 감소한 뒤에 aa에 대입
		
		/*후위연산자*/
		a=5;
		System.out.println("a=" + a);
		aa = a--;
		System.out.println("a=" + a + ", aa=" + aa);
		//a를 aa에 대입한 후에 a가 감소

		
		int i = 10;
		
		System.out.println(i);
		System.out.println(i++);	//출력 먼저 하고 증가함. 출력:10 , 데이터:11
		System.out.println(++i);	//증가를 하고 출력함. 출력:12 , 데이터:12
		System.out.println(++i);	//증가를 하고 출력함. 출력:13 , 데이터:13
		System.out.println(i++);	//출력을 하고 증가함. 출력:13 , 데이터:14
		System.out.println(i);		//출력함. 출력:14, 데이터:14
		
		i = 10;
		
		System.out.println(i);		//출력함. 출력:10, 데이터:10
		System.out.println(i--);	//출력 먼저 하고 증가함. 출력:10 , 데이터:9
		System.out.println(--i);	//증가를 하고 출력함. 출력:8 , 데이터:8
		System.out.println(--i);	//증가를 하고 출력함. 출력:7 , 데이터:7
		System.out.println(i--);	//출력을 하고 증가함. 출력:7 , 데이터:6
		System.out.println(i);		//출력함. 출력:6, 데이터:6
	}

}
