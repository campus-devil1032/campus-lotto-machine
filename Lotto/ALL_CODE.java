package Lotto;

import java.util.Random;
import java.util.Scanner;

public class ALL_CODE {
	public static void main(String args[]) {
		Random random = new Random();

		int Money = 100000; // 피같은 내돈
		int benefit = 0; // 수익금
		int gamecount = 0; // 게임횟수
		int gamecontrol; // 수동?자동?
		String num[] = new String[6]; // 입력숫자
		String compareNum[] = new String[6]; // 비교숫자
		int answer = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("게임시작");
		while (true) {
			System.out.println("게임 방법을 선택해주세요 1 : 수동, 2 : 자동");
			gamecontrol = sc.nextInt();

			if (gamecontrol == 1) { // 수동게임
				// 입력 (구분을 위해 3까지 임시로 진행), 45이하 입력 + 중복값 확인
				gamecount++;
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				System.out.println("수동입니다.");
				for (int i = 0; i < 3; i++) {
					System.out.println(i + 1 + "번쨰 값을 입력해주세요");
					num[i] = sc.next();
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
					System.out.print("현재 입력된 코드는 : ");
					for (int j = 0; j < i + 1; j++) {
						System.out.print(num[j] + " ");
					}
					System.out.println("");
				}

			} else { // 자동게임
				for (int i = 0; i < 3; i++) {

					num[i] = String.valueOf(random.nextInt(2) + 1);
				}
			}

			// 도출
			for (int i = 0; i < 3; i++) {
				compareNum[i] = String.valueOf(random.nextInt(2) + 1);
			}
			System.out.println("값 산정이 끝났습니다!");

			// 비교
			for (int i = 0; i < 3; i++) {
				if (compareNum[i].equals(num[i])) { // 단순 문자열만 비교, == 주소?해시값?까지 비교..
					System.out.println(i + "번쨰 공 당첨!");
					answer++;
				}
			}
			switch (answer) {
			case 1:
				System.out.println("꽝입니다..");
				Money -= 1000;
				System.out.println(
						"현재 금액 :" + Money + " / 총 게임횟수 : " + gamecount + " / 총 수익률 : " + benefit / 1000 * gamecount);
				break;
			case 2:
				System.out.println("6등 입니다");
				Money -= 1000;
				System.out.println(
						"현재 금액 :" + Money + " / 총 게임횟수 : " + gamecount + " / 총 수익률 : " + benefit / 1000 * gamecount);
				break;
			case 3:
				System.out.println("5등 입니다.");
				Money += 5000;
				benefit += 5000;
				System.out.println(
						"현재 금액 :" + Money + " / 총 게임횟수 : " + gamecount + " / 총 수익률 : " + benefit / 1000 * gamecount);
				break;
			case 4:
				System.out.println("4등");
				Money += 50000;
				benefit += 50000;
				System.out.println(
						"현재 금액 :" + Money + " / 총 게임횟수 : " + gamecount + " / 총 수익률 : " + benefit / 1000 * gamecount);
				break;
			case 5:
				System.out.println("3등");
				Money += 1500000;
				benefit += 1500000;
				System.out.println(
						"현재 금액 :" + Money + " / 총 게임횟수 : " + gamecount + " / 총 수익률 : " + benefit / 1000 * gamecount);
				break;
			case 6:
				System.out.println("2등");
				Money += 30000000;
				benefit += 30000000;
				System.out.println(
						"현재 금액 :" + Money + " / 총 게임횟수 : " + gamecount + " / 총 수익률 : " + benefit / 1000 * gamecount);
				break;
			case 7:
				System.out.println("1등");
				Money += 2000000000;
				benefit += 2000000000;
				System.out.println(
						"현재 금액 :" + Money + " / 총 게임횟수 : " + gamecount + " / 총 수익률 : " + benefit / 1000 * gamecount);

				break;
			}
		}
	}
}
