
public class Ex09_07_Wrapper {

	public static void main(String[] args) {
		// 기본자료형 크기순 : boolean, byte, char, short, int, float, double, long
		
		// 기본형 데이터를 객체로 만들기 위한 클래스이다.
		//Integer : 정수를 표현하는 클래스
		Integer it1 = new Integer(11); // int(11) 
		Integer it2 = 12; // 12 -> new Integer(12) 자동으로 바뀐다. : autoboxing
		System.out.println(it1+it2);
		
		int it3 = new Integer(21);
		int it4 = new Integer(21); // new Integer(21) -> 21 : unboxing
		System.out.println(it3+it4);
		
		
		double d1 = 1.1;
		Double d2 = new Double(1.1);
		Double d3 = 1.1; //autoboxing
		double d4 = new Double(1.1); // unboxing
	
		// 문자열의 숫자를 정수로 바꿔준다.
		int i = Integer.parseInt("100"); // static 메서드라서 클래스이름.메서드이름()으로 호출할 수 있다.
		int j = Integer.parseInt("200");
		
		System.out.println("100"+"200"); // 100200
		System.out.println(i+j); // 300
		
		Integer i2 = Integer.valueOf("100");
		Integer j2 = Integer.valueOf("200");
		System.out.println(i2+j2); // 300
		
		
		
		
		double d5 = Double.parseDouble("1.1");
		double d6 = Double.parseDouble("2.2");
		
		System.out.println(d5 + d6);
	}

}
