
public class PrizeController {
	private int spendMoney;
	private int prizedMoney;
	
	public PrizeController(int gameCount) {
		this.spendMoney = gameCount*1000;
		this.prizedMoney = 0;
	}
	
	public void calcPrize(prize pz) {
		this.prizedMoney += pz.getValue();
	}
	
	public void print() {
		System.out.printf("%10d¿ø\n",spendMoney);
		System.out.printf("%10d¿ø\n",prizedMoney);
	}
}
