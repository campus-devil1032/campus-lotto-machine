import java.util.Scanner;

public class LottoUser {
	// 유저가 로또번호를 랜덤으로 받을지, 입력할지 선택
	public void lottoGame(Scanner sc) {
		LottoMaker lottomaker = new LottoMaker();
		System.out.println("로또게임에 오신 것을 환영합니다!");
		System.out.println("========Menu=======");
		System.out.println("1.수동로또");
		System.out.println("2.자동로또");
		System.out.println("0.종료");

		while (true) {
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("=======수동로또=======");
				lottomaker.lottoInput(sc);
				break;
			} else if (choice == 2) {
				System.out.println("=======자동로또=======");
				lottomaker.lottoRandom();
				break;
			} else if (choice == 0) {
				System.out.println("종료합니다.");
			}

		}
	}

	// 로또 당첨여부를 확인합니다
	public void lottoResult(int count) {
		// switch로 count 개수를 세고, 당첨여부를 판단합니다.
		switch (count) {
		case 6: {
			System.out.println("1등 입니다!");
		}
		case 5: {
			System.out.println("2등 입니다!");
		}
		case 4: {
			System.out.println("3등 입니다!");
		}
		case 3: {
			System.out.println("4등 입니다!");
		}
		default: {
			System.out.println("꽝입니다!");
		}
		}

	}
}
