
public class Ex05_08_배열넘기기 {

	public static void main(String[] args) {

		int[] arr = { 30, 40, 50 };
		int i;
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		sub(arr[0],arr[1],arr[2]); // static main에서 호출. static->static!
		sub2(arr);	//arr의 주소가 넘어간다.
		System.out.println("------------");
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}// main

	static void sub(int x, int y, int z) { // 따라서 static 작성해주기
		System.out.println("sub 메서드 정의");
		System.out.println(x+","+y+","+z);
	}
	
	static void sub2(int [] des) {	//arr의 주소를 받음으로 arr[0]으로 가면 정수형배열이 있음! 따라서 매개변수의 타입은 int[]로 받아야한다.
		//그래서 현재 30이 들어있는 주소를 arr와 des가 가지고 있게 된다(위에서 호출해서)
		System.out.println("sub2 메서드 정의");
		int i;
		for (i = 0; i < des.length; i++) {
			System.out.print(des[i] + " ");
		}
		des[1] = 999;	//des[1]이 999로 바뀜. -> arr[1]도 바뀜. 같은 주소를 가지고 있기 때문에.
		System.out.println();
	}

}
