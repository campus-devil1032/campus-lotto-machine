public class LotteryController {
	LotteryModel model;
	LotteryView view;

	LotteryController(LotteryModel model, LotteryView view) {
		this.model = model;
		this.view = view;
	}

	public void getScan() {
		model.setScan();
	}

	public void getLottryNum() {
		model.getLotteryNum();
	}

	public void getOperation() {
		view.checkPay();
		model.setScan();

		if (model.getScan() == 1000) {

			model.setLotteyNum();

			model.setLuckyNum();

			// 당첨 번호 매칭
			model.setwinnerPickUp();

		}
	}

}
