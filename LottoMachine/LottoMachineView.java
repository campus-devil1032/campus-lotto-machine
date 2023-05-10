package LottoMachine;

import java.util.Scanner;

public class LottoMachineView {
	
	private Scanner scanner;
	private LottoMachineController controller;
	
	public LottoMachineView(LottoMachineController controller) {
		this.controller = controller;
		scanner = new Scanner(System.in);
	}
	
	// 로또 번호 입력 받기
	public void getInputLottoNum() {
		int num = 0;
		boolean isValidNum = false;
		while(!isValidNum) {
			try {
				for (int i = 1; i <= 6; i++) {
					System.out.println("로또 번호를 입력하세요 ["+i+"회] :");
					String input = scanner.nextLine();
					num = Integer.parseInt(input);
					if (num < 1 || num > 45) {
						throw new NumberFormatException();
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("1~45 사이의 정수를 입력하세요 :");
			}
			isValidNum = true;
		}
		controller.showTable(num);
	}
	
	public void displayTable(String table) {
		System.out.println(table);
	}

}
