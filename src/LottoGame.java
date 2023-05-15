import java.util.Random; //난수
import java.util.Scanner;
import java.util.TreeSet;//트리셋 숫자저장법

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays; //배열 정렬을 위해서
import java.util.InputMismatchException;

///////구매제한은 100까지
///////////////////////////////TreeSet활용 코드 뜯어고치기
public class LottoGame {
	public static void main(String[] args) {
		GameController.run();
	}

}

//////////////////////////////treeset.retainAll() 좋은기능!!!
class GameController{
	public static void run() { //컨트롤러쪽으로 넣기.
		LottoModel l = new LottoModel();
		Player owner = new Player(100000000, "user"); // 유저 입력받게 수정
		Scanner sc = new Scanner(System.in);
		String commandLine = "";
		int commandChoice = 0;

		game: for (; true;) {
			ConsolViewer.menu();
			commandLine = sc.nextLine();
			if (LottoModel.isInteger(commandLine)) {
				commandChoice = Integer.parseInt(commandLine);
			} else {
				System.out.println("1,2,3중에 입력해주세요.");
				continue;
			}
			switch (commandChoice) {
			case 1: {
				try {
					l.ticketMaker(owner);// 티켓구매#0
					l.setWinNumber();// 당첨번호 설정#2
					l.winnerChecker(owner);// 티켓비교#3 //후 당첨금분배#4
				} catch (IOException e) {
					System.out.println("입력이 옳바르지 않습니다.");
				}
				break;
			}
			case 2: {
				ConsolViewer.viewWin(owner);
				break;
			}
			case 3: {
				System.out.println("종료합니다.");
				break game;
			}
			default: {

			}
			}
		}
	}
}
class ConsolViewer {
	

	public static void menu() {
		System.out.println("=======================================");
		System.out.println("1. 로또");
		System.out.println("2. 당첨 현황");
		System.out.println("3. 종료");
		System.out.println("=======================================");
	}

	public static void viewWin(Player p) {
		System.out.println("=======================================");
		System.out.println("1등 : " + p.getReward1());
		System.out.println("2등 : " + p.getReward2());
		System.out.println("3등 : " + p.getReward3());
		System.out.println("4등 : " + p.getReward4());
		System.out.println("5등 : " + p.getReward5());
		System.out.println("전체티켓 : " + p.getTotalBuyTicket());
		System.out.println("=======================================");
	}

}

/////////////////////////////////////////////////////////////////////////////////////////////////////로토모델 완성후 새파일에 public붙여서 분리가능
class LottoModel {
	private final static int MAXIMUN_TICKET_COUNT = 2000; // 티켓이 생성될수 있는 최대 제한
	private final static int COLLECT_NUMBER_THREE_REWARD = 5000; // 당첨금액 3개
	private final static int COLLECT_NUMBER_FOUR_REWARD = 50000; // 당첨금액 4개
	private final static int COLLECT_NUMBER_FIVE_REWARD = 1500000; // 당첨금액 5개
	private final static int COLLECT_NUMBER_FIVEANDBONUS_REWARD = 30000000; // 당첨금액 5+1
	private final static int COLLECT_NUMBER_SIX_REWARD = 2000000000;// 당첨금액6개
	private int turnNumber = 0; // 게임진행회차 0=>1
	private static int totalTicket = 0; // 전체 발행티켓(게임동안?)
	private String[] winnerList = new String[20];
	private int[][] winNumber = new int[1000][6];
	private int[] winBonusNumber = new int[1000];
	private String inputTicketString = "";// 입력받은 로또 갯수
	private int inputTicketNumber = 0;
	private double gameTotalReward = 0; // 한게임 전체 수익입니다.
//arraylist 추가해서 당첨번호 횟수단위로 기록하기
//이중배열에 대해 공부하고 적용필요하면 하기	

