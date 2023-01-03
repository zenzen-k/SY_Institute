
public class Ex04_07_정렬 {

	public static void main(String[] args) {

		int[] arr = { 8, 3, 5, 2, 9 }; // int arr[] 도 사용 가능함 상관없음!

		int i, j;
		// 정렬 전
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		int a = 10, b = 20, temp;
		temp = b;
		b = a;
		a = temp;
		System.out.println(a + " " + b);

		// i는 기준, j는 비교대상자
		// i=0 j=1 2 3 4
		// i=1 j=2 3 4
		// 선택 정렬 - 오름차순
		for (i = 0; i < arr.length - 1; i++) { // 기준은 4번째까지(3번방)만
			for (j = i + 1; j < arr.length; j++) { // 비교대상은 5번째까지(4번방)
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println(arr[i]);
		}

		// 정렬 후
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
