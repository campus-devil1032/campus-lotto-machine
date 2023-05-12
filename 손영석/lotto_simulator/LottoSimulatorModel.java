package lotto_simulator;

import java.util.Arrays;

public class LottoSimulatorModel {
	LottoSimulatorController control = new LottoSimulatorController();
	
	private int[] inputNum = new int[6]; // 입력값을 담을 배열
	private int[] randomNum = new int[6]; // 랜덤번호를 담을 배열
	private int[] lottoNum = new int[6]; // 당첨번호를 담을 배열
	private int bonusNum; // 보너스 번호를 담을 배열

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

	// 당첨번호
	public int getLottoNum(int index) { // 당첨번호 getter
		Arrays.sort(lottoNum); // 오름차순 정렬 후 반환
		return lottoNum[index];
	}

	public void setLottoNum(int index, int value) { // 당첨번호 setter
		lottoNum[index] = value;
	}

	// 보너스 번호
	public int getBonusNum() { // 보너스번호 getter
		return bonusNum;
	}

	public void setBonusNum(int value) { // 보너스번호 setter
		bonusNum = value;
	}

	// 수동입력
	public void inputUserNum() { // 6개 사욪자 입력값 받아오기
		System.out.println("1~45 사이의 숫자를 입력하세요.");
		System.out.println("(메뉴로 돌아가기: 숫자 0)");
		for (int i = 0; i < 6; i++) {
			System.out.print((i + 1) + "번 숫자 : ");
			setInputNum(i, control.getUserInput());
		}
	}

	public void outputUserNum() { // 사용자 입력값 출력하기
		System.out.println("내 입력값:");
		for (int i = 0; i < 6; i++) {
			System.out.print(getInputNum(i) + " ");
		}
		System.out.println(""); // 줄바꿈
	}

	// 로또 번호 생성하기
	public void generateNum() {
		int randomNum[] = new int[6];
		int bonusNum; // 보너스 번호

		// 랜덤번호 생성
		for (int i = 0; i < randomNum.length; i++) {
			randomNum[i] = (int) ((Math.random() * 45) + 1); // 1~45 난수생성

			// 여기부터 중복체크
			for (int j = 0; j < i; j++) {
				if (randomNum[i] == randomNum[j]) {
					i--; // 중복 시 한단계 이전으로
					break;
				}
			}
			// 랜덤번호 저장
			setRandomNum(i, randomNum[i]);
		}

		// 당첨번호 및 보너스번호 생성
		bonusNum = (int) ((Math.random() * 45) + 1); // 1~45 보너스번호 생성

		for (int i = 0; i < randomNum.length; i++) {
			randomNum[i] = (int) ((Math.random() * 45) + 1); // 1~45 난수생성

			// 여기부터 중복체크
			for (int j = 0; j < i; j++) {
				if (randomNum[i] == randomNum[j] || randomNum[i] == bonusNum) {
					i--; // 중복 시 한단계 이전으로
					break;
				}
			}
			// 당첨번호 저장
			setLottoNum(i, randomNum[i]);
			setBonusNum(bonusNum);
		}
	}

	// 자동 번호 출력
	public void printRandomNum() {
		System.out.println("내 로또 번호는 ");
		for (int i = 0; i < 6; i++) {
			System.out.print(getRandomNum(i) + " ");
		}
		System.out.println("\n입니다.");
	}

	// 당첨 번호 출력
	public void printLottoNum() { // 당첨 번호 출력
		System.out.println("당첨 번호는 ");
		for (int i = 0; i < 6; i++) {
			System.out.print(getLottoNum(i) + " ");
		}
		System.out.print("+ 보너스 " + getBonusNum());
		System.out.println("\n입니다.");
	}

	// 당첨 개수 확인
	public int checkWinNum() {
		int count = 0; // 일치하는 번호 개수
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (getRandomNum(i) == getLottoNum(j)) {
					count++;
				}
			}
		}
		// 일치하는 개수 반환
		return count;
	}

	// 보너스 여부 확인
	public boolean checkBonusNum() {
		int count = 0; // 일치 여부
		for (int i = 0; i < 6; i++) {
			if (getRandomNum(i) == getBonusNum()) {
				count++;
			}
		}
		// count 1일 경우 true 반환
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}
}
