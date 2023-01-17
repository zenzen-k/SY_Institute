class Bank{
	private int money = 10000;

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public synchronized void saveMoney(int money) {
		this.money += money;
	}
	
	
} // Bank

class Park extends Thread {
	public void run() {
		Ex11_10_Sync.myBank.saveMoney(3000); // 클래스명 작성 해주깅
		System.out.println("Park 3000 : " + Ex11_10_Sync.myBank.getMoney());
		
		synchronized (Ex11_10_Sync.myBank) { //-> 블록형태로 작성 할 때.
			
		}
	}
} // Park

class Kim extends Thread{
	public void run() {
		Ex11_10_Sync.myBank.saveMoney(500);
		System.out.println("Kim 500 : " + Ex11_10_Sync.myBank.getMoney());
	}
} // Kim


public class Ex11_10_Sync {
	public static Bank myBank = new Bank(); // 공유자원
	
	public static void main(String[] args) {
		// static 변수니까 이렇게도 되지만, Ex11_10_Sync.myBank.getMoney() 이것도 가넝
		System.out.println("원금:"+ myBank.getMoney()); 
		
		Park p = new Park();
		Kim k = new Kim();
		
		p.start();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		k.start();
		
		
	} // main
}
