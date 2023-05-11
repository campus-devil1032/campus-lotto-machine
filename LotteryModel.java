import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryModel {

	private ArrayList<Integer> lotteryNum = new ArrayList<Integer>();
	private ArrayList<Integer> luckyNumber = new ArrayList<Integer>();
	private ArrayList<Integer> matchNumber = new ArrayList<Integer>();
	private Scanner scan;
	private int checkPay;
	private int result = 0;

	int LuckySize;

	public int getScanner() {
		return this.checkPay;
	}

	// 로또 구매에 지불할 금액 입력
	public void setScanner() {
		scan = new Scanner(System.in);
		int checkPay = scan.nextInt();
		this.checkPay = checkPay;
	}

	// 티켓 구매시 천원 이하 에러 표시
	public void setCalcticketPrice() {
		if (checkPay >= 1000) {
			int dividePay = checkPay / 1000;
			System.out.printf("로또 티켓은 %d장 구매했습니다.%n",dividePay);
		} else {
			throw new NumberFormatException("돈을 천원 이상 적어주세요.");
		}

	}

	public void setLotteyNum() {
		// 로또 수동 입력
		for (int i = 0; i < 6; i++) {
			System.out.println("로또 번호  1 ~ 45를 한 번호씩 6번 입력하세요.");
			System.out.printf("%d번째 번호입력: ", i + 1);
			int inputNumber = this.scan.nextInt();
			this.lotteryNum.add(inputNumber);
			Collections.sort(this.lotteryNum);
			System.out.printf("입력 번호는 = %s입니다 %n", this.lotteryNum.toString());
			// 로또 번호 미리 파악
//			System.out.printf("로또 번호는 = %s입니다 %n", this.luckyNumber.toString());
		}
	}

	public ArrayList<Integer> getLotteryNum() {
		return this.lotteryNum;
	}

	public void setLuckyNum() {
		// 로또 번호 6개 자동생성후 어레이에 삽입
		int temp = -1;
		for (int i = 0; i < 6; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 45 + 1);
			this.luckyNumber.add(randomNum);

			if (randomNum == temp) {
				i--;

			} else {
				temp = randomNum;
			}
		}

		Collections.sort(this.luckyNumber);

		System.out.printf("로또 번호는 = %s입니다 %n", this.luckyNumber.toString());

	}

	public ArrayList<Integer> getLuckyNum() {
		return this.luckyNumber;
	}

	public void setWinnerSpin() {
		// 로또 랜덤 번호와 수동 입력 번호 매칭 
		for (Integer a : lotteryNum)
			matchNumber.add(luckyNumber.contains(a) ? 1 : 0);

	}

	public void setSumMatchingNumber() {
		// 당첨된 번호로 갯수 파악
		for (int i = 0; i < matchNumber.size(); i++) {
			this.result += matchNumber.get(i);
		}
		System.out.printf("당첨된 번호 갯수는 %d입니다.", this.result);

	}

	public int getWinnerSpin() {
		return this.result;
	}

}
