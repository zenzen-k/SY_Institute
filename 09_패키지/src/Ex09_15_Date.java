import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_15_Date {

	public static void main(String[] args) {

		Date now = new Date();
		System.out.println("now: " + now);

		String[] week = { "일", "월", "화", "수", "목", "금", "토" };

		// 앞으로 사라질 가능성이 있는 메소드에는 줄이 그어져 있음
		System.out.print(now.getYear() + 1900 + "년 "); // 1900년 기준. -> 안 더해주면 123년이 출력된다.
		System.out.print(now.getMonth() + 1 + "월 "); // 정수출력. 0월
		System.out.print(now.getDate() + "일 "); //
		System.out.print(week[now.getDay()] + "요일"); // 일 : 0, 월 : 1 ...
		System.out.println();
		
		//java.text. 패키지
		// SimpleDateFormat -> 날짜의 형식을 지정하는 클래스
		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-d일 E요일");
		SimpleDateFormat sdf2, sdf3;
		// YY : 연도 두자리 
		// MM : 월 두자리 
		// d : 한자리 ( dd 로 작성하면 03으로 나옴. 두자리일수여도 d만 사용하면 13 이렇게 잘나옴)
		// E : 요일
		// -> 포맷이라고 부른다.
		System.out.println(sdf.format(now)); // Date 객체를 매개변수로 넣어야 한다.
		
		
		sdf2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a"); //a > 오전/오후 출력 a는 대문자 불가능
		// 다른건 괜찮지만 MM과 mm의 대문자 소문자는 구분해야한다~
		System.out.println(sdf2.format(now));
		
		sdf3 = new SimpleDateFormat("yyyy년 MMM dd"); // MMM -> 1월, dddd-> 0013 0이 붙어서 나오는듯!
		System.out.println(sdf3.format(now));

		
		
		
	}

}
