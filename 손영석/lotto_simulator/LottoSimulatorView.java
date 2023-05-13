package lotto_simulator;

public class LottoSimulatorView {
	LottoSimulatorController control = new LottoSimulatorController();

	// 메인메뉴
	public void showMainMenu() {
		System.out.println("<로또 시뮬레이터>");
		System.out.println("1 : 수동번호");
		System.out.println("2 : 자동번호");
		System.out.println("0 : 종료");
		System.out.println("----------");
	}

	// 수동 메뉴
	public void showManualMenu() {

	}

	// 자동 메뉴
	public void showAutoMenu() {
		System.out.println("<자 동 메 뉴>");
		System.out.println("0 : 뒤로가기");
		System.out.println("1 : 번호 재생성");
		System.out.println("2 : 생성 번호 확인");
		System.out.println("3 : 당첨 번호 확인");
		System.out.println("4 : 당첨 확인");
		System.out.println("9 : 메뉴 다시보기");
		System.out.println("----------");
	}
}
