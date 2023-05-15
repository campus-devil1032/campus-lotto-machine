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
			model.setMyNum(i, getUserInput());
		}
	}
	
	// 내 번호 출력
	public void printMyNum() {
		System.out.println("내 로또 번호는 ");
		System.out.print("[ ");
		for (int i = 0; i < 6; i++) {
			System.out.print(model.getMyNum(i) + " ");
		}
		System.out.println("]\n입니다.");
	}

	// 당첨 번호 출력
	public void printLottoNum() { // 당첨 번호 출력
		System.out.println("당첨 번호는 ");
		System.out.print("[ ");
		for (int i = 0; i < 6; i++) {
			System.out.print(model.getLottoNum(i) + " ");
		}
		System.out.print("+ 보너스 " + model.getBonusNum());
		System.out.println("]\n입니다.");
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
					System.err.println("올바른 번호를 입력해주세요.");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("올바른 번호를 입력해주세요.");
				userInput.nextLine(); // 스캐너 초기화
				continue;
			}
		}
	}

	// 수동
	public void manualType() {

		boolean isRunMenu = true;

		model.generateNum(); // 번호 생성
		view.showInMenu(1); // 수동 메뉴화면

		while (isRunMenu) {
			try {
				int userSelect = getUserInput();
				switch (userSelect) {

				case 0: // 뒤로가기
					System.out.println("이전 메뉴로 돌아갑니다.");
					isRunMenu = false;
					break;

				case 1: // 번호 재생성
					model.generateNum();
					System.out.println("번호가 재생성되었습니다.");
					break;

				case 2: // 번호 입력
					inputUserNum();
					printMyNum();
					break;

				case 3: // 당첨 번호 확인
					printLottoNum();
					break;

				case 4: // 당첨 확인
					System.out.println("일치하는 번호 개수: " + model.checkMatch());
					if (model.checkBonus() == true) {
						System.out.println("+ 보너스 번호 일치");
					}
					if (model.checkMatch() <= 2) {
						System.out.println(model.checkRank());
					} else {
						System.out.println(model.checkRank() + " 상금은 " + model.checkPrize() + " 원입니다.");
					}
					break;

				case 5:	// 여러장 구매
					view.showMultipleMenu(1);
					multipleMenu();
					break;

				case 9:	// 메뉴 다시보기
					view.showInMenu(1);
					break;

				default: // 다른 값 입력 시
					System.err.println("올바른 번호를 입력해주세요.");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("올바른 번호를 입력해주세요.");
				userInput.nextLine(); // 스캐너 초기화
				continue;
			}
		}
	}

	// 자동
	public void autoType() {

		boolean isRunMenu = true;

		model.generateNum(); // 번호 생성
		model.generateAutoNum(); // 자동 번호 생성
		view.showInMenu(2); // 자동 메뉴화면

		while (isRunMenu) {
			try {
				int userSelect = getUserInput(); // 메뉴 선택
				switch (userSelect) {

				case 0: // 뒤로가기
					System.out.println("이전 메뉴로 돌아갑니다.");
					isRunMenu = false;
					break;

				case 1: // 번호 재생성
					model.generateNum();
					model.generateAutoNum();
					System.out.println("번호가 재생성되었습니다.");
					break;

				case 2: // 자동 번호 출력
					printMyNum();
					break;

				case 3: // 당첨 번호 출력
					printLottoNum();
					break;

				case 4: // 당첨 확인
					System.out.println("일치하는 번호 개수: " + model.checkMatch());
					if (model.checkBonus() == true) {
						System.out.println("+ 보너스 번호 일치");
					}
					if (model.checkMatch() <= 2) {
						System.out.println(model.checkRank());
					} else {
						System.out.println(model.checkRank() + " 상금은 " + model.checkPrize() + " 원입니다.");
					}
					break;

				case 5: // 여러장 구매
					view.showMultipleMenu(1);
					multipleMenu();
					break;

				case 9: // 메뉴 다시보기
					view.showInMenu(2);
					break;

				default: // 다른 값 입력 시
					System.err.println("올바른 번호를 입력해주세요.");
					break;
				}

			} catch (InputMismatchException e) {
				System.err.println("올바른 번호를 입력해주세요.");
				userInput.nextLine();
				continue;
			}
		}
	}

	// 여러장 구매 메뉴
	public void multipleMenu() {
		boolean isRunMenu = true;

		while (isRunMenu) {
			try {
				int userSelect = getUserInput();
				switch (userSelect) {

				case 0:
					System.out.println("이전 메뉴로 돌아갑니다.");
					System.out.println("메뉴 확인 : 9");
					isRunMenu = false;
					break;

				case 1:
					view.showMultipleMenu(2);
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
