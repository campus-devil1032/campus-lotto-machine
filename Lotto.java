package Chapter04;

import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {

		int[] lottoNum = new int[6];
		for (int i = 0; i < lottoNum.length; i++) {

			lottoNum[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {

				if (lottoNum[i] == lottoNum[j]) {
					i--;

				}

			}

		}
		System.out.print("로또번호" + "\n[");
		for (int i = 0; i < lottoNum.length; i++) {
			System.out.print(lottoNum[i]);
			if (i != lottoNum.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("]");
			}
		}

	}

}
