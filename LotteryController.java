
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
	// 로또 구매에 지불할 금액 입력
	public void setLotteryNum() {
		model.setLotteyNum();
	}

	public void getWinnerSpin() {
		this.fianlResult = model.getWinnerSpin();
	}

	public void getOperation() {
		// 인트로 콘솔 
		view.checkPay();
		
		// 로또구매 지불금액 입력
		model.setScanner();

		// 티켓 구매시 천원 이하 에러 표시
		model.setCalcticketPrice();

		// 입력한 로또 번호 계산
		model.setLotteyNum();

		// 자동으로 나온 로또 번호 계산
		model.setLuckyNum();
		
		// 로또 랜덤 번호와 수동 입력 번호 매칭 
		model.setWinnerSpin();
		
		// 당첨된 번호로 갯수 파악
		model.setSumMatchingNumber();
	
	}

	public void getCheckWinner() {
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
