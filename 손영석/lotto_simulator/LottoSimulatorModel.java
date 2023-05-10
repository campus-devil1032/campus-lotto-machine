package lotto_simulator;

import java.util.InputMismatchException;

public class LottoSimulatorModel {
	static LottoSimulatorView view = new LottoSimulatorView();

	// 로또 번호 생성하기
	public void generateNum() {
		int randomNum[] = new int[6];
		int checkNum; // 중복체크용 변수

		// 랜덤번호 생성
		for (int i = 0; i < randomNum.length; i++) {
			randomNum[i] = (int) ((Math.random() * 45) + 1); // 1~45 난수생성

			// 여기부터 중복체크
			checkNum = randomNum[i];

			for (int j = 0; j < i; j++) {
				if (randomNum[j] == checkNum) {
					i--; // 중복 시 한단계 이전으로
					break;
				}
			}
			// 랜덤번호 저장
			view.setRandomNum(i, randomNum[i]);
		}

		// 당첨번호 생성
		for (int i = 0; i < randomNum.length; i++) {
			randomNum[i] = (int) ((Math.random() * 45) + 1); // 1~45 난수생성

			// 여기부터 중복체크
			checkNum = randomNum[i];

			for (int j = 0; j < i; j++) {
				if (randomNum[j] == checkNum) {
					i--; // 중복 시 한단계 이전으로
					break;
				}
			}
			// 당첨번호 저장
			view.setLottoNum(i, randomNum[i]);
		}
	}

	// 수동
	public void manualType() {
		while (true) {
			try {
				view.inputUserNum();
				view.outputUserNum();
			} catch (InputMismatchException e) {
				System.err.println("잘못된 입력입니다. 다시 입력하세요.");
				view.userInput.nextLine(); // 스캐너 초기화
			}
		}
	}

	// 자동 번호 출력
	public void printRandomNum() {
		System.out.println("내 로또 번호는 ");
		for (int i = 0; i < 6; i++) {
			System.out.print(view.getRandomNum(i) + " ");
		}
		System.out.println("\n입니다.");
	}
	
	// 당첨 번호 출력
	public void printLottoNum() { // 당첨 번호 출력
		System.out.println("당첨 번호는 ");
		for (int i = 0; i < 6; i++) {
			System.out.print(view.getLottoNum(i) + " ");
		}
		System.out.println("\n입니다.");
	}
	
	// 당첨 개수 확인
	public void checkWinNum() {
		int count = 0; // 일치하는 번호 개수
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (view.getRandomNum(i) == view.getLottoNum(j)) {
					count++;
				}
			}
		}
		System.out.println("당첨 번호 개수: " + count);
	}
}
