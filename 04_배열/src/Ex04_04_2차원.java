
public class Ex04_04_2차원 {

	public static void main(String[] args) {

		/* 2차원 배열의 선언 방법 3가지 */

		// [0]열[1]열[2]열
		int[][] arr = { { 11, 22, 33 }, // [0]행
				{ 44, 55, 66 }, // [1]행
				{ 13, 29, 72 }, // [2]행
				{ 77, 88, 99 } }; // [3]행

		// arr 주소출력
		System.out.println("arr:" + arr); // arr:[[I@6504e3b2
		System.out.println("arr[0]:" + arr[0]); // arr[0]:[I@515f550a
		System.out.println("arr[1]:" + arr[1]);
		System.out.println("arr[2]:" + arr[2]);
		System.out.println("arr[3]:" + arr[3] + "\n");
		// 데이터 출력
		System.out.print(arr[0][0] + " "); // 11
		System.out.print(arr[0][1] + " "); // 22 - 0행 1열
		System.out.println(arr[0][2]); // 33

		System.out.print(arr[1][0] + " ");
		System.out.print(arr[1][1] + " ");
		System.out.println(arr[1][2]);

		System.out.print(arr[2][0] + " ");
		System.out.print(arr[2][1] + " ");
		System.out.println(arr[2][2]);

		System.out.print(arr[3][0] + " ");
		System.out.print(arr[3][1] + " ");
		System.out.println(arr[3][2]);

		// 위 그림에서 대표관리자가 관리하는 두번째 관리자는 4개이기 때문에 4가 출력됨!
		System.out.println(arr.length); // 4
		System.out.println(arr[0].length); // 3 arr[0]에는 arr[0][0] arr[0][1] arr[0][2]
		System.out.println(arr[1].length); // 3
		System.out.println(arr[2].length); // 3

		System.out.println();
		//배열의 각 행과 열의 길이가 달라도 조건문을 이렇게 작성한다면 알아서 있는 길이만큼 반복하여 출력하게 됨.
		for (int i = 0; i < arr.length; i++) {	
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		/*
		int[][] arr = { { 11, 22, 33 }, 
				{ 44, 55 },
				{ 13, 29, 72, 89 }, 
				{ 77, 88, 99 } };
		
		System.out.print(arr[1][2] + " ");
		-> Unresolved compilation problem: Duplicate local variable arr
			없는 공간에 접근하려고 했기때문에 에러가뜸
		
		*/
		
		//가변배열 출력
		System.out.println("-----------------");
		int[][] arr1 = { { 11, 22, 33 }, 
						 { 44, 55 },
						 { 13, 29, 72, 89 }, 
						 { 77, 88, 99 } };
		
		for(int[] x : arr1) {
			for(int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
		
		
	}

}
