
public class Ex07_04_throw {
	public static void main(String[] args) {

		try {
			call();
			System.out.println("정상적으로 처리 되었습니다.");
		} catch (ArithmeticException e) {
			System.out.println("처리중 에러발생");
		}

	} // main

	// main위에 작성해도 main먼저 실행하기 때문에 어디 정의하던 상관은 없으나 가독성을 위해서 main을 맨 위로 하는 편
	public static void call() {

		try {
			int a = 3 / 0;

		} catch (ArithmeticException e) {
			System.out.println("call메서드에서 ERROR 발생");
			throw e; // call메서드를 호출한 곳으로 e(예외정보)를 던진다.
		}
	} // call
}
