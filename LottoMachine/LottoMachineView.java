package campus_lotto_machine.LottoMachine;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoMachineView {
    private Scanner sc;

    public LottoMachineView() {
        sc = new Scanner(System.in);
    }

    // 구매액 입력
    public int getPurchaseAmount() {
        System.out.print("구매하시려는 로또 구매액을 입력하세요 (1000원 단위) : ");
        int purchasesAmount = sc.nextInt();
        while (purchasesAmount % 1000 != 0 || purchasesAmount < 1000) {
            System.out.print("구매 금액이 1000원 단위가 아닙니다. 다시 구매액을 입력하세요 : ");
            purchasesAmount = sc.nextInt();
        }
        return purchasesAmount;
    }

    // 수동 로또 수량 입력받기
    public int getManualPurchaseCount() {
        System.out.print("원하시는 수동로또 수량이 어떻게 되시나요? : ");
        int manualPurchases = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        return manualPurchases;
    }

    // 수동로또번호 입력받기
    public int[][] generateManualLottoNumbers(int manualPurchases, int lottoNumberSize) {
        int[][] manualLottoNumbers = new int[manualPurchases][lottoNumberSize];

        for (int i = 0; i < manualPurchases; i++) {
            boolean validNumber = false;
            while (!validNumber) {
                System.out.print("로또 번호를 입력하세요 (" + (i + 1) + "번째): ");
                String input = sc.nextLine();
                String[] numbers = input.split(" ");

                if (numbers.length == lottoNumberSize && isValidLottoNumbers(numbers)) {
                    validNumber = true;
                    for (int j = 0; j < lottoNumberSize; j++) {
                        manualLottoNumbers[i][j] = Integer.parseInt(numbers[j]);
                    }
                } else {
                    System.out.println("유효하지 않은 로또 번호입니다. 다시 입력하세요.");
                }
            }
        }
        return manualLottoNumbers;
    }

    // 번호 검사 메소드
    private boolean isValidLottoNumbers(String[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
                if (num < 1 || num > 45) {
                    return false;
                }
                set.add(num);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return set.size() == numbers.length;
    }

    // 수동번호 출력
    public void displayManualLottoNumbers(int[][] manualLottoNumbers) {
        for (int i = 0; i < manualLottoNumbers.length; i++) {
            System.out.println((i + 1) + "번째 [수동]로또 번호: " + java.util.Arrays.toString(manualLottoNumbers[i]));
        }
    }

    // 자동번호 출력
    public void displayAutoLottoNumbers(int[][] autoLottoNumbers) {
        for (int i = 0; i < autoLottoNumbers.length; i++) {
            System.out.println((i + 1) + "번째 [자동]로또 번호: " + java.util.Arrays.toString(autoLottoNumbers[i]));
        }
    }

    // 당첨번호 출력
    public void displayWinningNumber(int[] winningNumber) {
        System.out.println("<당첨번호>");
        System.out.println(java.util.Arrays.toString(winningNumber));
    }

    // 일치개수 출력
    public void displayMatchCount(int matchCount, String type, int index) {
        System.out.println(type + (index + 1) + "번째 로또번호 일치개수: " + matchCount);
    }
}