package LottoMachine;

import java.util.Random;

public class LottoMachineModel {
	private int num;
	
	public LottoMachineModel(int num) {
		this.num = num;
	}

	// 로또 번호 생성
	public String createLotto() {
		Random lotto = new Random();
		
		int[] arrLotto = new int[6];
		StringBuilder printLotto = new StringBuilder();
		
		// 로또 번호 생성 및 출력 멘트 배열화
		for (int i = 0; i < 6; i++) {
			arrLotto[i] = (int)(Math.random()*45)+1;
			printLotto.append("로또 번호 ")
						.append(i+1)		// 번호 순서
						.append("번 : ")
						.append(arrLotto[i]) // 로또 번호
						.append("\n");
		}
		return printLotto.toString();
	}
	
	// 입력한 로또 번호 출력
	// ** 입력 받은 번호 배열화 하기 **
	public String getInputTable() {
		StringBuilder inputNum = new StringBuilder();
		System.out.println("입력한 로또 번호를 확인하세요.");
		for (int i = 0; i < 6; i++) {
			inputNum.append("[")
					.append(num)
					.append("] ");
		}
		return inputNum.toString();
	}
	
	public int getNum() {
		return num;
	}
}
