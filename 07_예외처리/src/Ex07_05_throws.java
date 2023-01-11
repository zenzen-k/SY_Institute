
public class Ex07_05_throws {
	public static void main(String[] args) {
		try {
			call(); // 여기로 던져져서 예외처리하게 된다!

		} catch (ArithmeticException e) {
			System.out.println("main에서 처리");
		}
	} // main

	public static void call() throws ArithmeticException {
		// ArithmeticException이 발생하는데 이 예외를 호출한 곳으로 던짐!
		int a = 3 / 0; 
	} // call
}
