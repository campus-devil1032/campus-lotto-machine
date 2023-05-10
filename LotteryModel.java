import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryModel {

	private ArrayList<Integer> lotteryNum = new ArrayList<Integer>();
	private ArrayList<Integer> luckyNumber = new ArrayList<Integer>();

	private LotteryView view;
	private Scanner scan;
	private int checkPay;
	private int result = 0;
	int lucySize;
	int randomNum;

	public int getScanner() {
		return this.checkPay;
	}

	public void setScanner() {
		scan = new Scanner(System.in);

		int checkPay = scan.nextInt();

		this.checkPay = checkPay;

	}

	// 티켓 구매시 천원 이하 에러 표시
	public void setCalcticketPrice() {
		if (checkPay >= 1000) {
			int dividePay = checkPay / 1000;
			System.out.println(dividePay);

		} else {
			throw new NumberFormatException("돈을 천원 이상 적어주세요.");
		}

	}

	public void setLotteyNum() {

		for (int i = 0; i < 6; i++) {
			System.out.println("로또 번호  1 ~ 45를 한 번호씩 6번 입력하세요.");
			System.out.printf("%d번째 번호입력: ", i + 1);
			int inputNumber = this.scan.nextInt();
			this.lotteryNum.add(inputNumber);

			// Add arraylist sorting
			Collections.sort(this.lotteryNum);
			System.out.printf("입력 번호는 = %s입니다 %n", this.lotteryNum.toString());

		}

	}

	public ArrayList<Integer> getLotteryNum() {
		return this.lotteryNum;
	}

	public void setLuckyNum() {
		// 로또 번호 6개 자동생성후 어레이에 삽입
		for (int i = 0; i < 6; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 45 + 1);
			this.luckyNumber.add(randomNum);
		}
		
		// 중복 랜덤 문제 해결
		lucySize = this.luckyNumber.size();
		int temp = -1;
		for (int i = 0; i < this.lucySize; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(1, 45 + 1);
			if (randomNum == temp) {
				i--;
			} else {
				temp = this.randomNum;
				System.out.println(this.randomNum);
			}
		}
		Collections.sort(this.luckyNumber);

		System.out.printf("로또 번호는 = %s입니다 %n", this.luckyNumber.toString());
	}

	public ArrayList<Integer> getLuckyNum() {
		return this.luckyNumber;
	}

	public int getCalcPrize() {
		return this.result;
	}

//	public void setCalcPrize() {
//		int lotteySize = this.luckyNumber.size();
//		int luckySize = this.lotteryNum.size();
//		
//		for (int i = 0; i < lotteySize-1; i++) {
//			for (int x = 0; x < luckySize-1; x++) {
//				if (this.luckyNumber.indexOf(i) == this.lotteryNum.indexOf(x)) {
//					i++;
//					System.out.printf("총 번호 %d번 당첨입니다\n", ++result);
//					
//					
//					// 중복 당첨 없애기 위해 break 삽입
//					System.out.println("계산 종료");
//					System.out.println(result);
//					
//					if (j == 6) {
//						view.firstPrize();
//						break;
//					}
//					else if (j == 5) {
//						view.seceonPrize();
//						break;
//					}
//					else if (j == 4) {
//						view.thirdPrize();
//						break;
//					}
//					else if (j == 3) {
//						view.fourthPrize();
//						break;
//					}
//					else {
//						view.lostMoney();
//						break;
//					}
//					
//				}
//				
//			}
//			
//		}
}
