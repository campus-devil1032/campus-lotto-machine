enum prize {
	NONE(0), FIRST(200000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000);

	private final int value;

	prize(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

public class LottoMachineMain {

	public static void main(String[] args) {
		levelTwo();
	}
	
	static void levelOne() {
		prize pz;
		System.out.println("숫자 6개를 입력해주세요(1~45)");
		ControlString cs = new ControlString();
		Lotto lottoInput = new Lotto(cs.getString());
		
		Lotto lottoWin = new Lotto();

		System.out.printf("입력받은 번호 : ");
		lottoInput.printNumber();
		System.out.printf("자동생성 번호 : ");
		lottoWin.printPrizeNumber();
		pz=lottoWin.checkWin(lottoInput.getLottoSet());
		System.out.println("당첨 여부" + pz);
	}
	
	static void levelTwo() {
		System.out.printf("게임수를 입력해주세요 :");
		ControlString sc = new ControlString();
		
		int gameCount = Integer.parseInt(sc.getString());
		PrizeController pc = new PrizeController(gameCount);
		
		Lotto[] gameLotto = new Lotto[gameCount];
		for(int loop = 0; loop<gameCount;loop++) {
			gameLotto[loop] = new Lotto();
			gameLotto[loop].printNumber();
		}
		Lotto lottoWin = new Lotto();
		System.out.println("당첨 번호");
		lottoWin.printPrizeNumber();
		
		for(int loop = 0; loop<gameCount; loop++) {
			pc.calcPrize(lottoWin.checkWin(gameLotto[loop].getLottoSet()));
		}
		pc.print();
	}
}
