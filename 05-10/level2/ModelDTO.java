package lotto_machine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ModelDTO {
		private static Scanner input = new Scanner(System.in);
		private String print;
		private int lotto[];
		private int number[][];
		private int money;
		private int times;
		private int passivity;
		private int auto;
		private int number_6;
		private int number_5;
		private int number_4;
		private int number_3;
		private int total_money;
		private double revenue;
		private boolean check;
		

		public ModelDTO() {
			//System.out.println("ModelDTO() 생성자 호출됨!");
			this.total_money = 0;
			this.number_6 = 0;
			this.number_5 = 0;
			this.number_4 = 0;
			this.number_3 = 0;
			this.revenue = 0.0;
			this.lotto = new int[6];
			this.check = false;
		}
		
		public int getTotal_money() {
			return total_money;
		}

		public void setTotal_money(int total_money) {
			this.total_money = total_money;
		}
		
		public int getNumber_6() {
			return number_6;
		}

		public void setNumber_6(int number_6) {
			this.number_6 = number_6;
		}

		public int getNumber_5() {
			return number_5;
		}

		public void setNumber_5(int number_5) {
			this.number_5 = number_5;
		}

		public int getNumber_4() {
			return number_4;
		}

		public void setNumber_4(int number_4) {
			this.number_4 = number_4;
		}

		public int getNumber_3() {
			return number_3;
		}

		public void setNumber_3(int number_3) {
			this.number_3 = number_3;
		}
		
		public double getRevenue() {
			return revenue;
		}

		public void setRevenue(double revenue) {
			this.revenue = revenue;
		}
		
		public int getnumber_6() {
			return number_6;
		}

		public void setnumber_6(int number_6) {
			this.number_6 = number_6;
		}
		
		public int getAuto() {
			return auto;
		}

		public void setAuto(int auto) {
			this.auto = auto;
		}
		
		public int getPassivity() {
			return passivity;
		}

		public void setPassivity(int passivity) {
			this.passivity = passivity;
		}
		
		public boolean isCheck() {
			return check;
		}

		public void setCheck(boolean check) {
			this.check = check;
		}

		public int getTimes() {
			return times;
		}

		public void setTimes(int times) {
			this.times = times;
		}

		public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}

		public int[] getLotto() {
			return lotto;
		}

		public void setLotto(int[] lotto) {
			this.lotto = lotto;
		}

		public int[][] getNumber() {
			return number;
		}

		public void setNumber(int[][] number) {
			this.number = number;
		}
		
		
		public String getPrint() {
			System.out.println("[정상출력] " + print);
			
			while (true) {
				
				try {
					selectSwitch();
						
				} catch (InputMismatchException e) {
					System.out.println("잘못된 문자를 입력했습니다!");
					input = new Scanner(System.in);
				}
				
			}	
		
			//return print;
		}
		
		
		public void setPrint(String print) {
			this.print = print;
		}
	
		
		public void selectSwitch() {
			
			Menu();
			
			int n = 0;
			
			while(true) {
			
				n = input.nextInt();
				
				switch(n) {
			
					case 1:
						System.out.println("=====<로또 게임>=====");
						input();
						
						System.out.println("=======<당청 번호>=====");
						randGame();
						gameView();
						
						compare();
						check = false;
						Menu();
						break;
					case 2:	
						valueOf();
						Menu();
						break;
					case 3:
						System.out.println("※이전 게임에 대한 수익률 입니다.");
						System.out.println("※수익률은 다음 게임 마다 초기화 됩니다.");
						System.out.println("수익률: ");
						this.total_money += this.number_6*2000000000;
						this.total_money += this.total_money + (this.number_5*1500000);
						this.total_money += this.total_money + (this.number_4*50000);
						this.total_money += this.total_money + (this.number_3*5000);
						revenue = (double)this.total_money/this.times;
						System.out.println(revenue);
						Menu();
						break;
					case 4:
						System.out.println("게임 리셋~!!!");
						this.number_6 = 0;
						this.number_5 = 0;
						this.number_4 = 0;
						this.number_3 = 0;
						Menu();
						break;
					case 5:
						input.close();
						System.out.println("프로그램을 정상적으로 종료!");
						System.exit(0);
					default:
						System.out.println("잘못된 문자를 입력하셨습니다.");
						Menu();
			
				}
			}
		
			
		}
		
		public void valueOf() {
			System.out.println("==========<<당첨 시 금액>>==========");
			System.out.println("3개 일치 시 상금:5,000원");
			System.out.println("4개 일치 시 상금:50,000원");
			System.out.println("5개 일치 시 상금: 1,500,000원");
			System.out.println("6개 일치 상금: 2,000,000,000원 (20억)");
			System.out.println("===============================");
			
			System.out.println("※프로그램이 돌아가는 동안의 당첨 통계입니다.");
			System.out.println("※게임 메뉴에서 리셋이 가능합니다~!.");
			System.out.println("당첨 통계: ");
			System.out.println("1등 " + this.number_6 + "번");
			System.out.println("3등 " + this.number_5 + "번");
			System.out.println("4등 " + this.number_4 + "번");
			System.out.println("5등 " + this.number_3 + "번");
		}
		
		public void Menu() {
			System.out.println("=========<메 뉴>========");
			System.out.println("1번을 누르면 로또게임을 시작합니다.");
			System.out.println("2번을 누르면 당첨 통계를 확인합니다.");
			System.out.println("3번을 누르면 수익률을 확인합니다.");
			System.out.println("4번을 누르면 게임 리셋 합니다.");
			System.out.println("5번을 누르면 프로그램을 종료합니다.");
			System.out.println("======================");
			System.out.println("입력:");
		}
		
		
		public void randGame() {
		
			//System.out.println("로또 번호 : ");
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
			this.revenue = 0; //수익률 다시 초기화
			
			while(true) {
				try {
					System.out.println("로또 게임을 진행할 금액을 입력해주세요(로또 한장에 1000원):");
					this.money = input.nextInt();
				
					if(this.money % 1000 == 0) {
		
						break;
					}
					
					else if(this.money % 1000 != 0){
						System.out.println("구매 금액이 1000원 단위가 아닙니다.");
					}

				} catch (InputMismatchException e) {
					input = new Scanner(System.in);
					System.out.println("잘못된 입력! 금액을 잘못 입력하셨습니다!");
				}
			}
			
			this.times = this.money/1000; 
		
			this.number = new int[this.times][6];
			
			System.out.println("총" + this.times + "장");
			
			passivty_Game();
			passivity_view();
			auto_Game();
			auto_view();
		}

		public void passivty_Game() {
			//수동 게임
			while (true) {
				try {
					input = new Scanner(System.in);

					System.out.println("수동 몇 장?");
					this.passivity = input.nextInt();
					System.out.println("수동 " + this.passivity + "장");
					break;
					// input = new Scanner(System.in);
				} catch (InputMismatchException e) {
					System.out.println("잘못된 입력!");
				}
			}
			passivity_Ex();

			
			
		}
		
		public void passivity_Ex() {
				
				int count = 0;
				
				try {

					if (this.passivity > 0) {
						System.out.println("로또 번호 6개를 입력해 주세요!");
					}

					for (int i = 0; i < this.passivity; i++) {
						for (int j = 0; j < lotto.length; j++) {
							//this.number[i][j] = (Integer) null;
							this.number[i][j] = input.nextInt();
							if(this.number[i][j] > 45 || this.number[i][j] <= 0) {
								System.out.println("1 ~ 45 사이의 숫자만 입력 가능합니다.");
								//input = new Scanner(System.in);
								count++;
								break;
								
							}
							
						}
						
					}
					
					
				} catch (InputMismatchException e) {
					input = new Scanner(System.in);
					passivity_Ex();
				}
				
				if(count == 1) {
					passivity_Ex();
					count--;
				}
				
				
			}
		
		public void passivity_view() {
			// 수동 뷰
			for (int i = 0; i < this.passivity; i++) {
				System.out.print("[" + (i+1) + "] ");
				for(int j = 0; j < lotto.length; j++) {
					System.out.print(this.number[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		public void auto_Game() {
			//자동 게임
			this.auto = this.times - this.passivity;
			System.out.println("자동 " + this.auto + "장");
		
			
		}
		
		public void auto_view() {
			//자동 뷰
			
			for(int i = 0; i<this.times-this.passivity; i++) {
				randGame();
		
					for(int j = 0; j<lotto.length; j++)
						this.number[i+this.passivity][j] = this.lotto[j];
				System.out.print("[" + (i+this.passivity+1) + "] ");
				gameView();
			}
		}
		
		
		
		public void compare() {
			
			System.out.println("-----<result>-----");
			
			int count = 1;
			
			for (int i = 0; i < this.times; i++) {
					count = 1;
				for(int j = 0; j<lotto.length; j++) {
					if (this.number[i][j] != this.lotto[j]) {
						//System.out.println("낙첨되셨습니다!");
						
						break;
					}
					else {
						if(count == 6) {
							check = true;
							System.out.println("[" + (i+1) + "] "+ "당첨되셨습니다!");
							this.number_6++;
							//break;
					}
				}
					
					if(count == 5) {
						check = true;
						this.number_5++;
					}
					else if(count ==4) {
						check = true;
						this.number_4++;
					}
					else if(count ==3) {
						check = true;
						this.number_3++;
					}
					count++;
				}
			}
			
			
			
			if(this.check == false) {
				System.out.println("전부 꽝!!!");
			}
		}
		
		
}
		
	
	
