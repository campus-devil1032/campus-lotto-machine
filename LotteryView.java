import java.util.Scanner;

public class LotteryView {

	public void checkPay() {
		System.out.println("지불할 금액을 1000원 단위로 입력하세요.");
	}
	
	public void firstPrize() {
		System.out.println("6개 일치 상금 : 2,000,000,000원 (20억)");
	}
	
	public void seceonPrize() {
		System.out.println("5개 일치 + 보너스 볼 상금 : 30,000,000원");
	}
	
	public void thirdPrize() {
		System.out.println("4개 일치 시 상금 : 50,000원");
	}
	
	public void fourthPrize() {
		System.out.println("3개 일치 시 상금 : 5,000원");
	}
	
	public void lostMoney() {
		System.out.println("꽝입니다.");
	}
}
