import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

/////////////////////////////////////////////////////////////////////////////////////////////////////로토모델
public class LottoModel {
	private final static int MAXIMUN_TICKET_COUNT = 2000; // 티켓이 생성될수 있는 최대 제한
	private final static int COLLECT_NUMBER_THREE_REWARD = 5000; // 당첨금액 3개
	private final static int COLLECT_NUMBER_FOUR_REWARD = 50000; // 당첨금액 4개
	private final static int COLLECT_NUMBER_FIVE_REWARD = 1500000; // 당첨금액 5개
	private final static int COLLECT_NUMBER_FIVEANDBONUS_REWARD = 30000000; // 당첨금액 5+1
	private final static int COLLECT_NUMBER_SIX_REWARD = 2000000000;// 당첨금액6개
	private int turnNumber = 0; // 게임진행회차 0=>1
	private static int totalTicket = 0; // 전체 발행티켓(게임동안?)
	private int[][] winNumber = new int[1000][6];
	private int[] winBonusNumber = new int[1000];
	private String inputTicketString = "";// 입력받은 로또 갯수

	private double gameTotalReward = 0; // 한게임 전체 수익입니다.
//arraylist 추가해서 당첨번호 횟수단위로 기록하기
//이중배열에 대해 공부하고 적용필요하면 하기	

	public void ticketMaker(Player p) throws IOException { // 티켓구매#0
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		int inputTicketNumber = 0;

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
		for (int i = 0; p.getPlayerTicketNumber() > i; i++) {// 티켓번호
			for (int j = 0; j < 6; j++) {// 당첨번호리스트
				for (int k = 0; k < 6; k++) {// 보유티켓 번호리스트
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
			// 당첨 티켓과 보유 티켓 숫자비교 완료후 일치갯수비교로 상급지급
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
						System.out.println(set);
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

	public static int[][] getChoiceNumber(int number) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		int[][] lottoNumber = new int[MAXIMUN_TICKET_COUNT][6];
		int numberCount = 0;
		String str = "";
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < number; i++) {

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

