import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public class Lotto {
	private ArrayList<Integer> lottoSet;
	private int bonus;

	public Lotto() {
		lottoSet = new ArrayList<Integer>();
		this.makeNumber(6);
	}

	public Lotto(String input) {
		lottoSet = new ArrayList<Integer>();
		StringTokenizer st;
		st = new StringTokenizer(input, " ");
		while (st.hasMoreTokens()) {
			this.lottoSet.add(Integer.parseInt(st.nextToken()));
		}
		this.lottoSet.sort(Comparator.naturalOrder());

	}

	private void makeNumber(int count) { // ���Ȯ���� ���� �⺻��
		Random random = new Random();
		lottoSet.clear(); // ���ڸ� �ֱ��� �ʱ�ȭ. ������ �����Ͱ� �����ִ°�츦 ���.
		while (this.lottoSet.size() < count) {
			int temp = random.nextInt(45) + 1;
			if (!this.lottoSet.contains(temp)) {
				this.lottoSet.add(temp);
			}
		}
		while (true) {
			int temp = random.nextInt(45) + 1;
			if (!this.lottoSet.contains(temp)) {
				bonus = temp;
				break;
			}
		}
		this.lottoSet.sort(Comparator.naturalOrder());
	}

	public prize checkWin(ArrayList<Integer> userInput) {
		int winCounter = 0;
		for (int checkCounter = 0; checkCounter < userInput.size(); checkCounter++) {
			if (this.lottoSet.contains(userInput.get(checkCounter))) {
				winCounter++;
			}
		}
		switch (winCounter) {
		case 6:
			return prize.FIRST;
		case 5:
			if (this.lottoSet.contains(bonus)) {
				return prize.SECOND;
			} else {
				return prize.THIRD;
			}
		case 4:
			return prize.FOURTH;
		case 3:
			return prize.FIFTH;
		}
		return prize.NONE;
	}

	public void printNumber() { // ��¿� �Լ�.
		if (this.lottoSet.size() == 0) {
			System.out.println("��ȣ�� �������� �ʾҽ��ϴ�.");
			return;
		}
		for (int counter = 0; counter < this.lottoSet.size(); counter++) {
			System.out.printf("%02d ", this.lottoSet.get(counter));
		}
		System.out.println();
	}
	
	public void printPrizeNumber() {
		this.printNumber();
		System.out.printf("���ʽ� ��ȣ : %02d\n",this.bonus);
	}

	public ArrayList<Integer> getLottoSet() {
		return (this.lottoSet);
	}
}
