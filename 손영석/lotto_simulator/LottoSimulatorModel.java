package lotto_simulator;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoSimulatorModel {
	LottoSimulatorController control = new LottoSimulatorController();

	private int[] myNum = new int[6]; // 내 번호를 담을 배열
	private int[] lottoNum = new int[6]; // 당첨번호를 담을 배열
	private int bonusNum; // 보너스 번호를 담을 변수
	private int numOfPurchases; // 구매 횟수를 담을 변수

	ArrayList<int[]> myNumList = new ArrayList<>(); // 내 번호를 담을 ArrayList

	public void printMyNumList() { // 저장된 리스트 일괄 출력
		for (int[] myNumArray : myNumList) {
			System.out.print("[ ");
			for (int num : myNumArray) {
				System.out.print(num + " ");
			}
			System.out.println("]");
		}
	}

	public int getMyNum(int index) {
		Arrays.sort(myNum);
		return myNum[index];
	}

	public void setMyNum(int index, int value) {
		myNum[index] = value;
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

	// 구매횟수
	public int getNumOfPurchases() {
		return numOfPurchases;
	}

	public void setNumOfPurchases(int value) {
		this.numOfPurchases = value;
	}

	// 로또 번호 생성하기
	public void generateNum() {
		int randomNum[] = new int[6];
		int bonusNum; // 보너스 번호

		// 당첨번호 및 보너스번호 생성
		bonusNum = (int) ((Math.random() * 45) + 1); // 1~45 보너스번호 생성

		for (int i = 0; i < randomNum.length; i++) {
			randomNum[i] = (int) ((Math.random() * 45) + 1); // 1~45 난수생성

			// 중복체크
			for (int j = 0; j < i; j++) {
				if (randomNum[i] == randomNum[j] || randomNum[i] == bonusNum) {
					i--; // 중복 시 한단계 이전으로
					break;
				}
			}
			// 당첨번호 및 보너스번호 저장
			setLottoNum(i, randomNum[i]);
			setBonusNum(bonusNum);
		}
	}

	// 자동 번호 생성하기
	public void generateAutoNum() {
		int randomNum[] = new int[6];

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
			// 자동 번호 저장
			setMyNum(i, randomNum[i]);
		}
		Arrays.sort(randomNum); // 배열 오름차순 정렬 후에
		myNumList.add(randomNum); // ArrayList에 담기
	}

	/**
	 * 번호 다중 생성 메서드
	 * 
	 * @param num 생성횟수
	 */
	public void generateMultiNum(int num) {
		myNumList.clear(); // 생성 전에 이미 생성된 어레이리스트 초기화
		for (int i = 0; i < num; i++) {
			generateAutoNum();
		}
	}

	// 당첨 개수 확인
	public int checkMatch() {
		int count = 0; // 매치하는 번호 개수

		for (int i = 0; i < myNum.length; i++) {
			for (int j = 0; j < myNum.length; j++) {
				if (getMyNum(i) == getLottoNum(j)) {
					count++;
				}
			}
		}
		return count; // 일치 개수 반환
	}

	// 다중 구매 시 당첨 개수 확인
	public int multiCheckMatch(int index) {
		int count = 0;
			int[] myNumArray = myNumList.get(index);
			for (int i = 0; i < myNum.length; i++) {
				for (int j = 0; j < myNum.length; j++) {
					if (myNumArray[i] == getLottoNum(j)) {
						count++;
					}
				}
			}
		return count;
	}

	// 보너스 일치 여부 확인
	public boolean checkBonus() {
		int count = 0; // 일치 여부
		for (int i = 0; i < 6; i++) {
			if (getMyNum(i) == getBonusNum()) {
				count++;
			}
		}
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}

	// 등수
	public String checkRank() {
		return Rank.getRank(checkMatch(), checkBonus()).getRankName();
	}

	// 상금
	public long checkPrize() {
		return Rank.getRank(checkMatch(), checkBonus()).getPrize();
	}
}
