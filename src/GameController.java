import java.io.IOException;
import java.util.Scanner;

public class GameController {
	public static void run() { // 컨트롤러쪽으로 넣기.
		LottoModel l = new LottoModel();
		Player owner = new Player(100000000, "user"); // 유저 입력받게 수정
		Scanner sc = new Scanner(System.in);
		String commandLine = "";
		int commandChoice = 0;

		game: for (; true;) {
			ConsolViewer.menu();
			commandLine = sc.nextLine();
			if (LottoModel.isInteger(commandLine)) {
				commandChoice = Integer.parseInt(commandLine);
			} else {
				System.out.println("1,2,3중에 입력해주세요.");
				continue;
			}
			switch (commandChoice) {
			case 1: {
				try {
					l.ticketMaker(owner); // 티켓구매#0
					l.setWinNumber(); // 당첨번호 설정#2
					l.winnerChecker(owner); // 티켓비교#3 //후 당첨금분배#4
				} catch (IOException e) {
					System.out.println("입력이 옳바르지 않습니다.");
				}
				break;
			}
			case 2: {
				ConsolViewer.viewWin(owner);
				break;
			}
			case 3: {
				System.out.println("종료합니다.");
				break game;
			}
			default: {

			}
			}
		}
	}
}