	public void ticketMaker(Player p) throws IOException { // 티켓구매#0
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));

		if (p.getPlayerMoney() < 1000) {
			System.out.println("한 장 살돈도 없어요. 손님");
			return;
		}
		for (; true;) {
			System.out.println("구매하실 장수를 입력해주세요. 최대 100장까지 가능합니다.");
			inputTicketString = bfrd.readLine();
			if (isInteger(inputTicketString)) {
				inputTicketNumber = Integer.parseInt(inputTicketString);
				if (inputTicketNumber > 100) {
					System.out.println("인당 100장까지만 구입가능합니다.");
					continue;
				}
				break;
			}
		}

		if (p.getPlayerMoney() >= inputTicketNumber * 1000) {
			p.playerLoseMoney(1000 * inputTicketNumber);
			p.setPlayerTicketList(LottoModel.getRandomNumber(inputTicketNumber));// 티켓구매부분#1
			p.setPlayerTicketNumber(inputTicketNumber); // 플레이어 보유티켓갯수 설정
			System.out.println(p.getPlayerMoney() + "원 남았습니다.");
		} else {
			System.out.println("돈이 부족해요.");
		}
	}

	public void winnerChecker(Player p) { // 티켓비교#3
		int collectCount = 0;// 일치갯수
		int specialCollectCount = 0;
		int[][] playerTicket;
		int checkerx = 0;
		int checkery = 0;
		playerTicket = p.getPlayerTicketList();
		System.out.println("보유하신 티켓애 대한 로토 당첨확인을 시~~~~~~~~작~~~~~~~~~~~하겠습니다~");
		for (int i = 0; p.getPlayerTicketNumber() > i; i++) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 6; k++) {
					checkerx = playerTicket[i][k];
					checkery = winNumber[turnNumber][j];
					if (checkerx == checkery) {
						collectCount += 1;
					}
					if (playerTicket[i][k] == winBonusNumber[turnNumber]) {
						specialCollectCount += 1;
					}
				}

			}

			System.out.println(Arrays.toString(playerTicket[i]) + "  " + collectCount + "개 일치");
			win(p, collectCount, specialCollectCount);// #4 상금 지급
			collectCount = 0;
			specialCollectCount = 0;
		}
		this.gameTotalReward /= (p.getPlayerTicketNumber() * 1000);
		System.out.println("수익률 : " + this.gameTotalReward + "배");
		this.gameTotalReward = 0;
	}

	// 숫자를 입력받아서 티켓생성
	/*
	 * public static int[][] getFixedNumber() { return ; }
	 */

	// 자동 숫자로 티켓생성
	public void setWinNumber() {
		turnNumber += 1;
		winNumber[turnNumber] = this.getWinnerNumber();

	}

	// 티켓구매부분#1
	public static int[][] getRandomNumber(int number) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		Random rnd = new Random();
		int[][] lottoNumber = new int[MAXIMUN_TICKET_COUNT][6];
		int numberCount = 0;
		String str = "";
		/* rnd.nextInt(44) + 1; // 1~45까지의 번홀르 생성 */
		for (int i = 0; i < number; i++) {
			for (; true;) {
				// 당첨번호6개 중복없이 뽑기 이후 정렬
				lottoNumber[i][numberCount] = rnd.nextInt(44) + 1;
				if (set.add(lottoNumber[i][numberCount]) == true) {
					numberCount += 1;
					if (numberCount == 6) {
						// 숫자 정렬해야함.
						Arrays.sort(lottoNumber[i]);
						str = Arrays.toString(lottoNumber[i]);
						System.out.println("구매하신 로토 번호는 : " + str);
						totalTicket += 1; // 전체발행티켓+1
						numberCount = 0;
						set.clear();
						break;

					}
				}
			}
		}
		return lottoNumber;
	}

	public int[] getWinnerNumber() { // 당첨번호 설정#2
		TreeSet<Integer> set = new TreeSet<Integer>();
		Random rnd = new Random();
		int[] lottoNumber = new int[6];
		int numberCount = 0;
		String str = "";
		/* rnd.nextInt(44) + 1; // 1~45까지의 번홀르 생성 */
		for (; true;) {
			// 당첨번호6개 중복없이 뽑기 이후 정렬
			lottoNumber[numberCount] = rnd.nextInt(44) + 1;
			if (set.add(lottoNumber[numberCount]) == true) {
				numberCount += 1;

				if (numberCount == 6) {
					while (set.add(winBonusNumber[turnNumber] = rnd.nextInt(44) + 1) == false) {
					} // 마지막 숫자 보너스
						// 숫자 정렬해야함.
					Arrays.sort(lottoNumber);

					str = Arrays.toString(lottoNumber) + "보너스 + " + Integer.toString(winBonusNumber[turnNumber]);
					System.out.println(" ");
					System.out.println("1등 로토 번호는 : " + str);
					System.out.println(" ");
					numberCount = 0;
					set.clear();
					break;
/////////////////////////////////////////////////////////////////////////보너스 숫자 개념 필요
				}
			}
		}
		return lottoNumber;
	}

	public void win(Player p, int count, int bonuscount) {// #4 상금 지급
		// 당첨금 지급 함수 실행
		// 스위치문활용 collectCount , Special카운터 확인해서 당첨 몇등체크 등수만 입력하면 새로운 함수 호출해서 당첨금 지급하게
		switch (count) {
		case 3: {
			p.playerEarnMoney(COLLECT_NUMBER_THREE_REWARD);
			this.gameTotalReward += COLLECT_NUMBER_THREE_REWARD;
			System.out.println("5등 당첨 " + COLLECT_NUMBER_THREE_REWARD + "원 축하드립니다!");
			p.addReward5();
			break;
		}
		case 4: {
			p.playerEarnMoney(COLLECT_NUMBER_FOUR_REWARD);
			this.gameTotalReward += COLLECT_NUMBER_FOUR_REWARD;
			System.out.println("4등 당첨 " + COLLECT_NUMBER_FOUR_REWARD + "원 축하드립니다!");
			p.addReward4();
			break;
		}
		case 5: {
			if (bonuscount == 0) {
				p.playerEarnMoney(COLLECT_NUMBER_FIVE_REWARD);
				this.gameTotalReward += COLLECT_NUMBER_FIVE_REWARD;
				System.out.println("3등 당첨 " + COLLECT_NUMBER_FIVE_REWARD + "원 축하드립니다!");
				p.addReward3();
			} else {
				p.playerEarnMoney(COLLECT_NUMBER_FIVEANDBONUS_REWARD);
				this.gameTotalReward += COLLECT_NUMBER_FIVEANDBONUS_REWARD;
				System.out.println("2등 당첨 " + COLLECT_NUMBER_FIVEANDBONUS_REWARD + "원 축하드립니다!");
				p.addReward2();
			}
			break;
		}
		case 6: {
			p.playerEarnMoney(COLLECT_NUMBER_SIX_REWARD);
			this.gameTotalReward += COLLECT_NUMBER_SIX_REWARD;
			System.out.println("1등 당첨 " + COLLECT_NUMBER_SIX_REWARD + "원 축하드립니다!");
			p.addReward1();
		}
		default: {
			break;
		}
		}
	}

	public double lottoExpectedReturn() { // 기대수익 구현부
		return (double) 1.;
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("정수만 입력하세요.");
			return false;
		}

	}

}

