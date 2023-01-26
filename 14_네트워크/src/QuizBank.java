
public class QuizBank {

	// 상태를 나타내기 위한 상수 변수
	private final int WAITING = 0;
	private final int PROBLEM = 1;
	private final int ANSWER = 2;
	private int state = WAITING; // 기본 상태 값. 문제를 기다리는 상태

	private String[] problems = { "네트워크 처리 패키지는?", "서버쪽 소켓 클래스는?", "인터넷에서 컴퓨터를 식별하는 주소는?" };
	private String[] answers = { "java.net", "ServerSocker", "IPAddress" };
	int currentProblem = 0;

	// 문제와 답을 보내주는 메서드.
	public String process(String input) { // 클라이언트가 보낸 답을 input으로 받는다.
		String output = null;

		if (state == WAITING) {
			output = "퀴즈를 시작합니다.(y/n)";
			state = PROBLEM; // 퀴즈를 푸는 상태로 만들어줌
		} 
		else if (state == PROBLEM) {
			if (input.equals("y")) { // input에 "y" 가 들어온다면
				output = problems[currentProblem];
				state = ANSWER; // 문제의 답을 보내기 위한 상태
			}
			else { // 풀지 않겠다 할땐
				output = "QUIT";
				state = WAITING; // 다시 대기상태
			}
		} 
		else if (state == ANSWER) {
			if(input.equals(answers[currentProblem])) {
				output = "정답입니다. 계속하시겠습니까?(y/n)";
				state = PROBLEM;
			}
			else {
				output = "오답입니다. 계속하시겠습니까?(y/n)";
				state = PROBLEM;
			}
//			currentProblem = (currentProblem < 2) ? currentProblem ++ : 0; 
			currentProblem = (currentProblem + 1) % 3; // 0+1 %3 , 1+1%3, 2+1%3, -> 0,1,2 , >이런 방식도 있음
		}

		return output;
	}

}
