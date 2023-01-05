class Student3 {
	private String name;
	private int kor, eng, math;

	public Student3() {//생성자 오버로딩
		name = "써니";
		kor = 10;
		eng = 20;
		math = 30;
	}

	public Student3(String name) {
		this.name = name;
		kor = 50;
		eng = 50;
		math = 59;
	}

	public Student3(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void display() {
		System.out.println(name + "," + kor + "," + eng + "," + math);
	}

}// Student

public class Ex05_21_객체배열 {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3 }; // int 3개를 배열로
		double[] b = { 1.1, 2.2, 3.3, 4.4 };

		Student3 s1 = new Student3(); // 써니,10,20,30
		Student3 s2 = new Student3("태연"); // 태연,50,50,59
		Student3 s3 = new Student3("윤아", 70, 80, 90);

		s1.display();
		s2.display();
		s3.display();

		System.out.println("----------------");

		// 객체배열 만들기 1
//		Student3[] arr = new Student3[3];
//		// 주소 배열은 기본값 null. 클래스배열에 주소가 들어간당~
//		arr[0] = new Student3(); //arr[0] = s1 이렇게 사용해도 됨! 이미 객체를 만들었기 때문엥
//		arr[1] = new Student3("태연"); // arr[1] = s2
//		arr[2] = new Student3("윤아", 70, 80, 90);

		// 객체배열 만들기 2
		Student3[] arr = { new Student3(),
						   new Student3("태연"),
						   new Student3("윤아", 70, 80, 90)};
		
		
		int i;
		for (i = 0; i < arr.length; i++) {
			arr[i].display();
		}
		System.out.println("----------");
		
		//확장 for문
		for(Student3 x : arr) {
			x.display();
		}

	}// main

}
