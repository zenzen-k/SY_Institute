
public class Ex09_03_String {

	public static void main(String[] args) {
		
		int a ;
		double b;
		String c; // 특이한 자료형, String은 클래스이다.
		
//		String s1 = "Have a nice day";
//		String s2 = "Have a nice day";
//		
//		System.out.println("s1:"+s1);
//		System.out.println("s2:"+s2);
//		
//		System.out.println(s1 == s2); // true
		//이렇게 만든다면 아까와 같은 문자일 때 주소를 또 만들지 않고 s1과 같은 주소를 s2에 넣게 된다.
		
		// 아래가 원래 작성 방법이나, 아주 많이 사용하는 클래스 이므로 위처럼 작성할 수 있도록 만들어졌다.
		// 위와의 차이점이라면 new를 할때마다 새로운 공간이 만들어져서 주소의 번지가 달라서 두개의 참조비교를 한다면 false가 출력된다.
		String s1 = new String("Have a nice day");
		String s2 = new String("Have a niCe day");
		String s3 = "hahaha"; // 리터럴 표현법
		
		System.out.println(s1 == s2); // false
		
		// 공백 포함 문자열의 길이
		System.out.println(s1.length());
		int len = s1.length();
		System.out.println(len);
		
		//Object는 equals를 가지고 있으므로 String클래스는 equals를 사용할 수 있다.
		// 하 지 만 String에는 equals메서드를 오버라이딩을 하여서 주소비교가 아닌 문자열을 비교하는 것으로 오버라이딩 되어 있다.
		boolean result1 = s1.equals(s2);
		System.out.println(result1);
		
		if(result1 == true) {
			System.out.println("두 문자열 같음");
		} else {
			System.out.println("두 문자열 같지 않음");
		}
		
		
		
		//equalsIgnoreCase 는 대소문자 무시하고 비교를 한다.
		result1 = s1.equalsIgnoreCase(s2);
		System.out.println(result1);
		
		//compareTo는 두개의 문자열을 비교하여 처음으로 달라진 시점의 아스키코드값 차이를 리턴한다. 
		// c(99) -> C(67) = 32 출력
		// C(67) -> c(99) = -32 출력
//		int result2 = s1.compareTo(s2);
		int result2 = s1.compareToIgnoreCase(s2);
		System.out.println(result2);
		
		//응용.
		if(result2 == 0) {
			System.out.println("두 문자열 같음");
		} else {
			System.out.println("두 문자열 같지 않음");
		}
		
		System.out.println("=====================");
		
		System.out.println(s1.concat(s3));
		System.out.println(s1 + s3);
		
		// 찾는 문자열의 위치를 찾는 메서드다.
		int result3 = s1.indexOf("nice");
		// s1 = "Have a nice day"가 있었음.
		// 0부터 시작함!!!!! 따라서 0부터 시작했을때 nice의 첫번째인 n이 몇번째에 있는지를 찾는다.
		// 찾지 못하면 -1을 출력한다.
		System.out.println(result3); // 7
		
		// 찾는 문자열을 뒤에서부터의 위치를 찾는 메서드다.
		result3 = s1.lastIndexOf('a'); // 97에 해당하는 문자를 찾는다. -> a
		System.out.println(result3); // 13 (day의 a를 출력한다.)
		
		System.out.println("=====================");
		
		// 문자열의 일부를 가져올때 사용하는 메서드
		// 3번부터 9번의 앞까지 출력
		// Have a nice day
		// 0123456789 - > 3~ 8출력함. 
		String result4 = s1.substring(3, 9);
		System.out.println(result4); // e a ni

		result4 = s1.substring(7); // 해당 위치부터 끝까지 가져오는 메서드.
		System.out.println(result4); // nice day
		
		
		// 문자(char)를 바꾸는 메서드
		result4 = s1.replace('a','x');
		System.out.println(result4);
		
		
		System.out.println("=====================");
		
		// Object의 toString()을 오버라이딩 했음.
		// 원래는 주소가 나오지만 String은 문자열을 출력할 수 있도록 함.
		result4 = s1.toString();
		System.out.println(result4);
		System.out.println(s1);
		System.out.println(s1.toString());
		
		// 문자열의 모든 문자를 소문자로 바꿔준다.
		result4 = s1.toLowerCase();
		System.out.println(result4);
		
		result4 = s1.toUpperCase();
		System.out.println(result4);
		
		// s1이 "ce"를 포함하고 있니?
		System.out.println(s1.contains("ce"));
		
		String s5 = "    abc de daF WF    ";
		System.out.println(s5.length()); // 공백포함
		
		String s6 = s5.trim(); // 문자열 앞 뒤의 공백 제거
		System.out.println(s6);
		System.out.println(s6.length());
		
		// 이 위치의 문자를 가져와라. indexOf와 비슷
		char ch = s1.charAt(2);
		System.out.println(ch); // v
		
		String fullName = "Hello.java"; // a.txt, b.jpg
		String fileName = fullName.substring(0,fullName.indexOf(".")); // Hello 파일명
		String ext = fullName.substring(fullName.indexOf(".")+1); // java 확장자
		
		
		System.out.println("화일명:" + fileName);
		System.out.println("확장자:" + ext);
	}

}
