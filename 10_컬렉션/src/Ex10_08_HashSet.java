import java.util.HashSet;

public class Ex10_08_HashSet {

	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		// 난수를 넣을 때 어자피 중복값은 안들어간다! HashSet이므로!
		// 1~10 정수 난수 5개 만들어보기
		
//		while(hs.size() != 5) {
//			hs.add((int)(Math.random()*10)+1);	
//		}
//		System.out.println(hs);
		
		// 다른방식
		while(true) {
			int num1 = (int)(Math.random()*10+1);
			System.out.println(num1); // num1 확인
			hs.add(num1);
			
			if(hs.size()==5)
				break;
		}
		System.out.println(hs);
		
		// toArray가 Object[]을 리턴한다. HashSet을 배열로 바꾸는 메소드
		Object[] arr = hs.toArray(); // toArray는 무조건  Object를 리턴하므로 형변환 불가능!
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		
		Integer[] arr2 = new Integer[hs.size()];
		hs.toArray(arr2); // 배열을 만들고 toArray메소드를 작성하면 알아서 그 배열에 값이 들어간다!
		for(int i =0; i<arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		
		
	} // main

}
