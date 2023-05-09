import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryModel {
	
	int[] lotteryNum = new int[6];
	int[] luckyNumber = new int[6];
	int checkPay;
	Scanner scan;
	
	
	public int getScan() {
	
		return this.checkPay;
	}

	public void setScan() {
		scan = new Scanner(System.in);
	
		int checkPay = scan.nextInt();
		System.out.println("로또 번호  1 ~ 45를 한 번호씩 6번 입력하세요.");
		this.checkPay = checkPay;
	}
	
	public void setLotteyNum() {
		// 로또 번호 입력 후 어레이에 삽입
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d번째 번호입력: ", i + 1);
			int inputNumber = scan.nextInt();
			this.lotteryNum[i] = inputNumber;
		}
		// sorting
		Arrays.sort(lotteryNum);
		System.out.printf("입력 번호는 = %s입니다 %n", Arrays.toString(lotteryNum));
	}
	
	public int[] getLotteryNum() {
		return lotteryNum;
	}
	
	public void setLuckyNum() {
	
		
		// 로또 번호 6개 자동생성후 어레이에 삽입
		for (int i = 0; i < 6; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 45 + 1);
			this.luckyNumber[i] = randomNum;
		}
		// sorting
		Arrays.sort(luckyNumber);

		System.out.printf("로또 번호는 = %s입니다 %n", Arrays.toString(luckyNumber));
		
	}
	
	public void setwinnerPickUp() {
		for (int i = 0, j = 0; i < this.luckyNumber.length; i++) {
			for (int x = 0; x < this.lotteryNum.length; x++) {
				if (this.luckyNumber[i] == this.lotteryNum[x]) {
					i++;
					System.out.printf("총 번호 %d번 당첨입니다\n", ++j);
					if (j == 6) {
						System.out.println("6개 일치 상금 : 2,000,000,000원 (20억)");
					}
					else if (j == 5) {
						System.out.println("5개 일치 + 보너스 볼 상금 : 30,000,000원");
					}
					else if (j == 4) {
						System.out.println("4개 일치 시 상금 : 50,000원");
					}
					else if (j == 3) {
						System.out.println("3개 일치 시 상금 : 5,000원");
					}
					else if (j >= 2) {
						System.out.println("꽝입니다.");
					}
					
				}
				
			}
			
		}
	}

	

}
