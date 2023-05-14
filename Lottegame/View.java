package lotteGame;

import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);

			int[] a = new int[5];
			LottoController lotto = new LottoController();
			a = lotto.startGame();
			lotto.statistics(a);
			System.out.println("종료하려면 1, 계속하시려면 아무 숫자 입력");
			int ar = sc.nextInt();
			if (ar == 1) {
				break;
			} else {
				continue;
			}
		}
	}
}
