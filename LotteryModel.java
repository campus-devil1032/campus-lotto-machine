import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryModel {

	private int[] lotteryNum = new int[6];
	private int[] luckyNumber = new int[6];
	private Scanner scan;
	public int checkPay;


	public int getScanner() {
		return this.checkPay;
	}

	public void setScanner() {
		scan = new Scanner(System.in);

		int checkPay = scan.nextInt();
		
		this.checkPay = checkPay;
		
		System.out.println("로또 번호  1 ~ 45를 한 번호씩 6번 입력하세요.");
	}

	public void setLotteyNum() {
	
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d번째 번호입력: ", i + 1);
			int inputNumber = this.scan.nextInt();
			this.lotteryNum[i] = inputNumber;
			Arrays.sort(this.lotteryNum);
			System.out.printf("입력 번호는 = %s입니다 %n", Arrays.toString(this.lotteryNum));
		
		}
		
	}

	public int[] getLotteryNum() {
		return this.lotteryNum;
	}

	public void setLuckyNum() {

		// 로또 번호 6개 자동생성후 어레이에 삽입
		for (int i = 0; i < 6; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 45 + 1);
			this.luckyNumber[i] = randomNum;
		}
		// sorting
		Arrays.sort(this.luckyNumber);

		System.out.printf("로또 번호는 = %s입니다 %n", Arrays.toString(this.luckyNumber));

	}

	public int[] getLuckyNum() {
		return this.luckyNumber;
	}
	
	
	public void setFoopLoop() {
		
	}

}
