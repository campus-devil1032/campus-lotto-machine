
public class LotteryMVCMain {
	int[] lotteryNum;
	int[] luckyNumber;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LotteryModel model = new LotteryModel();
		LotteryView view = new LotteryView();
		LotteryController controller = new LotteryController(model, view);

		controller.getOperation();
		controller.getCheckWinner();

	}

}
