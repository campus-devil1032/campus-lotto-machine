package lotto_simulator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoSimulatorView {
	static LottoSimulatorModel model = new LottoSimulatorModel();

	private int[] inputNum = new int[6]; // 입력값을 담을 배열
	private int[] randomNum = new int[6]; // 랜덤번호를 담을 배열
	private int[] lottoNum = new int[6]; // 당첨번호를 담을 배열

	Scanner userInput = new Scanner(System.in);

	// 수동
	public int getInputNum(int index) { // 입력값 getter
		Arrays.sort(inputNum); // 오름차순 정렬 후 반환
		return inputNum[index];
	}

	public void setInputNum(int index, int value) { // 입력값 setter
		inputNum[index] = value;
	}

	// 자동
	public int getRandomNum(int index) { // 랜덤번호 getter
		Arrays.sort(randomNum); // 오름차순 정렬 후 반환
		return randomNum[index];
	}

	public void setRandomNum(int index, int value) { // 랜덤번호 setter
		randomNum[index] = value;
	}

	public int getLottoNum(int index) { // 당첨번호 getter
		Arrays.sort(lottoNum); // 오름차순 정렬 후 반환
		return lottoNum[index];
	}

	public void setLottoNum(int index, int value) { // 당첨번호 setter
		lottoNum[index] = value;
	}

	// 수동입력
	public int getUserInput() { // 사용자 입력
		int input = userInput.nextInt();
		userInput.nextLine();
		return input;
	}

	public void inputUserNum() { // 6개 사욪자 입력값 받아오기
		System.out.println("1~45 사이의 숫자를 입력하세요.");
		System.out.println("(메뉴로 돌아가기: 숫자 0)");
		for (int i = 0; i < 6; i++) {
			System.out.print((i + 1) + "번 숫자 : ");
			setInputNum(i, getUserInput());
		}
	}

	public void outputUserNum() { // 사용자 입력값 출력하기
		System.out.println("내 입력값:");
		for (int i = 0; i < 6; i++) {
			System.out.print(getInputNum(i) + " ");
		}
		System.out.println(""); // 줄바꿈
	}

	/**
	 * 여기부터 사용자 인터페이스
	 */
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
	}

	// 수동 자동 선택
	public void mainMenu() {
		boolean isRunClient = true;
		while (isRunClient) {
			try {

				showMainMenu();

				int userSelect = getUserInput();

				switch (userSelect) {

				case 0: // 종료
					System.out.println("시뮬레이터를 종료합니다.");
					isRunClient = false;
					break;

				case 1: // 수동
					model.manualType();
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
	
	// 자동
	public void autoType() {
		boolean isRunAuto = true;

		model.generateNum(); // 번호 생성
		showAutoMenu(); // 자동 메뉴화면

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
					model.checkWinNum();
					break;
					
				case 9: // 메뉴 다시보기
					showAutoMenu();
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
