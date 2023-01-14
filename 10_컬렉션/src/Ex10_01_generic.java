class Top<T>{ // 객체를 만들때 미지정 자료형이 확정된다.
	private T data; // T 자리는 아무거나 써도 되지만 Type이 들어가는 자리니까 T라고 작성해봄!
	
	//setter getter 메서드는 굉장히 중요한 부분이기 때문에 잘 알아둘것 !
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

} // Top


public class Ex10_01_generic {
	public static void main(String[] args) {
		String str = "Generic 방식";
		
		//아직 확정되지 않은 자료형<T>가 <String>으로 지정된다. 즉 객체 생성 시 자료형이 확정된다!!!
		Top<String> t1 = new Top<String>();
		t1.setData(str);
		//System.out.println(t1.getData());
		String s1 = t1.getData();
		System.out.println(s1);
		System.out.println();
		
		// 정수를 넣고싶으면 또다른 Top클래스를 만들어야 한다.
		// 넘어오는 값에 따라 타입이 달라질 수 있는데, 이렇게 재사용해줄 수 있는 기술을 Generic이라고 한다.
		Top<Integer> t2 = new Top<Integer>();
		t2.setData(123); // 123 -> new Integer(123); > 오토박싱!!!!
		
		Integer s2 = t2.getData();
		System.out.println(s2);
		
		Top<Double> t3 = new Top<Double>();
		t3.setData(1.1);
		double s3 = t3.getData();
		System.out.println(s3);
		
	}
}
