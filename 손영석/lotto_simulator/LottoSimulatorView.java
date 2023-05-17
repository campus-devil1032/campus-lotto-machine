package lotto_simulator;

public class LottoSimulatorView {
	static LottoSimulatorController controller = new LottoSimulatorController();

	public void printMessage(String message) {
		System.out.println("[LOTTO]" + message);
	}
	
	public void printMessage() {
		System.out.println("");
	}
	
	// 메인메뉴
	public void showMainMenu() {
		System.out.println("<로또 시뮬레이터>");
		System.out.println("1 : 수동로또");
		System.out.println("2 : 자동로또");
		System.out.println("0 : 종료");
		System.out.println("----------");
	}

	// 자동 메뉴
	public void showInnerMenu(int index) {
		if (index == 1) { // 수동메뉴
			System.out.println("<수 동 메 뉴>");
			System.out.println("0 : 뒤로가기");
			System.out.println("1 : 당첨번호 재생성");
			System.out.println("2 : 번호 입력");
			System.out.println("3 : 당첨 번호 확인");
			System.out.println("4 : 당첨 확인");
			System.out.println("5 : 여러장 구매");
			System.out.println("9 : 메뉴 다시보기");
			System.out.println("----------");
		}
		if (index == 2) { // 자동메뉴
			System.out.println("<자 동 메 뉴>");
			System.out.println("0 : 뒤로가기");
			System.out.println("1 : 번호 재생성");
			System.out.println("2 : 생성 번호 확인");
			System.out.println("3 : 당첨 번호 확인");
			System.out.println("4 : 당첨 확인");
			System.out.println("5 : 여러장 구매");
			System.out.println("9 : 메뉴 다시보기");
			System.out.println("----------");
		}
	}

	// 다중 구매 메뉴
	public void showMultiPurchasesMenu(int index) {
		if (index == 1) {
			System.out.println("<여러장 구매>");
			System.out.println("0 : 뒤로가기");
			System.out.println("1 : 구매 매수 입력");
			System.out.println("2 : 내 번호 보기");
			System.out.println("3 : 당첨 번호 보기");
			System.out.println("4 : 당첨 확인");
			System.out.println("5 : 통계 보기");
			System.out.println("9 : 메뉴 다시보기");
			System.out.println("----------");
		}

		if (index == 2) {
			System.out.println("구매할 매수를 입력하세요.");
		}

		if (index == 3) {
			System.out.println("번호가 생성되었습니다.");
			System.out.println("내 번호 보기 : 2");
		}
	}

	public void viewInputMenuMessage() {
		printMessage("1~45 사이의 숫자를 입력하세요.");
	}


	public void viewExitMessage() {
		printMessage("시뮬레이터를 종료합니다.");
	}

	public void viewPreviousMenuMessage() {
		printMessage("이전 메뉴로 돌아갑니다.");
	}

	public void viewRegenerateMessage() {
		printMessage("번호가 재생성되었습니다.");
	}

	public void viewMyNumberMessage() {
		printMessage("내 번호:");
	}

	public void viewMenuGuideMessage() {
		printMessage("메뉴 확인 : 9");
	}

	public void viewInputErrorMessage() {
		System.err.println("올바른 번호를 입력해주세요.");
	}

	public void printMyNum() {
		System.out.println("내 로또 번호는 ");
		System.out.print("[ ");
		for (int i = 0; i < 6; i++) {
			System.out.print(controller.getMyNum(i) + " ");
		}
		System.out.println("]\n입니다.");
	}

	public void printLottoNum() {
		System.out.println("당첨 번호는 ");
		System.out.print("[ ");
		for (int i = 0; i < 6; i++) {
			System.out.print(controller.getLottoNum(i) + " ");
		}
		System.out.print("+ 보너스 " + controller.getBonusNum());
		System.out.println("]\n입니다.");
	}
}
