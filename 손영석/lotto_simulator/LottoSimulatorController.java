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
		view.viewInputMenuMessage();
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
					view.viewExitMessage();
					isRunClient = false;
					break;

				case 1: // 수동
					manualType();
					break;

				case 2: // 자동
					autoType();
					break;

				default: // 다른 값 입력 시
					view.viewInputErrorMessage();
					break;
				}
			} catch (InputMismatchException e) {
				view.viewInputErrorMessage();
				userInput.nextLine(); // 스캐너 초기화
				continue;
			}
		}
	}

	// 수동
	public void manualType() {

		boolean isRunMenu = true;

		model.generateLottoNum(); // 번호 생성
		view.showInnerMenu(1); // 수동 메뉴화면

		while (isRunMenu) {
			try {
				int userSelect = getUserInput();
				switch (userSelect) {

				case 0: // 뒤로가기
					view.viewPreviousMenuMessage();
					isRunMenu = false;
					break;

				case 1: // 번호 재생성
					model.generateLottoNum();
					view.viewRegenerateMessage();
					break;

				case 2: // 번호 입력
					inputUserNum();
					printMyNum();
					break;

				case 3: // 당첨 번호 확인
					printLottoNum();
					break;

				case 4: // 당첨 확인
					System.out.println("일치하는 번호 개수: " + model.checkMatchLotto());
					if (model.checkMatchBonus() == true) { // 보너스 번호가 일치할때
						System.out.println("+ 보너스 번호 일치");
					}
					if (model.checkMatchLotto() <= 2) { // 꽝
						System.out.println(model.checkRank());
					}
					if (model.checkMatchLotto() > 2) { // 당첨
						System.out.println(model.checkRank() + " 상금은 " + model.checkPrize() + " 원입니다.");
					}
					break;

				case 5: // 여러장 구매
					view.showMultiPurchasesMenu(1);
					multipleMenu();
					break;

				case 9: // 메뉴 다시보기
					view.showInnerMenu(1);
					break;

				default: // 다른 값 입력 시
					view.viewInputErrorMessage();
					break;
				}
			} catch (InputMismatchException e) {
				view.viewInputErrorMessage();
				userInput.nextLine(); // 스캐너 초기화
				continue;
			}
		}
	}

	// 자동
	public void autoType() {

		boolean isRunMenu = true;

		model.generateLottoNum(); // 번호 생성
		model.generateAutoNum(); // 내 번호 생성
		view.showInnerMenu(2); // 자동 메뉴화면

		while (isRunMenu) {
			try {
				int userSelect = getUserInput(); // 메뉴 선택
				switch (userSelect) {

				case 0: // 뒤로가기
					view.viewPreviousMenuMessage();
					isRunMenu = false;
					break;

				case 1: // 번호 재생성
					model.generateLottoNum();
					model.generateAutoNum();
					view.viewRegenerateMessage();
					break;

				case 2: // 자동 번호 출력
					printMyNum();
					break;

				case 3: // 당첨 번호 출력
					printLottoNum();
					break;

				case 4: // 당첨 확인
					System.out.println("일치하는 번호 개수: " + model.checkMatchLotto());
					if (model.checkMatchBonus() == true) { // 보너스 번호가 일치할때
						System.out.println("+ 보너스 번호 일치");
					}
					if (model.checkMatchLotto() <= 2) { // 꽝
						System.out.println(model.checkRank());
					}
					if (model.checkMatchLotto() > 2) { // 당첨
						System.out.println(model.checkRank() + " 상금은 " + model.checkPrize() + " 원입니다.");
					}
					break;

				case 5: // 여러장 구매
					view.showMultiPurchasesMenu(1);
					multipleMenu();
					break;

				case 9: // 메뉴 다시보기
					view.showInnerMenu(2);
					break;

				default: // 다른 값 입력 시
					view.viewInputErrorMessage();
					break;
				}

			} catch (InputMismatchException e) {
				view.viewInputErrorMessage();
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

				case 0: // 뒤로가기
					view.viewPreviousMenuMessage();
					view.viewMenuGuideMessage();
					isRunMenu = false;
					break;

				case 1: // 구매 매수 입력 후 번호 생성
					view.showMultiPurchasesMenu(2);
					model.setNumOfPurchases(getUserInput());
					model.generateMultiNum(model.getNumOfPurchases());
					view.showMultiPurchasesMenu(3);
					break;

				case 2: // 내 번호 출력
					view.viewMyNumberMessage();
					model.printMyNumList();
					break;

				case 3: // 당첨 번호 출력
					printLottoNum();
					break;

				case 4: // 당첨 확인
					// System.out.println(model.numOfMatchArrays());
					break;

				case 5: // 통계
					break;

				case 9: // 메뉴 다시보기
					view.showMultiPurchasesMenu(1);
				}

			} catch (InputMismatchException e) {
				view.viewInputErrorMessage();
				userInput.nextLine();
				continue;
			}
		}

	}

}
