
public class Ex03_12_break_continue {

	public static void main(String[] args) {

		for(int i=1; i<=10; i++) {
			if(i==5) {
				break;	//반복문을 빠져나가기 위함. if문은 빠져나가지 않음
			}
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		
		for(int i=1; i<=10; i++) {
			System.out.print(i + " ");
			if(i==5) {
				continue;	//반복문 안에서 continue 밑에 있는 것을 실행 X
			}
			//System.out.print(i + " ");
		}
		System.out.println();
	}

}
