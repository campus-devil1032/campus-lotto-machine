import java.util.Arrays;
import java.util.Scanner;

public class LottoMaker {
	private int choice = 0;
	private int num = 0;
	private int count = 0;
	Scanner sc;

// 유저에게 로또번호를 입력받습니다. 수동로또
	public void lottoInput(Scanner sc) {

		System.out.println("1-45까지의 로또 번호 6자리를 입력해주세요!"); // 중복, 범위 아닌 값 예외처리
		int[] usernum = new int[6]; // user가 입력한 숫자를 담을 배열 선언, 숫자 6개 까지만 입력 가능

		for (int i = 0; i < usernum.length; i++) { // 숫자 6개까지만 입력 가능
			usernum[i] = sc.nextInt(); // 유저에게 숫자 입력받기
			if (usernum[i] > 45 || usernum[i] < 1) { // 숫자 범위 제한
				System.out.println("1-45사이의 정수만 입력 가능합니다.");
				i--;
			}
			for (int j = 0; j < i; j++) { // 중복된 값 제거
				if (usernum[i] == usernum[j]) { // 먼저 입력한 수와 같으면 숫자를 제거
					System.out.println("중복된 숫자를 입력하셨습니다");
					i--;
				}

			}

		}
		Arrays.sort(usernum); // 오름차순 정렬

		// 입력한 번호 확인
		System.out.println("나의 번호 : ");

		System.out.println(Arrays.toString(usernum)); // 입력한 6개 숫자를 출력

		// System.out.println();

		// 당첨번호를 랜덤으로 추출합니다.
		int[] lotto = new int[6]; // 당첨번호 6개를 저장하는 배열
		for (int i = 0; i < 6; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) { // 중복된 값을 제거해줍니다.
				if (lotto[i] == lotto[j]) {
					i--;
					break; // 만약 중복된 값이 추출되면 한 번 더 i를 랜덤으로 생성합니다.
				}
			}
		}
		Arrays.sort(lotto); // 당첨번호 오름차순
		System.out.println("당첨번호 : ");
		System.out.println(Arrays.toString(lotto));

		// 입력받은 번호와 당첨번호를 비교합니다
		for (int i = 0; i < 6; i++) { // 숫자 6개 중에
			for (int j = 0; j < 6; j++) {
				if (usernum[i] == lotto[j]) { // 서로 중복이 존재하면 count 숫자를 1개씩 증가시킵니다.
					count++;
				}
			}
			this.setCount(count);
		}
	}

	// 로또 번호 6자리를 랜덤으로 생성합니다. 자동로또
	public void lottoRandom() {
		// 로또번호를 랜덤으로 추출합니다.
		int[] userlotto = new int[6]; // 당첨번호 6개를 저장하는 배열
		for (int i = 0; i < 6; i++) {
			userlotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) { // 중복된 값을 제거해줍니다.
				if (userlotto[i] == userlotto[j]) {
					i--;
					break; // 만약 중복된 값이 추출되면 한 번 더 i를 랜덤으로 생성합니다.
				}
			}
		}
		Arrays.sort(userlotto); // 당첨번호 오름차순
		System.out.println("나의 번호 : ");
		System.out.println(Arrays.toString(userlotto));

		// 당첨번호를 랜덤으로 추출합니다.
		int[] lotto = new int[6]; // 당첨번호 6개를 저장하는 배열
		for (int i = 0; i < 6; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) { // 중복된 값을 제거해줍니다.
				if (lotto[i] == lotto[j]) {
					i--;
					break; // 만약 중복된 값이 추출되면 한 번 더 i를 랜덤으로 생성합니다.
				}
			}
		}
		Arrays.sort(lotto); // 당첨번호 오름차순
		System.out.println("당첨번호 : ");
		System.out.println(Arrays.toString(lotto));

		// 나의 번호와 당첨번호를 대조합니다.
		for (int i = 0; i < 6; i++) { // 숫자 6개 중에
			for (int j = 0; j < 6; j++) {
				if (userlotto[i] == lotto[j]) { // 서로 중복이 존재하면 count 숫자를 1개씩 증가시킵니다.
					count++;
				}
			}
			this.setCount(count);
		}

	}

	

	// get/set 영역입니다. >> get/set을 더 공부해봅시다.
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
