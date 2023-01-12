
public class Ex09_06_StringBuffer {

	public static void main(String[] args) {
		
		String str1 = "Have ";
		String str2 = "a ";
		String str3 = "nice day";
		String str4 = str1 + str2 + str3; // 또 새로운 공간이 생기며 3개를 연결한다.
		// .toString -> 생략. toString은 원래 주소를 리턴하지만 String이 오버라이딩 해서 문자열을 리턴한다.
		System.out.println("str4:" + str4); 
		str4 = str4.replace("nice", "good");
		// 바꾼 값을 다시 str4에 넣어야만 변경된 값이 적용된다.
		// 주소가 변경되면서 예를들어 원래 400번지에 값이 있었다면, str4에 replace한것을 다시 넣으면서 500번지로 새로 만들게 된다.
		System.out.println("str4:" + str4); 
		
		System.out.println();
		StringBuffer sb = new StringBuffer("Have ");
		// 예를들어 sb가 100번지라면 100번지 주소에 가서 "a "를 추가하고, "nic~ " 추가를 한다. 공간을 계속 늘려서 값을 변경한다.
		// 따라서 StringBuffer는 수정이 가능한 클래스라고 한다. (String클래스는 수정이 불가능하다.)
		// String으로 문자열을 만드는 것 보다는 StringBuffer를 이용하는 것이 속도가 더 빠르다.
		sb.append("a "); 
		sb.append("nice day");
		
		//replace 해당 위치의 문자열을 변경함.
		System.out.println("sb:"+sb);
		sb.replace(7, 11, "good"); // 11 앞에 있는거 까지 가져옴!!!!!!
		System.out.println("sb:"+sb);
		
		//insert 7번째 자리에 문자열을 추가하여 원래 있던 부분이 밀려남
		sb.insert(7,"happy ");
		System.out.println("sb:"+sb);
		
		//delete 삭제하는 메서드. 13번째 앞에 있는거 까지 삭제!!!!13아님 12임!
		sb.delete(7, 13);
		System.out.println("sb:"+sb);
		
		
		String s1 = new String("abc");
		String s2 = new String("abc");
		
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		// boolean java.lang.String.equals(Object anObject) ->String에서 오버라이딩 한 equals
		// 따라서 문자열을 비교한다.
		System.out.println(s1.equals(s2)); // true 
		
		// boolean java.lang.Object.equals(Object obj) -> 원래의 부모(Object)가 불려준 equals.
		// 따라서 주소를 비교한다.
		System.out.println(sb1.equals(sb2)); // false
		
		// toString
		// StringBuffer가 String으로 바뀐다.
		// String java.lang.StringBuffer.toString()
		String ss1 = sb1.toString();
		String ss2 = sb2.toString();
		System.out.println(ss1.equals(ss2)); // true String으로 바뀌어서 String에서 오버라이딩 한 equals.
		
		
		
		
	}

}
