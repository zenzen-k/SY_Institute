
public class Ex05_14_overloading {

	public static void main(String[] args) {
		int result1 = plus(10,20,30);
		double result2 = plus(1.2, 3.4);
		
		System.out.println("result1:" + result1);
		System.out.println("result2:" + result2);
	}
	static int plus(int x, int y, int z) {
		return x+y+z;
	}
	static double plus(double x, double y) {
		return x+y;
	}
}
