import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryMVCMain {
	int[] lotteryNum;
	int[] luckyNumber;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		Scanner scan = new Scanner(System.in);
		System.out.println("지불할 금액을 1000원 단위로 입력하세요.");

		int checkPay = scan.nextInt();
		System.out.println("로또 번호  1 ~ 45를 한 번호씩 6번 입력하세요.");
		
		// 입력 금액 확인
		if (checkPay == 1000) {

			int[] lotteryNum = new int[6];
			
			// 로또 번호 입력 후 어레이에 삽입
			for (int i = 0; i < 6; i++) {
				System.out.printf("%d번째 번호입력: ", i + 1);
				int inputNumber = scan.nextInt();
				lotteryNum[i] = inputNumber;
			}
			
			
			

			int[] luckyNumber = new int[6];
			
			// 로또 번호 6개 자동생성후 어레이에 삽입
			for (int i = 0; i < 6; i++) {
				int randomNum = ThreadLocalRandom.current().nextInt(1, 45 + 1);
				luckyNumber[i] = randomNum;
			}
			// sorting
			Arrays.sort(luckyNumber);

			System.out.printf("로또 번호는 = %s입니다 %n", Arrays.toString(luckyNumber));
			
			
			
			

			// sorting
			Arrays.sort(lotteryNum);
			System.out.printf("입력 번호는 = %s입니다 %n", Arrays.toString(lotteryNum));
			
			
			// 당첨 번호 매칭
			for (int i = 0, j = 0; i < luckyNumber.length; i++) {
				for (int x = 0; x < lotteryNum.length; x++) {
					if (luckyNumber[i] == lotteryNum[x]) {
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
}

//개발 난이도 1단계
//게임에 적용 시킬 로또 번호 6개를 입력 받는다. 그리고 자동으로 로또 번호를 생성해준다.
//이어서 게임 시작을 누르면 자동으로 당첨 번호가 생성되고 이후 당첨 통계를 콘솔로 확인할 수 있다.
//개발 난이도 2단계
//로또 게임을 진행 할 금액을 입력 받는다.
//로또는 한 게임 당 천원이다. (한 게임 당 여섯개의 번호가 발급된다.)
//입력 금액과 로또 한장의 금액이 나눠 떨어져야 한다. (검증로직)
//1회 구매 한도는 최소 천원이상이다.
//수동으로 발급 할 로또 게임 수를 입력 받는다. 그리고 그 수에 맞게 로또 번호를 입력 받는다.
//이어서 수동 발급 장수를 제외한 장수만큼 자동으로 로또 티켓을 생성한다.
//로또 한 게임에는 여섯 개의 정수가 중복 없이 존재한다.
//로또 번호는 1 ~ 45 이다.
//입력 받은 번호는 오름차순으로 정렬 된다.
//로또 티켓 구매가 완료 되면 게임을 시작한다.
//로또게임 한 회차당 여섯개의 당첨번호와 보너스 볼이 존재한다.
//당첨 번호는 중복되는 숫자가 없는 정수 값이다.
//보너스 볼 역시 당첨번호와 중복되어선 안된다.
//상금은 아래와 같다.
//3개 일치 시 상금 : 5,000원
//4개 일치 시 상금 : 50,000원
//5개 일치 시 상금 : 1,500,000원
//5개 일치 + 보너스 볼 상금 : 30,000,000원
//6개 일치 상금 : 2,000,000,000원 (20억)
//당첨 결과를 기준으로 구체적인 수익률과 수익률에 대한 해석을 출력할 수 있다.
//수익률 = 당첨금액 / 구매금액
//수익률에 따른 해석은 아래를 따른다
//수익률 < 1 : 손해
//수익률 = 1 : 본전
//수익률 > 1 : 이익