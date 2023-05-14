package lotteGame;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoController {
	LottoModel lottoModel = new LottoModel();
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> lottoAnswer = new ArrayList<Integer>();
	private int money = 0;
	private int prize = 0;
	
	

	// 게임 구동기
	public int[] startGame() {
		System.out.println("금액입력: ");
		money = sc.nextInt();
		System.out.println("수동횟수: "); // 나중에 수동횟수가 금액보다 높으면 터트리기
		int manualTime = sc.nextInt();

		int total = lottoModel.gameStartMoney(money);
		int countNum = 0;

		int[] countArray = new int[total];
		int[] bounsArray = new int[total];
		int[] prizeArray = new int[total];
		lottoAnswer = lottoModel.lottoMaker(true);

		// 유저가 입력한값 반환
		for (countNum = 0; countNum < manualTime; countNum++) {
			System.out.println("로또번호 입력:");
			ArrayList<Integer> lottoUser = lottoModel.lottoUserInput();
			countArray[countNum] = lottoModel.checkValue(lottoAnswer, lottoUser);
			bounsArray[countNum] = lottoModel.checkBouns(lottoAnswer, lottoUser);
		}
		// 자동값 배열로 받아서 저장
		for (; countNum < total; countNum++) {
			ArrayList<Integer> lottoAi = lottoModel.lottoMaker(false);
			countArray[countNum] = lottoModel.checkValue(lottoAnswer, lottoAi);
			bounsArray[countNum] = lottoModel.checkBouns(lottoAnswer, lottoAi);
		}
		// 각 당첨된 개수파악 후 금액 반환
		for (int i = 0; i < total; i++) {
			prize += lottoModel.winCount(countArray[i], bounsArray[i]);
		}
		System.out.println("총 당첨금액: " + prize);

		prizeArray = lottoModel.winCount(countArray, bounsArray);

		return prizeArray;
	}

	// 통계 입력
	public void statistics(int[] prizeArray) {
		for (int i = 0; i < 5; i++) {
			System.out.printf("%d등 : %d\n", i + 1, prizeArray[i]);
		}
		lottoModel.earningRate(money, prize);
	}
	
}