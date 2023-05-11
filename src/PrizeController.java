
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
		System.out.printf("%10d�� �� �������ϴ�\n", prizedMoney);
		System.out.printf("%10d�� �� ���\n", spendMoney);
		System.out.printf("���ͷ� : %.2f ", earnRate);
		if (earnRate > 1) {
			System.out.println("�̵��Դϴ�.");
		} else if (earnRate == 1) {
			System.out.println("�����Դϴ�.");
		} else
			System.out.println("�����Դϴ�.");
	}
}
