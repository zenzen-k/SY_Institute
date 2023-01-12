
public class Ex09_09__Wrapper {

	public static void main(String[] args) {

		String[] str = { "231", "78", "1.234", "97" };

		int i;
		try {
			for (i = 0; i < str.length; i++) {
				int k = Integer.parseInt(str[i]);
				System.out.println(k);
			}

		} catch (NumberFormatException e) {
			System.out.println("정수 변환 불가능");
		}
		// 231 78 정수 변환 불가능
		System.out.println();

		for (i = 0; i < str.length; i++) {
			try {
				int k = Integer.parseInt(str[i]);
				System.out.println(k);
			} catch (NumberFormatException e) {
				System.out.println("정수 변환 불가능");
			}
		}
		// 231 78 정수 변환 불가능 97
	}
}
