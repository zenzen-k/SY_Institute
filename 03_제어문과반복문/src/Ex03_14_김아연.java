
public class Ex03_14_김아연 {

	public static void main(String[] args) {
		
		// i와 j의 1씩 증가는 변경 X/  2 4 6 8 단 출력, 2는 2, 4는 4까지 ...
		for(int i=2; i<10; i++) {
			if(i%2==0) {
				System.out.println("==" + i + "단==");
				
				for(int j=1; j<=i; j++) {
					System.out.println(i+"*"+j+"="+i*j);
				}
			}
			System.out.println();
		}

	}

}
