import java.util.ArrayList;
import java.util.Scanner;

public class JoinMain {

	ProducerDao pDao = new ProducerDao();
	ConsumerDao cDao = new ConsumerDao();
	JoinDao jDao = new JoinDao();
	Scanner sc = new Scanner(System.in);

	public JoinMain() {
		init();
	} // 생성자

	private void init() {
		while(true) {
			System.out.println("\n=== 메뉴 선택 ===");
			System.out.println("1. Producer 테이블 조회");
			System.out.println("2. Consumer 테이블 조회");
			System.out.println("3. Producer 테이블에 추가");
			System.out.println("4. Consumer 테이블에 추가");
			System.out.println("5. Producer 테이블에서 삭제");
			System.out.println("6. Consumer 테이블에서 삭제");
			System.out.println("7. Producer 테이블에서 수정");
			System.out.println("8. Consumer 테이블에서 수정");
			System.out.println("9. 조인");

			System.out.print("메뉴번호 선택>> ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				ArrayList<ProducerBean> plists = pDao.getAllProducer();
				pshow(plists);
				break;
			case 2:
				ArrayList<ConsumerBean> clists = cDao.getAllConsumer();
				cshow(clists);
				break;
			case 3:
				insertProducer();
				break;
			case 4:
				insertConsumer();
				break;
			case 5:
				deleteProducer();
				break;
			case 6:
				deleteConsumer();
				break;
			case 7:
				updateProducer();
				break;
			case 8:
				updateConsumer();
				break;
			case 9:
				// 일치하는거 기준 code, pname, cname, cprice, caddr
				ArrayList<JoinBean> lists = jDao.join();
				jshow(lists);
				break;
			} // switch
		}
	} // init()

	private void jshow(ArrayList<JoinBean> lists) {
		System.out.println("code\tpname\tcname\tcprice\tcaddr");
		System.out.println("-------------------------------------");
		for(JoinBean jb : lists) {
			System.out.println(jb.getCode() + "\t" +
								jb.getPname() + "\t" +
								jb.getCname() + "\t" +
								jb.getCprice() + "\t" +
								jb.getCaddr());
		}
	} // jshow()

	private void updateConsumer() {
		System.out.print("코드 입력 : ");
		String code = sc.next();
		
		System.out.print("수정 코드 입력 : ");
		String upcode = sc.next();

		int cnt = cDao.updateConsumer(code, upcode);
		if(cnt > 0)
			System.out.println("수정 성공");
		else if(cnt == 0)
			System.out.println("조건 오류");
		else
			System.out.println("수정 실패");
	} // updateConsumer()

	private void updateProducer() {
		System.out.print("코드 입력 : ");
		String code = sc.next();
		
		System.out.print("수정 코드 입력 : ");
		String upcode = sc.next();

		int cnt = pDao.updateProducer(code, upcode);
		if(cnt > 0)
			System.out.println("수정 성공");
		else if(cnt == 0)
			System.out.println("조건 오류");
		else
			System.out.println("수정 실패");
	} // updateProducer()

	private void deleteConsumer() {
		System.out.print("삭제할 코드번호 입력 : ");
		String code = sc.next();

		int cnt = cDao.deleteConsumer(code);
		if(cnt > 0)
			System.out.println("삭제 성공");
		else if(cnt == 0)
			System.out.println("조건 오류");
		else
			System.out.println("삭제 실패");
	} // deleteConsumer()

	private void deleteProducer() {
		System.out.print("삭제할 코드번호 입력 : ");
		String code = sc.next();

		int cnt = pDao.deleteProducer(code);
		if(cnt > 0)
			System.out.println("삭제 성공");
		else if(cnt == 0)
			System.out.println("조건 오류");
		else
			System.out.println("삭제 실패");
	} // deleteProducer()

	private void insertConsumer() {
		System.out.print("코드번호 입력 : ");
		String code = sc.next();
		System.out.print("성명 입력 : ");
		String cname = sc.next();
		System.out.print("가격 입력 : ");
		int cprice = sc.nextInt();
		System.out.print("주소 입력 : ");
		String caddr = sc.next();

		ConsumerBean cb = new ConsumerBean(code, cname, cprice, caddr);
		int cnt = cDao.insertConsumer(cb);

		if(cnt > 0)
			System.out.println("삽입 성공");
		else if(cnt == 0)
			System.out.println("조건 오류");
		else
			System.out.println("삽입 실패");
	} // insertConsumer()

	private void insertProducer() {
		System.out.print("코드번호 입력 : ");
		String code = sc.next();
		System.out.print("상품명 입력 : ");
		String pname = sc.next();
		System.out.print("가격 입력 : ");
		int pprice = sc.nextInt();

		ProducerBean pb = new ProducerBean(code, pname, pprice);
		int cnt = pDao.insertProducer(pb);

		if(cnt > 0)
			System.out.println("삽입 성공");
		else if(cnt == 0)
			System.out.println("조건 오류");
		else
			System.out.println("삽입 실패");
	} // insertProducer()

	private void cshow(ArrayList<ConsumerBean> clists) {
		System.out.println("code\tcname\tcprice\tcaddr");
		System.out.println("-----------------------------");
		for(ConsumerBean cb : clists) {
			System.out.println(cb.getCode() + '\t' +
					cb.getCname() + '\t' +
					cb.getCprice() + '\t' +
					cb.getCaddr());
		}
	} // cshow()

	private void pshow(ArrayList<ProducerBean> plists) {
		System.out.println("code\tpname\tpprice");
		System.out.println("----------------------");
		for(ProducerBean pb : plists) {
			System.out.println(pb.getCode() + '\t' +
					pb.getPname() + '\t' +
					pb.getPprice());
		}
	} // pshow()

	public static void main(String[] args) {
		new JoinMain();
	} // main
} // JoinMain 클래스
