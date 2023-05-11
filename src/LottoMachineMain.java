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
		while(true) {
			levelTwo();			
		}
	}
	
	static void levelOne() {
		prize pz;
		System.out.println("���� 6���� �Է����ּ���(1~45)");
		ControlString cs = new ControlString();
		Lotto lottoInput = new Lotto(cs.getString());
		
		Lotto lottoWin = new Lotto();

		System.out.printf("�Է¹��� ��ȣ : ");
		lottoInput.printNumber();
		System.out.printf("�ڵ����� ��ȣ : ");
		lottoWin.printPrizeNumber();
		pz=lottoWin.checkWin(lottoInput.getLottoSet());
		System.out.println("��÷ ����" + pz);
	}
	
	static void levelTwo() {
		System.out.printf("���Ӽ��� �Է����ּ��� :");
		ControlString sc = new ControlString();
		int gameCount = Integer.parseInt(sc.getString());
		PrizeController pc = new PrizeController(gameCount);
		
		Lotto[] gameLotto = new Lotto[gameCount];
		for(int loop = 0; loop<gameCount;loop++) {
			gameLotto[loop] = new Lotto();
			gameLotto[loop].printNumber();
		}
		Lotto lottoWin = new Lotto();
		System.out.println("��÷ ��ȣ");
		lottoWin.printPrizeNumber();
		
		for(int loop = 0; loop<gameCount; loop++) {
			pc.calcPrize(lottoWin.checkWin(gameLotto[loop].getLottoSet()));
		}
		pc.print();
	}
}
