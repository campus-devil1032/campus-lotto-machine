import java.util.Arrays;
import java.util.Scanner;

public class LotteryController {
	LotteryModel model;
	LotteryView view;
	private int[] lotteryNum;
	private int[] luckyNumber;
	private Scanner scan;
	private int checkPay;
	
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
	
	


	public void getOperation() {
			view.checkPay();
			model.setScanner();
			model.setLotteyNum();
			model.setLuckyNum();
			
		if (this.checkPay == 1000) {
			
			
			getForLoop();

		}
	}
	
	public void getForLoop() {
		for (int i = 0, j = 0; i < this.luckyNumber.length; i++) {
			for (int x = 0; x < this.lotteryNum.length; x++) {
				if (this.luckyNumber[i] == this.lotteryNum[x]) {
					i++;
					System.out.printf("총 번호 %d번 당첨입니다\n", ++j);
					if (j == 6) {
						view.firstPrize();
					}
					else if (j == 5) {
						view.seceonPrize();
					}
					else if (j == 4) {
						view.thirdPrize();
					}
					else if (j == 3) {
						view.fourthPrize();
					}
					else if (j >= 2) {
						view.lostMoney();
					}
					
				}
				
			}
			
		}
	}

}
