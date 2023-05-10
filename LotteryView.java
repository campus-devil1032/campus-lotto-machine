
public class LotteryView {


	
	public void checkPay() {
		StringBuffer intro = new StringBuffer("지불할 금액을 1000원 단위로 입력하세요.");
		intro.append(" 로또 티켓 한장 정확히 천원");
		System.out.println(intro);
	}
	
	public void firstPrize() {
		StringBuffer firstPrize = new StringBuffer("6개 일치 상금 : 2,000,000,000원 (20억)");
		System.out.println(firstPrize);
	}
	
	public void seceonPrize() {
		StringBuffer secondPize = new StringBuffer("5개 일치 + 보너스 볼 상금 : 30,000,000원");
		secondPize.append(" 축하드립니다!");
		System.out.println(secondPize);
	}
	
	public void thirdPrize() {
		System.out.println("4개 일치 시 상금 : 50,000원");
	}
	
	public void fourthPrize() {
		System.out.println("3개 일치 시 상금 : 5,000원");
	}
	
	public void lostMoney() {
		StringBuffer lostMoney = new StringBuffer("꽝입니다");
		lostMoney.append(" 다시 복권 구매해보세요!");
		System.out.println(lostMoney);
	}
	
//	public void setCalcPrize(int result) {
//		
//		if (result == 6) {
//		firstPrize();
//		break;
//	}
//	else if (result == 5) {
//		seceonPrize();
//		break;
//	}
//	else if (result == 4) {
//		thirdPrize();
//		break;
//	}
//	else if (result == 3) {
//		fourthPrize();
//		break;
//	}
//	else {
//		lostMoney();
//		break;
//	}
//		
//	}
}
