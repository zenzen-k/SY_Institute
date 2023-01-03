
public class Ex03_10_이중for {

	public static void main(String[] args) {
		
		int i,j;
		//별찍기1
		for(i=0; i<5; i++) {
			for(j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//별찍기2
		//i=0으로 시작
		for(i=0; i<5; i++) {
			for(j=5-i; j>0; j--) {	//(j=4; j>=i; j--)
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 같은 출력이지만 i=5 으로 시작
		for(i=5; i>0; i--) {
			for(j=i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		//별찍기3
		for(i=0; i<5; i++) {
			for(j=4-i; j>0; j--) {	//공백 출력
				System.out.print(" ");
			}
			for(int x=0; x<=i; x++) {	//별 출력
				System.out.print("*");
			}
			System.out.println();
		}
		// 별찍기3 다른방식
		for(i=0; i<5; i++) {
			for(j=3; j>=i; j--) {
				System.out.print(" ");
			}
			for(j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

		
	}
	
}
