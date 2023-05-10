package lotto_machine;

import java.util.Scanner;

public class ModelDTO {
		private static Scanner input = new Scanner(System.in);
		private String print;
		private int lotto[];
		
		
		public ModelDTO() {
			//System.out.println("ModelDTO() 생성자 호출됨!");
			this.lotto = new int[6];
		}
		
		public int[] getLotto() {
			return lotto;
		}

		public void setLotto(int[] lotto) {
			this.lotto = lotto;
		}

		public String getPrint() {
			System.out.println("[정상출력] " + print);
			
		
			randGame();
			
			
			gameView();
		
			return print;
		}
		public void setPrint(String print) {
			this.print = print;
		}
	
		
		public void randGame() {
		
			System.out.println("로또 번호 : ");
			for (int i = 0; i < this.lotto.length; i++) {
				int num = (int) (Math.random() * 45) + 1;
				this.lotto[i] = num;
				for (int j = 0; j < i; j++) {
					if (this.lotto[i] == this.lotto[j]) {
						i--;
						break;
					}
				}

			}
		}
		
		public void gameView() {
			for(int i = 0; i < this.lotto.length; i++) {
				System.out.print(this.lotto[i] + " ");
			}
		}
		
}