/////////////////////////////////////////////////////////////////////////// 플레이어(유저)
class Player { //controller
	private int money;
	private String name;
	private int[][] ownTicketList = new int[100][6];// 소유티켓
	private int ownTicketNumber = 0;
	private int totalBuyTicket = 0;
	private int reward5 = 0;
	private int reward4 = 0;
	private int reward3 = 0;
	private int reward2 = 0;
	private int reward1 = 0;

	Player(int money, String name) {
		this.money = money;
		this.name = name;
	}

	public int getPlayerMoney() {
		return this.money;
	}

	public void setPlayerMoney(int money) {
		this.money = money;
	}

	public String getPlayerName() {
		return this.name;
	}

	public void playerLoseMoney(int money) {
		this.money -= money;
	}

	public void playerEarnMoney(int money) {
		this.money += money;
	}

	public void setPlayerTicketList(int[][] list) {
		this.ownTicketList = list;
	}

	public int[][] getPlayerTicketList() {
		return this.ownTicketList;
	}

	public void setPlayerTicketNumber(int otn) {
		this.ownTicketNumber = otn;
		this.setTotalBuyTicket(otn);
	}

	public int getPlayerTicketNumber() {
		return this.ownTicketNumber;
	}

	public int getTotalBuyTicket() {
		return totalBuyTicket;
	}

	public void setTotalBuyTicket(int ownticket) {
		this.totalBuyTicket += ownticket;
	}

	public int getReward5() {
		return reward5;
	}

	public void addReward5() {
		reward5 += 1;
	}

	public int getReward4() {
		return reward4;
	}

	public void addReward4() {
		reward4 += 1;
	}

	public int getReward3() {
		return reward3;
	}

	public void addReward3() {
		reward3 += 1;
	}

	public int getReward2() {
		return reward2;
	}

	public void addReward2() {
		reward2 += 1;
	}

	public int getReward1() {
		return reward1;
	}

	public void addReward1() {
		reward1 += 1;
	}
}
