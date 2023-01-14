import java.util.Calendar;

public class Ex09_14_Calendar {

	public static void main(String[] args) {
		
		// new Calendar();
		// Calendar()의 생성자의 접근제어자가 protected이므로 import 하더라도 이런방식의 객체 생성 불가능.
		// 그렇다면 어떻게 사용해야할까 ? ? ?
		
		Calendar cal = Calendar.getInstance();
		String[] week = {"","일","월","화","수","목","금","토"};
		
		//YEAR=2023,MONTH=0,WEEK_OF_YEAR=2,WEEK_OF_MONTH=2,DAY_OF_MONTH=13,
		//DAY_OF_YEAR=13,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=0,HOUR=10,HOUR_OF_DAY=10,MINUTE=21,SECOND=32
		System.out.println("cal:" + cal);
		// cal. 즉 참조변수만 사용하면 toString 자동 호출 > 주소 리턴
		// 하지만 Calendar클래스는 toString를 오버라이딩 하였음!
		
		// Calendar의 변수가 static이기 때문에 아래처럼 변수명을 가져와서 사용.
		// 또한 API를 살펴보면 변수가 final로 설정되어 있으므로 우리가 변경해서 사용할 수 없다.
		System.out.print(cal.get(Calendar.YEAR)+"년");
		System.out.print(cal.get(Calendar.MONTH)+1+"월");
		// MONTH는 1월일 때 0월로 출력하므로 +1을 해주어야 한다.
		System.out.print(cal.get(Calendar.DATE)+"일");
		
		System.out.print(cal.get(Calendar.DAY_OF_WEEK)+"요일");
		// DAY_OF_WEEK는 숫자를 리턴함. 일:1 월:2 화:3 수:4 ...
		System.out.print(week[cal.get(Calendar.DAY_OF_WEEK)]+"요일");
		// 배열을 만들어서 출력을 함
		System.out.println();
		
		
		int am_pm = cal.get(Calendar.AM_PM);
		if(am_pm == 0) {
			System.out.print("오전 ");
		}
		else {
			System.out.print("오후 ");
		}
		int hour = cal.get(Calendar.HOUR); // get메서드가 정수를 리턴함
		int minute = cal.get(Calendar.MINUTE); // get메서드가 정수를 리턴함
		int sec = cal.get(Calendar.SECOND); // get메서드가 정수를 리턴함

		System.out.println(hour + "시 " + minute + "분 " + sec + "초 입니다.");
		
		
	}

}
