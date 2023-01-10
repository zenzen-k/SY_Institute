
public class Ex07_01 {
	public static void main(String[] args) {
		
		//모든 예외들에게는 이름이 있음.
		String str = null; // 변수는 try 밖으로 빼는게 좋은편임
		
		/* java.lang 패키지안에 NullPointerException 라는 클래스가 있다. 
		 * 예외가 발생하면 new NullPointerException() 라는 클래스 객체가 갑자기 만들어짐 (자동)
		 * -> 예외와 관련된 클래스 객체. 여기서는 NullPointerException 임. 
		 * */
		
		int[] arr = new int[5];
		
		
		try {
			System.out.println(str);
			System.out.println(str.length());
			// new NullPointerException()

			arr[0]=10;
			arr[4]=10;
			arr[5]=50;
			//new ArrayIndexOutOfBoundsException()
						
			// 예외 발생 시 그 시점에서 바로 catch로 넘어간 뒤, finally로 가기 때문에 위에 줄에서 예외가 발생하면 하하하는 실행하지 않는다.
			System.out.println("하하하"); 
			
//			NullPointerException e = new NullPointerException()
		} catch (NullPointerException e) { // 예외가 발생되면 알아서 여기루 옴. (예외발생X -> 안옴)
			// 자동으로 넘어온 객체를 가지고 catch에 넘어온다.
			// 따라서 해당 예외 타입으로 변수를 만들어줘야 한다!!!
			System.out.println("예외발생함1");
			System.out.println("e:" + e);
			// e:java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
			// e 변수 안에 들어감! 보통 객체를 만들면 참조값이 들어가지만, 
			// 여기서는 왜 에러가 발생했는지, 어떤객체가 만들어졌는지 등의 정보가 들어간다.
			
		} 
		//즉, try와 finally는 한번만 작성 가능하고, catch는 여러번 작성 가능하다.
		catch(ArrayIndexOutOfBoundsException e) {
		//ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException
			System.out.println("예외발생함2");
			System.out.println("e:" + e);
		}
		
		
		finally { // 예외가 발생되지 않아도 오는 영역! 무 조 건 !, 작성하지 않아도 된다.
			System.out.println("finally 영역");
			System.out.println("여기는 무조건 처리됨");
		}

		System.out.println("예외처리");
	}

}
/*
try {
	예외발생 가능성이 있는 코드
}catch() {
	발생된 예외를 처리한다.
}finally {
	무조건 온다.(예외가 발생하던 안하던)
}
*/