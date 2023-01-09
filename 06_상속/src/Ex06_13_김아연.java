abstract class Employee3 {
	String empno;
	String name;
	int pay;
	
	public Employee3(String empno, String name, int pay) {
		this.empno = empno;
		this.name = name;
		this.pay = pay;
	}
	
	abstract double getMonthPay();
} // Employee3

// 일용직
class PartTime extends Employee3{
	int workDay;
	public PartTime(String empno, String name, int pay, int workDay) {
		super(empno, name, pay);
		this.workDay = workDay;
	}
	double getMonthPay() {
		return this.pay * workDay;
	}
} // PartTime

// 계약직
class Contract extends Employee3{
	int hireYear;
	public Contract(String empno, String name, int pay, int hireYear) {
		super(empno, name, pay);
		this.hireYear = hireYear;
	}
	double getMonthPay() {
		return (this.pay/(double)12) * hireYear;
	}
} // Contract

// 정규직
class FullTime extends Employee3{
	int bonus;
	public FullTime(String empno, String name, int pay, int bonus) {
		super(empno, name, pay);
		this.bonus = bonus;
	}
	double getMonthPay() {
		return (this.pay/(double)12) + (this.bonus/(double)12);
	}
} // FullTime


public class Ex06_13_김아연 {
	public static void main(String[] args) {
		
		
		PartTime p = new PartTime("P1", "수지", 30, 20);
		Contract c = new Contract("C2", "보검", 250, 3);
		FullTime f = new FullTime("F3", "제니", 3000, 500);
		
		System.out.println(p.getMonthPay());
		System.out.println(c.getMonthPay());
		System.out.println(f.getMonthPay());
		
		System.out.println("-----");
		
		Employee3[] arr = { new PartTime("P1", "수지", 30, 20),
							new Contract("C2", "보검", 250, 3),	
							new FullTime("F3", "제니", 3000, 500)
							};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].getMonthPay());
		}
	}
}
