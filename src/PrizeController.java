
public class PrizeController {
	private int spendMoney;
	private int prizedMoney;
	private float earnRate;

	public PrizeController(int gameCount) {
		this.spendMoney = gameCount * 1000;
		this.prizedMoney = 0;
	}

	public void calcPrize(prize pz) {
		this.prizedMoney += pz.getValue();
		this.earnRate = (float)this.prizedMoney / (float)this.spendMoney;
	}

	public void print() {
		System.out.printf("%10d원 을 벌었습니다\n", prizedMoney);
		System.out.printf("%10d원 을 사용\n", spendMoney);
		System.out.printf("수익률 : %.2f ", earnRate);
		if (earnRate > 1) {
			System.out.println("이득입니다.");
		} else if (earnRate == 1) {
			System.out.println("본전입니다.");
		} else
			System.out.println("손해입니다.");
	}
}
