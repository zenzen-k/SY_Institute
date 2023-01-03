
public class Ex02_05_삼항 {
	public static void main(String[] args) {
		/*삼항연산자(조건연산자) : 조건식?참:거짓 */
		//조건에 따라 처리하고 싶은것이 다를때 사용함
		int a=101, b=20;
		int result = a>b ? a : b;
		System.out.println("result:" + result);
		
		String str = a%2==0 ? "짝수" : "홀수";
		System.out.println("str:" + str);
	}
}
