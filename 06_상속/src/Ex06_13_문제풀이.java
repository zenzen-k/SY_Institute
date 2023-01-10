abstract class Employee4{
	private String empno;
	private String name;
	private int pay;
		
	public Employee4() {
		super();
	}

	// alt + shift + s -> constructor using fields 생성자 자동완성기능! ( 상단 메뉴바 source에도 있다 )
	public Employee4(String empno, String name, int pay) {
		super();
		this.empno = empno;
		this.name = name;
		this.pay = pay;
	}
	
	int getPay(){
		return pay;
	}
	
	// 보통 메서드는 public을 접근제어자로 둠.
	public abstract double getMonthPay();
	
} // Employee4


class PartTime2 extends Employee4{
	private int workDay;
	
	public PartTime2 (String empno, String name, int pay, int workDay){
		super(empno, name, pay);
		this.workDay = workDay;
	}
	
	public double getMonthPay() {
		return getPay() * workDay;
	}
} // PartTime


class Contract2 extends Employee4{
	private int hireYear;
	
	public Contract2() {
		super();
	}

	public Contract2(String empno, String name, int pay, int hireYear) {
		super(empno, name, pay);
		this.hireYear = hireYear;
	}

	public double getMonthPay() {
		return getPay()/(double)12 * hireYear;
	}
} // Contract


class FullTime2 extends Employee4{
	private int bonus;
	
	public FullTime2(String empno, String name, int pay, int bonus) {
		super(empno, name, pay);
		this.bonus = bonus;
	}

	@Override
	public double getMonthPay() {
		return getPay()/(double)12 + (bonus/(double)12);
	}
} // FullTime


public class Ex06_13_문제풀이 {

	public static void main(String[] args) {
		
		//다형성. 업캐스팅되었다.
		Employee4 p = new PartTime2("P1", "수지", 30, 20);
		Employee4 c = new Contract2("C2", "보검", 250, 3);
		Employee4 f = new FullTime2("F3", "제니", 3000, 500);
		
		System.out.println(p.getMonthPay());
		System.out.println(c.getMonthPay());
		System.out.println(f.getMonthPay());
		
		//다형성. 배열로. 상속개념에 의해 배열로 관리할 수 있다.
		Employee4[] arr = { new PartTime2("P1", "수지", 30, 20),
							new Contract2("C2", "보검", 250, 3),	
							new FullTime2("F3", "제니", 3000, 500)
							};
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].getMonthPay());
		}
		
	}

}
