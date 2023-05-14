package lotteGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class LottoModel {
	private static int bounsNumber; // 보너스점수는 따로 관리

	// 로또 게임 진행 금액 입력
	public int gameStartMoney(int money) {
		// 천원당 1게임
		if (money % 1000 == 0) {
			return money / 1000;
		} else {
			System.out.println("1000단위로 입력하세요");
			return 0;
		}

	}

	// 로또 난수 생성기 + 보너스는 별도로 빼두기
	public ArrayList<Integer> lottoMaker(Boolean typeConfi) {
		Random rd = new Random();
		ArrayList<Integer> lottoArray = new ArrayList<Integer>();
		
		while (true) {
			int num = rd.nextInt(45) + 1; // 1~45랜덤 난수 생성
			// contains은 콜렉션 인터페이스에서 인수가 해당 컬레션에 포함되어있는지 확인하는 메서드
			if (!lottoArray.contains(num)) {
				lottoArray.add(num);
			}
			if (lottoArray.size() == 7) {
				break;
			}
		}
		// 불린값에 따라서 자동인지 아님 정답인지 결정
		if (typeConfi) {
			bounsNumber = lottoArray.get(6);
			lottoArray.remove(6);
			lottoArray.sort(Comparator.naturalOrder());// 리스트 오름차순 배열
		} else {
			lottoArray.remove(6);
		}
		return lottoArray;
	}

	// 로또번호 입력 받기
	public ArrayList<Integer> lottoUserInput() throws UserException {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> userLottoArray = new ArrayList<Integer>();

		// 유저가 입력한 로또 번호 + 1~45이외는 예외처리
		while (true) {
			int num = sc.nextInt();
			if (num >= 1 && num <= 45) {
				if (!userLottoArray.contains(num)) {
					userLottoArray.add(num);
				} else {
					System.out.println("중복값 입력하지 마세요..");
					// 이상한거 import되어있는지 확인
					throw new UserException("중복값");
				}
				if (userLottoArray.size() == 6) {
					userLottoArray.sort(Comparator.naturalOrder());
					break;
				}
			} else {
				System.out.println("1~45사이를 입력하세요....");
				throw new UserException("1~45사이를 입력하세요....") {
				};
			}
		}
		return userLottoArray;
	}

	// 입력 받은 값들이 일치여부
	public int checkValue(ArrayList<Integer> answer, ArrayList<Integer> userInput) {
		// arrayList의 get()은 Object로 반환
		int count = 0;

		for (int i = 0; i < answer.size(); i++) {
			for (int j = 0; j < userInput.size(); j++) {
				if (answer.get(i) == userInput.get(j)) {
					count++;
				}
			}
		}
		return count;
	}

	// 보너스 값 일치여부 확인
	public int checkBouns(ArrayList<Integer> answer, ArrayList<Integer> userInput) {
		int bounsCount = 0;
		for (int j = 0; j < userInput.size(); j++) {
			if (bounsNumber == userInput.get(j)) {
				bounsCount = -6;
			}
		}

		return bounsCount;
	}

	// 당첨에 대한 반환
	public int winCount(int countNum, int bounsNum) {
		int money = 0;
		switch (countNum + bounsNum) {
		case 3:
			money = 5000;
			break;
		case 4:
			money = 50000;
			break;
		case 5:
			money = 1500000;
			break;
		case -1:
			money = 30000000;
			break;
		case 6:
			money = 2000000000;
			break;
		default:
			break;
		}
		return money;
	}

	// 통계(오버로드)
	public int[] winCount(int[] countArray, int[] bounsArray) {
		int[] prizeArray = { 0, 0, 0, 0, 0 };

		for (int i = 0; i < countArray.length; i++) {
			switch (countArray[i] + bounsArray[i]) {
			case 3:
				prizeArray[4]++;
				break;
			case 4:
				prizeArray[3]++;
				break;
			case 5:
				prizeArray[2]++;
				break;
			case -1:
				prizeArray[1]++;
				break;
			case 6:
				prizeArray[0]++;
				break;
			default:
				break;
			}
		}
		return prizeArray;
	}

	// 수익률 계산
	public void earningRate(int insertMoney, int earnMmoney) {
		try {
			double rate = earnMmoney / insertMoney;
			if (rate > 1) {
				System.out.printf("%d만큼 이득 ^^\n", insertMoney - earnMmoney);
			} else if (rate == 1) {
				System.out.printf("본전 ㅎㅎ\n", insertMoney - earnMmoney);
			} else if (rate < 1) {
				System.out.printf("%d만큼 손해 ㅠㅠ\n", insertMoney - earnMmoney);
			}

		} catch (ArithmeticException e) {
		}

	}
}
