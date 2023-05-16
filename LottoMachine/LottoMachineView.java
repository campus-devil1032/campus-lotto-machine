package LottoMachine;

import java.util.Scanner;
import java.util.Set;

import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.*;

public class LottoMachineView {
	private Scanner scanner;
	
	public LottoMachineView() {
		scanner = new Scanner(System.in);
	}
	
	public int receiveMoney() {
		System.out.println("로또는 한 게임당 [1000원]입니다.");
		System.out.println("로또 구매 금액을 입력하세요 : ");
		int receiveMoney = scanner.nextInt();
		return receiveMoney;
	}
	
	public String[] getLottoNum() {
		String[] lottoList;
		System.out.print("_______________________\n 로또 번호 6개를 입력하세요 \n ⇒");
		String str = scanner.nextLine();
		lottoList = str.split(" ");
		return lottoList;
	}
	
	public void printInputLottoNum(int[] lottoNum) {
		System.out.println("\n***입력하신 번호를 확인하세요***");
		System.out.print("입력 로또 번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print("[" + lottoNum[i] + "] ");
		}
		System.out.println("\n");
	}
	
	public void printOutputLottoNum(int[] lottoNum) {
		System.out.println("***로또 번호를 추첨합니다***");
		System.out.print("로또 번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print("[" + lottoNum[i] + "] ");
		}
		System.out.println("\n");
	}
	
	public void printLottoGameResult(int matchCount) {
		System.out.println(matchCount + "개가 일치합니다.");
	}
	
	public void printChkMsg(int select) {
		switch (select) {
			case 1 : System.out.println("");
		}
	}
	
	public void printErrorMsg(int select) {
		switch (select) {
	        case 1:  System.out.println("※1~45 사이의 숫자를 입력하세요※");
	                 break;
	        case 2:  System.out.println("※6개의 번호를 입력하세요※");
	                 break;
	        case 3 : System.out.println("1000원 단위의 금액을 정확히 입력하세요.");
	        		 break;
		}
	}
}