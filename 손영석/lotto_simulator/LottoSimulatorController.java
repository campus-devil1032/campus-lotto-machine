package lotto_simulator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoSimulatorController {
	static LottoSimulatorView view = new LottoSimulatorView();
	static LottoSimulatorModel model = new LottoSimulatorModel();

	Scanner userInput = new Scanner(System.in);

	// 사용자 입력
	public int getUserInput() {
		int input = userInput.nextInt();
		userInput.nextLine();
		return input;
	}
	
	// 수동입력
	public void inputUserNum() { // 6개 사욪자 입력값 받아오기
		System.out.println("1~45 사이의 숫자를 입력하세요.");
		System.out.println("(메뉴로 돌아가기: 숫자 0)");
		for (int i = 0; i < 6; i++) {
			System.out.print((i + 1) + "번 숫자 : ");
			model.setInputNum(i, getUserInput());
		}
	}

	// 수동 자동 선택
	public void mainMenu() {
		boolean isRunClient = true;
		while (isRunClient) {
			try {
				view.showMainMenu();

				int userSelect = getUserInput();

				switch (userSelect) {

				case 0: // 종료
					System.out.println("시뮬레이터를 종료합니다.");
					isRunClient = false;
					break;

				case 1: // 수동
					manualType();
					break;

				case 2: // 자동
					autoType();
					break;

				default: // 다른 값 입력 시
					System.err.println("잘못된 입력입니다. 다시 입력하세요.");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("잘못된 입력입니다. 다시 입력하세요.");
				userInput.nextLine(); // 스캐너 초기화
				continue;
			}
		}
	}

	// 수동
	public void manualType() {
		boolean isRunManual = true;
		
		while (isRunManual) {
			try {
				inputUserNum();
				model.outputUserNum();
			} catch (InputMismatchException e) {
				System.err.println("잘못된 입력입니다. 다시 입력하세요.");
				userInput.nextLine(); // 스캐너 초기화
			}
		}
	}

	// 자동
	public void autoType() {
		
		boolean isRunAuto = true;

		model.generateNum(); // 번호 생성
		view.showAutoMenu(); // 자동 메뉴화면

		while (isRunAuto) {
			try {
				int userSelect = getUserInput(); // 메뉴 선택
				switch (userSelect) {

				case 0: // 뒤로가기
					isRunAuto = false;
					break;

				case 1: // 번호 재생성
					model.generateNum();
					System.out.println("번호가 재생성되었습니다.");
					break;

				case 2: // 자동 번호 출력
					model.printRandomNum();
					break;

				case 3: // 당첨 번호 출력
					model.printLottoNum();
					break;

				case 4: // 당첨 확인
					System.out.println("일치하는 번호 개수: " + model.checkMatch());
					if (model.checkBonus() == true) {
						System.out.println("+ 보너스 번호");
					}
					
					break;

				case 9: // 메뉴 다시보기
					view.showAutoMenu();
					break;

				default: // 다른 값 입력 시
					System.err.println("잘못된 입력입니다. 다시 입력하세요.");
					break;
				}

			} catch (InputMismatchException e) {
				System.err.println("올바른 번호를 입력해주세요.");
				userInput.nextLine();
				continue;
			}
		}
	}
}
