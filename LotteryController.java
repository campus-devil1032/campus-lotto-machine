import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LotteryController {
	LotteryModel model;
	LotteryView view;
	private ArrayList<Integer> lotteryNum;
	private ArrayList<Integer> luckyNumber;
	private int checkPay;
	private int result;

	LotteryController(LotteryModel model, LotteryView view) {
		this.model = model;
		this.view = view;
	}

	public void getScan() {
		this.checkPay = model.getScanner();
	}

	public void setIntro() {
		model.setScanner();
	}

	public void getLottryNum() {
		this.lotteryNum = model.getLotteryNum();
	}

	public void setLotteryNum() {
		model.setLotteyNum();
	}

	public void getLuckyNum() {
		this.luckyNumber = model.getLuckyNum();
	}

	public void getCalcPrize() {
		this.result = model.getCalcPrize();
	}

	public void getOperation() {

		view.checkPay();
		model.setScanner();

		// 티켓 구매시 천원 이하 에러 표시
		model.setCalcticketPrice();

		// 입력한 로또 번호 계산
		model.setLotteyNum();

		// 자동으로 나온 로또 번호 계산
		model.setLuckyNum();

//			model.setCalcPrize();

		// Arraylist.length 체크

	}

	public void getWinnerSpin() {
		int lotteySize = this.luckyNumber.size();
		int luckySize = this.lotteryNum.size();

		for (int i = 0, j = 0; i < lotteySize - 1; i++) {
			for (int x = 0; x < luckySize - 1; x++) {
				if (this.luckyNumber.indexOf(i) == this.lotteryNum.indexOf(x)) {
					i++;
					System.out.printf("총 번호 %d번 당첨입니다\n", ++j);

					// 중복 당첨 없애기 위해 break 삽입
					if (j == 6) {
						view.firstPrize();
						break;
					} else if (j == 5) {
						view.seceonPrize();
						break;
					} else if (j == 4) {
						view.thirdPrize();
						break;
					} else if (j == 3) {
						view.fourthPrize();
						break;
					} else {
						view.lostMoney();
						break;
					}

				}

			}

		}
	}

}
