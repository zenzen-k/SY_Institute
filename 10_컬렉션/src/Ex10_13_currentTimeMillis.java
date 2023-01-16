import java.util.ArrayList;

public class Ex10_13_currentTimeMillis {

	public static void main(String[] args) {
		
		int[] arr = new int[1000000];
		int i;
		//1970.1.1 ~ 지금까지 경과한 시간을 표현함. 1/1000초 까지 표현을 함.
		long start = System.currentTimeMillis();
		System.out.println(start);
		for(i=0; i<arr.length; i++) {
			arr[i] = i;
		}
		long end = System.currentTimeMillis();
		System.out.println("배열 경과한 시간:"+(end-start)); //2 -> 0.002초
		
		
		start = System.currentTimeMillis();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(i=0; i<arr.length; i++) {
			list.add(i);
		}		
		end = System.currentTimeMillis();
		System.out.println("컬렉션 경과한 시간:"+(end-start)); //15 -> 0.015초
		
		// 속도 : 배열이 더 빠름.
		// 빈번한 데이터의 삽입, 수정, 삭제를 하거나 정확한 크기를 정할 수 없을 때에는 컬렉션을 사용한다.
		// 효율적인 프로그램 작성을 생각해야 한다.
		
	}

}
