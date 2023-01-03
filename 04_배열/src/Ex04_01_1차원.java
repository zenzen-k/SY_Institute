
public class Ex04_01_1차원 {

	public static void main(String[] args) {
		
		int a=10, b=20, c=30, d=40, e=50;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println();
		
		//같은 자료형(data type)을 가지는 변수들을 한 묶음으로 그룹지어 관리하는 것이 "배열" 이다.
		//맨위의 a,b 처럼 변수를 선언하면 랜덤한 메모리 공간에 저장되지만 배열의 메모리 공간은 연속적으로 잡힌다.
//		int[] arr1 = {10,20,30,40,50};
//		int[] arr1 = new int[]{10,20,30,40,50};
		int[] arr1 = new int[5];	//방 5개를 만듬
		arr1[0]=10;
		arr1[1]=20;
		arr1[2]=30;
		arr1[3]=40;
		arr1[4]=50;
		
		//각각의 번지에 4byte씩(int) 건너뛰어 저장
		//ex) 10의 메모리 공간의 번지가 100이면 그다음 20이 들어간 메모리 공간의 번지수는 104임.
		//배열은 0번방부터 시작함. 즉, arr1[0]의 데이터 값은 10이다. 
		
		System.out.println("배열의 크기:"+arr1.length);
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		System.out.println(arr1[3]);
		System.out.println(arr1[4]);
		System.out.println();
		
		for(int i=0; i<5; i++) {	//int i=0; i<arr1.length; i++ 이런식의 작성도 가능함.
			//ArrayIndexOutOfBoundsException : 존재하지 않는 배열의 인덱스에 접근
			System.out.println(arr1[i]); //배열 0~4번방까지의 출력
		}
		
		//arr1 변수에는 값이 아닌 첫번째 방의 주소가 들어가있음.
		System.out.println(arr1);	//주소가 출력된다.
		
		System.out.println();
		
	//	double[] arr2 = {1.1, 2.2, 3.3};
	//	double[] arr2 = new double[]{1.1, 2.2, 3.3};
		double[] arr2 = new double[3];
		arr2[0] = 1.1;
		arr2[1] = 2.2;
		arr2[2] = 3.3;
		
		//배열의 방을 '요소'라고도 함.
		System.out.println("요소의 수:"+ arr2.length);
		// 접근할 수 있는 방의 범위 조절 가능함. 일부요소접근 시 사용
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println();
		
		//배열을 반복하여 출력	for(자료형 변수명 : 배열명)
		//arr2가 관리하는 double형 배열안의 데이터들을 하나씩 임시 변수 x에 넣어서 출력함
		/* 확장for문 - 배열에서만 가능함 (뒷부분에서 배울 내용 중 가능한게 더 있긴함) */
		// 무조건 첫번째 방부터 마지막 방까지 모두 접근함. 전체요소접근 시 사용
		for(double x : arr2) {
			System.out.println(x);
		}
		
		System.out.println();
		for(int y : arr1) {
			System.out.println(y);
		}
	}

}
