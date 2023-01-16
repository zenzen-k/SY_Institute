import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Ex10_06_Vector {

	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>();
		System.out.println(v.size());
		
		v.add("봄");
		v.add("여름");
		v.add("가을");
		v.add("겨울");
		
		System.out.println("v: "+v);
		System.out.println(v.size());
		System.out.println(v.get(0));
		
		for(String s : v) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		// iterator -> Iterator
		Iterator<String> iter = v.iterator(); // 반복할 준비!!
		while(iter.hasNext()) { // iter에서 반복할 데이터가 있니?
			String s = iter.next(); 
			System.out.print(s+" ");
		}
		System.out.println();
		
		// 반복. v안에 4개의 요소를 반복할 준비를 해서 Enumeration 타입의 변수 en에 넣을 수 있다.
		// elements -> Enumeration
		Enumeration<String> en = v.elements();
		while(en.hasMoreElements()) { // 더없으면 false
			String s = en.nextElement();
			System.out.print(s+" ");
		}
		
	}//main

}
