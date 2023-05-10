package lotto_machine;

import java.util.Scanner;

public class ModelDTO {
		private static Scanner input = new Scanner(System.in);
		private String print;
		private int lotto[];
		private int number[];
		
		
		public ModelDTO() {
			//System.out.println("ModelDTO() 생성자 호출됨!");
			this.lotto = new int[6];
			this.number = new int[6];
		}
		
		public int[] getLotto() {
			return lotto;
		}

		public void setLotto(int[] lotto) {
			this.lotto = lotto;
		}

		public int[] getNumber() {
			return number;
		}

		public void setNumber(int[] number) {
			this.number = number;
		}
		
		
		public String getPrint() {
			System.out.println("[정상출력] " + print);
			
			input();
			
		
			randGame();
			
			
			gameView();
			
			
			compare();
		
			return print;
		}
		public void setPrint(String print) {
			this.print = print;
		}
	
		
		public void selectSwitch() {
			menu();
			
		
			
		}
		
		public void menu() {
			System.out.println("======<메 뉴>=====");
			System.out.println("1. 1번을 누르면 로또를 구매할 금액을 입력하게 됩니다.");
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
			for(int i = 0; i < lotto.length; i++) {
				System.out.print(this.lotto[i] + " ");
			}
			
			System.out.println();
		}
		
		
		public void input() {
			System.out.println("로또 번호 6개를 입력해 주세요!");
			
			for(int i =0; i<number.length; i++)
				this.number[i] = input.nextInt();
			
			
			for(int i =0; i<number.length; i++)
				System.out.print(this.number[i]+ " ");
			
			System.out.println();
		}

		public void compare() {
			
			int count = 1;
			
			for (int i = 0; i < 6; i++) {
				if (this.number[i] != this.lotto[i]) {
					System.out.println("낙첨되셨습니다!");
					break;
				}
				else {
					if(count == 6) {
						System.out.println("당첨되셨습니다!");
					}
				}
				count++;
				
				
			}
			
			
			
		}
}
		
	
	
