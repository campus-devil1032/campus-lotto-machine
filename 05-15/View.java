package lotto_machine;

import java.util.Arrays;

public class View {
	public static void Menu() { //메뉴판 뷰
		System.out.println("=========<메 뉴>========");
		System.out.println("1번을 누르면 로또게임을 시작합니다.");
		System.out.println("2번을 누르면 당첨 통계를 확인합니다.");
		System.out.println("3번을 누르면 수익률을 확인합니다.");
		System.out.println("4번을 누르면 게임 리셋 합니다.");
		System.out.println("5번을 누르면 프로그램을 종료합니다.");
		System.out.println("======================");
		System.out.println("입력:");
	}
	
	public static void gameView(int[] lotto) { // 게이생성 뷰
		for(int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		
		System.out.println();
	}
	
	public static void passivity_view(int passivity, int[][] number, int[] lotto) {	//수동 뷰
		
		for (int i = 0; i < passivity; i++) {
			
			Arrays.sort(number[i]);
			
			System.out.print("[" + (i+1) + "] ");
			for(int j = 0; j < lotto.length; j++) {
				System.out.print(number[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void auto_view(int auto, int times, int passivity, int[] lotto, int[][] number) {	//자동 뷰
		
		auto = times - passivity;
		System.out.println("자동 " + auto + "장");
		
		
		for(int i = 0; i<times-passivity; i++) {
			ModelDTO.randGame(lotto);
			
				for(int j = 0; j<lotto.length; j++)
					number[i+passivity][j] = lotto[j];
			System.out.print("[" + (i+passivity+1) + "] ");
			View.gameView(lotto);
		}

	}

	
	
}
