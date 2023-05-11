
import java.util.Arrays;
import java.util.Scanner;

public class LotteryController {
	LotteryModel model;
	LotteryView view;
	private int fianlResult;

	LotteryController(LotteryModel model, LotteryView view) {
		this.model = model;
		this.view = view;
	}

	public void setIntro() {
		model.setScanner();
	}

	public void setLotteryNum() {
		model.setLotteyNum();
	}

	public void getWinnerSpin() {
		this.fianlResult = model.getWinnerSpin();
	}

	public void getOperation() {

		view.checkPay();
		model.setScanner();

		// 티켓 구매시 천원 이하 에러 표시
		model.setCalcticketPrice();

		// 자동으로 나온 로또 번호 계산
		model.setLuckyNum();

		// 입력한 로또 번호 계산
		model.setLotteyNum();


		model.setWinnerSpin();

		model.setSumMatchingNumber();
		// Arraylist.length 체크
	}

	public void setCheckWinner() {
		getWinnerSpin();
		if (fianlResult == 6) {
			view.firstPrize();

		} else if (fianlResult == 5) {
			view.seceonPrize();

		} else if (fianlResult == 4) {
			view.thirdPrize();

		} else if (fianlResult == 3) {
			view.fourthPrize();

		} else {
			view.lostMoney();
		}
	}

}
