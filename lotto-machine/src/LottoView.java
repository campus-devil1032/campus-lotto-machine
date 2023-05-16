import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoView {
    private Scanner scanner;

    public LottoView() {
        this.scanner = new Scanner(System.in);
    }

    public int getAmount() {
        System.out.print("로또를 구매할 금액을 입력하세요: ");
        return scanner.nextInt();
    }

    public int getManualCount() {
        System.out.print("수동으로 발급할 로또 게임 수를 입력하세요: ");
        return scanner.nextInt();
    }

    public List<Integer> getManualNumbers() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("로또 번호 6개를 입력하세요 (1 ~ 45 사이):");
        for (int i = 0; i < 6; i++) {
            int number = 0;
            while (true) {
                System.out.print("번호 " + (i + 1) + ": ");
                number = scanner.nextInt();
                if (number >= 1 && number <= 45) {
                    break; // 1부터 45 사이의 값이면 반복문 종료
                } else {
                    System.out.println("1부터 45 사이의 숫자를 입력해주세요.");
                }
            }
            numbers.add(number);
        }
        return numbers;
    }

    public void displayResult(double profitRate) {
        System.out.println("수익률: " + profitRate);
        if (profitRate<1){
            System.out.println("손해입니당!");
        }
        else if(profitRate == 1){
            System.out.println("본전입니당!");
        }
        else {
            System.out.println("이익입니당!");
        }
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    public void displayMyLottos(List<List<Integer>> allTickets) {
        System.out.println("========== 내 로또 내역 ==========");
        for (List<Integer> ticket : allTickets) {
            for (int number : ticket) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }

    public void displayWinningLottos(List<Integer> winningNumbers){
        Collections.sort(winningNumbers);
        System.out.println("당첨번호는 : " + winningNumbers);
    }

    public void displayBonusNumber(int bonusNumber){
        System.out.println("보너스 번호는 : " + bonusNumber);
    }

    public void displayPrize(int prize){
        System.out.println("상금은 : " + prize);
    }
}

