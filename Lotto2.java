import java.util.Scanner;

public class Lotto2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] lottoNum = new int[6];
		int[] userNum = new int[6];
		int score = 0;
		int price = 0;
		boolean bonus = false;
		int 돈 = 0;
		int 로또금액 = 1000;
		int 시도횟수 = 0;

		int bonusNum = 0;
		System.out.println("로또 구매 시스템을 시작합니다.");
		System.out.println("로또 금액:1000원   돈을 넣으세요");
		돈 = scanner.nextInt();

		while (true) {
			시도횟수++;
			if (돈 >= 로또금액) {
				돈 -= 로또금액;

			} else {
				System.out.println("돈이 부족하여 종료");
				break;
			}

			System.out.println(시도횟수 + "번 로또를 시작합니다. 번호 6자리를 입력하세요(1~45)");
			userNum[0] = scanner.nextInt();
			userNum[1] = scanner.nextInt();
			userNum[2] = scanner.nextInt();
			userNum[3] = scanner.nextInt();
			userNum[4] = scanner.nextInt();
			userNum[5] = scanner.nextInt();

			for (int i = 0; i < 6; i++) {
				lottoNum[i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {

					if (lottoNum[i] == lottoNum[j]) {
						i--;
					}  //중복된 번호가 있을 시 , i를 1 감소시켜 한번 더 번호를 부여(초기화)받도록 함  
					
					//오름차순으로 정렬 하기
					if(lottoNum[j]>lottoNum[i]) {    //만약, i번 인덱스의 요소가 0번 인덱스 보다 값이 작을 시, i번 인덱스의 값이 0번 인덱스의 값보다 인덱스의 수가 적어야 함
						int temp; //빈 컵을 준비함
						temp=lottoNum[j];  //빈 컵에0번쨰 값을 붙여넣고 
						lottoNum[j]=lottoNum[i];   //0번에 i번째 값을 붙여넣음
						lottoNum[i]=temp;   //i번 인덱스에  temp(0번 값이 담겨잇음)의 값을 복붙함
					
					}

					while (true) {
						bonusNum = (int) (Math.random() * 45) + 1;   //보너스 번호 
						if (lottoNum[i] != bonusNum) {
							break;

						}
					}
					if (userNum[i] == bonusNum) { 
						bonus = true;  
					}

				} // 로또번호 생성 end

				// 보너스볼 생성
			}

			for (int i = 0; i < lottoNum.length; i++) {
				for (int j = 0; j < userNum.length; j++) {
					if (lottoNum[i] == userNum[j]) {
						score++;

					}
				}
			}

			if (score == 3) {
				price = 5000;

			} else if (score == 4) {
				price += 50000;
			} else if (score == 5) {
				price += 1500000;
			} else if (score == 5 & bonus == true) {
				price += 30000000;
			} else if (score == 6) {
				price += 2000000000;
			}
			돈 += price;
			System.out.println("맞춘 숫자 " + score + "개, 상금 " + price +"원");
			System.out.println("이번 회차 로또 당첨 번호는 ");
			for (int i = 0; i < lottoNum.length; i++) {
				System.out.print(lottoNum[i] + " ");
			}
			System.out.println("입니다.  보너스 번호는 " + bonusNum + " 입니다.");
			System.out.println("남은 돈 : " + 돈);

			System.out.println("수익률은 " + price / 돈 + "입니다.");

			System.out.println("로또를 더 구매하시겠습니까? 예:아무키   아니오:2 입력");
			int replay = scanner.nextInt();
			if (replay == 2) {
				break;
			}

		} // while문 end

	}

}
