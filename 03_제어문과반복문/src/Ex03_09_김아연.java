
public class Ex03_09_김아연 {

	public static void main(String[] args) {
		
		//2~9단 구구단 가로로 출력하기
		
		for(int i=1; i<10; i++) {
			for(int j=2; j<10; j++) {
				System.out.print(j + "*"+ i + "=" + j*i + "\t");
				//	"%2d*%d=%2d\t",j,i,(j*i) -> %2d 자릿수 지정
			}
		System.out.println();
		}
	}

}
