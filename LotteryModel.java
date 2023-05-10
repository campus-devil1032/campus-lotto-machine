import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryModel {

	private ArrayList<Integer> lotteryNum = new ArrayList<Integer>();
	private ArrayList<Integer> luckyNumber = new ArrayList<Integer>();
	int lotteySize = lotteryNum.size();
	int luckySize = luckyNumber.size();
	public LotteryView view;
	private Scanner scan;
	public int checkPay;


	public int getScanner() {
		return this.checkPay;
	}

	public void setScanner() {
		scan = new Scanner(System.in);

		int checkPay = scan.nextInt();
		
		this.checkPay = checkPay;
		
		
	}

	public void setLotteyNum() {
//	 if(checkPay == 1000) {
		
		 for (int i = 0; i < 6; i++) {
			 System.out.println("로또 번호  1 ~ 45를 한 번호씩 6번 입력하세요.");
				System.out.printf("%d번째 번호입력: ", i + 1);
				int inputNumber = this.scan.nextInt();
				this.lotteryNum.add(inputNumber);
				
				// Add arraylist sorting
				Collections.sort(this.lotteryNum);
				System.out.printf("입력 번호는 = %s입니다 %n", this.lotteryNum.toString());
			
			}
//	 } else {
//		 System.out.println("정확히 천원만 입력하세요!");
//		 System.out.println("정확히 천원만 입력하세요!");
//		 System.out.println("정확히 천원만 입력하세요!");
//	 }
		
		
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
		// Add arraylist sorting
		Collections.sort(this.luckyNumber);

		System.out.printf("로또 번호는 = %s입니다 %n", this.luckyNumber.toString());
	
	}

	public ArrayList<Integer> getLuckyNum() {
		return this.luckyNumber;
	}
	
	
	public void setFoopLoop() {
		luckySize = luckyNumber.size();
		lotteySize = lotteryNum.size();
		// 
		for (int i = 0, j = 0; i < lotteySize; i++) {
			for (int x = 0; x < lotteySize; x++) {
				if (luckyNumber.indexOf(i) == lotteryNum.indexOf(x)) {
					i++;
					System.out.printf("총 번호 %d번 당첨입니다\n", ++j);
					if (j == 6) {
						this.view.firstPrize();
					}
					else if (j == 5) {
						this.view.seceonPrize();
					}
					else if (j == 4) {
						this.view.thirdPrize();
					}
					else if (j == 3) {
						this.view.fourthPrize();
					}
					else if (j >= 2) {
						this.view.lostMoney();
					}
					
				}
				
			}
			
		}
	}

}
