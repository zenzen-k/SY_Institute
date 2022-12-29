
public class Ex03_11_while {

	public static void main(String[] args) {
		
		int i;
		for(i=1; i<6; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		/*
		 *초기식;
		 *while(조건식){
		 *	반복할문장1;
		 *	반복할문장2;
		 *	증감식;
		 *}
		 */
		i=1;
		while(i<=5) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println("while문 밖:" + i);
		// 초기식 - 조건식 - 문장수행 - 증감식 - 닫는괄호 - 조건식 - 문장수행 - 증감식 - 닫는괄호 
		
		i=10;
		while(i>=2) {
			
			System.out.print(i + " ");
			i -= 2;
		}
		System.out.println("while문 밖:" + i);
		// i가 0이 되면서 while문을 빠져나온다.
		
		/*
		초기식;
		do {
			반복할문장;
			증감식;
		} while(조건식);
		*/
		
		i=1;
		do {
			System.out.print(i + " ");
			i++;
		}while(i<=5);
		System.out.println("do~while문 밖:"+i);
		//실행과정 :
		// 초기식 - do 반복문장 실행 - 증감식 - 조건식 - 참이면 do안으로 다시 들어감 - 반복문장 실행 - 증감식 - 조건식 - 거짓이면 빠져나옴
	}

}
