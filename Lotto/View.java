package Lotto;

import java.util.Scanner;

public class View {
	private Scanner scanner;
	int num;

	public View() {
		scanner = new Scanner(System.in);
	}

	public int getNum() {

		System.out.println("값을 입력해주세요");
		num = scanner.nextInt();
		return num;
	}

	public void showNum(int num) {
		System.out.print("입력하신 숫자는");

		System.out.print(num + " ");

		System.out.print("입니다.");

	}

}
