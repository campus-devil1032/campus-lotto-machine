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
			
//			model.getLotteryNum();
//			
//			model.getLuckyNum();

			// 당첨 번호 매칭
//			model.setwinnerPickUp();
			
			for (int i = 0, j = 0; i < this.luckyNumber.length; i++) {
				for (int x = 0; x < this.lotteryNum.length; x++) {
					if (this.luckyNumber[i] == this.lotteryNum[x]) {
						i++;
						System.out.printf("총 번호 %d번 당첨입니다\n", ++j);
						if (j == 6) {
							System.out.println("6개 일치 상금 : 2,000,000,000원 (20억)");
						}
						else if (j == 5) {
							System.out.println("5개 일치 + 보너스 볼 상금 : 30,000,000원");
						}
						else if (j == 4) {
							System.out.println("4개 일치 시 상금 : 50,000원");
						}
						else if (j == 3) {
							System.out.println("3개 일치 시 상금 : 5,000원");
						}
						else if (j >= 2) {
							System.out.println("꽝입니다.");
						}
						
					}
					
				}
				
			}
			
			

		}
	}

}
