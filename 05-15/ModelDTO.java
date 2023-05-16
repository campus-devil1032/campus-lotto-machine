package lotto_machine;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ModelDTO {
		private static Scanner input = new Scanner(System.in);
		private String print;
		private int lotto[];	 //로또 당첨 번호
		private int number[][];	 //로또  게임을 진행한 금액 만큼 생성될 로또 배열
		private int money;		 //로또 게임을 진행할 금액
		private int times;		 //로또 게임 총 진행 횟수
		private int passivity;   //수동 게임 진행 횟수
		private int auto;		 // 자동 게임 진행 회수
		private int number_6;	 // 당첨금 1등
		private int number_5;	 // 당첨금 3등
		private int number_4;	 // 당첨금 4등
		private int number_3;	 // 당첨금 5등
		private int passivity_i; // 수동 로또 행
		private int total_money; // 총 당첨 금액
		private double revenue;  // 수익률
		private boolean check;	 // 당첨 체크
//		private int count;
		

		public ModelDTO() {
			//System.out.println("ModelDTO() 생성자 호출됨!");
//			this.count = 0;
			this.passivity_i = 0;
			this.total_money = 0;
			this.number_6 = 0;
			this.number_5 = 0;
			this.number_4 = 0;
			this.number_3 = 0;
			this.revenue = 0.0;
			this.lotto = new int[6];
			this.check = false;
		}
		
//		public int getCount() {
//			return count;
//		}

//		public void setCount(int count) {
//			this.count = count;
//		}
	
		public int getPassivity_i() {
			return passivity_i;
		}

		public void setPassivity_i(int passivity_i) {
			this.passivity_i = passivity_i;
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
		
		}
		
		public void setPrint(String print) {
			this.print = print;
		}
	
		public void selectSwitch() { //메뉴 스위치 함수
			
			View.Menu();
			
			int n = 0;
			
			while(true) {
			
				n = input.nextInt();
				
				switch(n) {
			
					case 1:
						System.out.println("=====<로또 게임>=====");
						input();
						
						System.out.println("=======<당청 번호>=====");
						randGame(this.lotto);
						View.gameView(this.lotto);
						
						compare();
						check = false;
						View.Menu();;
						break;
					case 2:	
						valueOf(); //당첨 통계
						View.Menu();
						break;
					case 3:
						System.out.println("※이전 게임에 대한 수익률 입니다.");
						System.out.println("※수익률은 다음 게임 마다 초기화 됩니다.");
						System.out.println("수익률: ");
						Money.money_Manage(this.total_money,this.number,this.number_6,this.number_5,this.number_4,this.number_3,this.revenue,this.times);
						View.Menu();
						break;
					case 4:
						System.out.println("게임 리셋~!!!");
						this.number_6 = 0;
						this.number_5 = 0;
						this.number_4 = 0;
						this.number_3 = 0;
						View.Menu();
						break;
					case 5:
						input.close();
						System.out.println("프로그램을 정상적으로 종료!");
						System.exit(0);
					default:
						System.out.println("잘못된 문자를 입력하셨습니다.");
						View.Menu();
			
				}
			}
		
		}
		
	
		
		public void valueOf() { // 로또 당첨 통계 뷰
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
		
	
		
		public static void randGame(int[] lotto) { // 로또 게임 생성기
		
			//System.out.println("로또 번호 : ");
			for (int i = 0; i < lotto.length; i++) {
				int num = (int) (Math.random() * 45) + 1;
				lotto[i] = num;
				for (int j = 0; j < i; j++) {
					if (lotto[i] == lotto[j]) {
						i--;
						break;
					}
				}

			}
			
			Arrays.sort(lotto);
			
		}
		
	
		
		
		public void input() { //로또 게임을 진행할 금액을 입력 받는 함수
			this.revenue = 0.0; //수익률 다시 초기화
			
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
			
			//duplication_Verification();
			View.passivity_view(this.passivity,this.number,this.lotto);
			View.auto_view(this.auto,this.times,this.passivity,this.lotto,this.number);
		}

		public void passivty_Game() { //수동 게임
			
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
		
		public void passivity_Ex() { //수동 입력 예외 함수
				
			//	this.count = 0;
				
				try {

					for (this.passivity_i = 0; this.passivity_i < this.passivity; this.passivity_i++) {
						
						if (this.passivity_i >= 0) {
							
							System.out.println("[" + (this.passivity_i+1) +"번째]" +"로또 번호 6개를 입력해 주세요!");
						}else {
							break;
						}
						
						for (int j = 0; j < lotto.length; j++) {
							
							this.number[this.passivity_i][j] = input.nextInt();
							
						}
						
						verification(this.passivity_i);
						
					}
					
				} catch (InputMismatchException e) {
					input = new Scanner(System.in);
					passivity_Ex();
				}
				
		//		if(this.count == 1) {
		//			passivity_Ex();
		//			this.count--;
		//		}
				
			}
		
		public void verification(int k) {  // 검증 함수
			
			for (int i = 0; i < 6; i++) {

				for (int j = 0; j < i; j++) {
				
					if(this.number[k][j] > 45 || this.number[k][j] <= 0) {
						System.out.println("1 ~ 45 사이의 숫자만 입력 가능합니다.");
					
						this.passivity_i--;
						
				//		this.count++;
						
						if(i == 5) {
							this.passivity_i = -1;
						}
						
						break;
						
					}
					
					
					if (this.number[k][i] == this.number[k][j]) {
							
							this.passivity_i--;
					
							System.out.println("중복된 숫자!");
							
							if(i == 5) {
								this.passivity_i = -1;
							}
							break;
						
					}

				}
				
			}
		}
		
		
	
		
		
		
		public void compare() { 	//비교 함수: 돈으로 구매한 로또와 당첨 로또 번호와 비교
			
			System.out.println("-----<result>-----");
			
			int count = 1;
			
			for (int i = 0; i < this.times; i++) {
					count = 1;
				for(int j = 0; j<lotto.length; j++) {
					if (this.number[i][j] != this.lotto[j]) {
						//System.out.println("낙첨되셨습니다!");
						
						break;
					}
						
					
					if(count == 6) {
							check = true;
							System.out.println("[" + (i+1) + "] "+ "1등 당첨되셨습니다!");
							this.number_6++;
							
					}
					else if(count == 5) {
						check = true;
						System.out.println("[" + (i+1) + "] "+ "3등 당첨되셨습니다!");
						this.number_5++;
					}
					else if(count ==4) {
						check = true;
						System.out.println("[" + (i+1) + "] "+ "4등 당첨되셨습니다!");
						this.number_4++;
					}
					else if(count ==3) {
						check = true;
						System.out.println("[" + (i+1) + "] "+ "5등 당첨되셨습니다!");
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
		
	
	
