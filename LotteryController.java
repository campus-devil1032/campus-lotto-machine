public class LotteryController {
	LotteryModel model;
	LotteryView view;
	public int[] lotteryNum;
	public int[] luckyNumber;

	LotteryController(LotteryModel model, LotteryView view) {
		this.model = model;
		this.view = view;
	}

	public void getScan() {
		model.setScan();
	}

	public void getLottryNum() {
		this.lotteryNum = model.getLotteryNum();
	}
	
	public void getLuckyNum() {
		this.luckyNumber = model.getLuckyNum();
	}

	public void getOperation() {
		view.checkPay();
		model.setScan();

		if (model.getScan() == 1000) {

			model.setLotteyNum();

			model.setLuckyNum();
			
			
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

}
