package lotteGame;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoController {
	LottoModel lottoModel = new LottoModel();
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> lottoAnswer = new ArrayList<Integer>();

	public int startGame() {
		// 이거는 사용자 로또번호 전체 모을 2차원리스트

		System.out.println("금액입력: ");
		int money = sc.nextInt();
		System.out.println("수동횟수: "); // 나중에 수동횟수가 금액보다 높으면 터트리기
		int manualTime = sc.nextInt();
		int total = lottoModel.gameStartMoney(money);
		int countNum = 0;
		int prize = 0;

		int[] countArray = new int[total];
		int[] bounsArray = new int[total];
		lottoAnswer = lottoModel.lottoAnswerMaker();

		// 유저가 입력한값 반환
		for (countNum = 0; countNum < manualTime; countNum++) {
			System.out.println("로또번호 입력:");
			ArrayList<Integer> lottoUser = lottoModel.lottoUserInput();
			countArray[countNum] = lottoModel.checkValue(lottoAnswer, lottoUser);
			bounsArray[countNum] = lottoModel.checkBouns(lottoAnswer, lottoUser);
		}

		for (; countNum < total; countNum++) {
			ArrayList<Integer> lottoAi = lottoModel.lottoRandomMaker();
			countArray[countNum] = lottoModel.checkValue(lottoAnswer, lottoAi);
			bounsArray[countNum] = lottoModel.checkBouns(lottoAnswer, lottoAi);
		}
		for (int i = 0; i < total; i++) {
			prize += lottoModel.winCount(countArray[i], bounsArray[i]);
		}
		return prize;
	}

}