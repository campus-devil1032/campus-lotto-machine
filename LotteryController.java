import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LotteryController {
	LotteryModel model;
	LotteryView view;
	private ArrayList<Integer> lotteryNum;
	private ArrayList<Integer> luckyNumber;
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
			model.setFoopLoop();
	}
	
	public void setForLoop() {
		model.setFoopLoop();
	}

}
