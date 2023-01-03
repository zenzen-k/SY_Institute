
public class Ex05_10_재귀호출 {

	public static void main(String[] args) {

		show(3);

	} // main

	static void show(int cnt) {
		System.out.println("Hi~" + cnt);
		if (cnt == 1)
			return; // cnt == 1이면 return함!
		show(--cnt);// 3->2->1
		// 다시 show를 호출함. 본인을 호출한다. "재귀호출"
		
//		show(cnt--); 
//		이렇게 한다면 나중에 뺴고 일단 가지고 있는것부터 넣게 됨. 따라서 계속 3을 넣게 되어 무한루프에 빠지게 된다.
		
	} // show

}