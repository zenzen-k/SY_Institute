import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class Person implements Serializable{ // implements Serializable "객체를 직렬화 한다"고 말한다.
									  // 직렬화 하면 데이터들을 byte단위로 잘게 쪼개서 파일에 출력한다.
	String name = "아이유";
	int age = 20;
} // Person


// Object : 객체. 클래스로 만들어진 공간
public class Ex12_07_ObjectStream {
	public static void main(String[] args) {
		
		Person per = new Person();
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			// 작성하기 위한 연결다리 생성
			fos = new FileOutputStream("objectfile.txt"); // 1차 스트림
			oos = new ObjectOutputStream(fos); // 2차 스트림
			// 이처럼 2차 스트림은 파일명을 직접 쓰면 안되고, 1차 스트림 객체를 참조
			// 객체 두개를 썼음!
			oos.writeObject(per); // per 참조변수가 관리하는 객체를 쓰겠다.
			oos.writeObject(new Date()); // 파일에 날짜 작성함
			// 글자가 깨지는데 객체를 파일에 작성하면 원래 깨짐.. 우리눈에는 그렇게 보이지만 내부적으로는 다 있음 ㄱㅊ
			
			
			// 읽어오기 위한 연결다리 생성
			fis = new FileInputStream("objectfile.txt"); // 1차 스트림
			ois = new ObjectInputStream(fis); // 2차 스트림
			// 두개 객체 읽어오기!
			Person p = (Person)ois.readObject(); // Object를 리턴하므로 다운캐스팅을 해주어야 한다.
			System.out.println(p.name);
			System.out.println(p.age);
			
			Date d = (Date)ois.readObject();
			System.out.println(d);
			
			
		} catch (FileNotFoundException e) { // FileInputStream, 
			e.printStackTrace();
		} catch (IOException e) { // readObject, writeObject, 
			e.printStackTrace();
		} catch (ClassNotFoundException e) { // readObject 에서 해당하는 Person 객체가 없을 수도 있으니까 해주는 처리!
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}


// java.io.NotSerializableException
// oos.writeObject(per);
// 객체를 파일에 출력하고 싶을 때는 클래스가 Serializable인터페이스를 상속받아서 만들 수 있게 해주어야 한다.