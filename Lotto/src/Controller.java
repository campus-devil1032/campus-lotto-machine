import java.util.Scanner;

public class Controller {
	public static void main(String[] args) {
		LottoUser user = new LottoUser(); // 객체 생성
		LottoMaker lotto = new LottoMaker(); // 객체 생성
		Scanner sc = new Scanner(System.in);

		//로또 게임을 실행, LottoMaker class에서 lottoGame을 불러옵니다.
		user.lottoGame(sc);
		
		//로또 당첨 여부를 알려줍니다.
		while (true) {
			System.out.println("당첨을 확인하시려면 1을 누르고 엔터를 쳐주세요");
			int choice = sc.nextInt();
			if (choice == 1) { // 당첨결과 알림
				System.out.println("당첨결과");
				user.lottoResult(lotto.getCount()); // LottoMaker에서 lottoResult를 불러옵니다.
				break;
			}

		}
	}
}
