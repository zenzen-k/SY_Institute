
public class Ex04_06_2차원 {

	public static void main(String[] args) {
		int i, j;
//		int[][] arr = { { 1, 2, 3, 4 },
//						 { 5, 6, 7, 8 } };
//		int[][] arr = new int[][]{ { 1, 2, 3, 4 },
//									{ 5, 6, 7, 8 } };
		int[][] arr = new int[2][4];
		arr[0][0]=1;
		arr[0][1]=2;
		arr[0][2]=3;
		arr[0][3]=4;
		arr[1][0]=5;
		arr[1][1]=6;
		arr[1][2]=7;
		arr[1][3]=8;
		

		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//확장 for문 : 무조건 첨부터 끝까지 알아서 접근!!!!!!!!!
		//for( 한줄가져왕! : 작업대상)
		for(int[] x : arr) {	//1차원 배열을 받
			//int[] x = {1,2,3,4}
			//int[] x = {5,6,7,8}
			for(int y : x) {	//x의 행을 가져와서 y에 하나씩 넣어서 출력
				System.out.print(y+" ");
			}
			System.out.println();	//다시 위로 올라가서 두번째 행 수행!
		}

	}

}
