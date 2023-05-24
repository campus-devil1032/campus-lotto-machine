package lottogame.View;

import java.util.Arrays;
import java.util.Scanner;

public class LottoView {
    private Scanner input;

    public LottoView() {
        input = new Scanner(System.in);
    }

    // 유저에게 로또금액을 입력 받음
    public int getAmount() {
        System.out.println("< 장 당 1000원 > 구매하실 로또 금액을 입력하시오 : ");
        int amount = input.nextInt();
        return amount;

    }

    // 유저에게 로또번호를 입력 받음
    public int[] getUserNumbers() {
        int[] userNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.print((i + 1) + "번째 로또 번호를 입력하세요 : ");
            userNumbers[i] = input.nextInt();
        }
        return userNumbers;
    }

    // 로또 당첨번호 출력
    public void winningNumber(int[] lottoNumbers) {
        System.out.println("당첨 번호 : " + Arrays.toString(lottoNumbers));
    }

    public void printMatchCount(int count) {
        System.out.println("일치하는 번호 개수 : " + count);

    }

    public void printPrizeMoney(int prizeMoney) {
        System.out.println("당첨 금액 : " + prizeMoney);
    }

    public void printRateReturn(int prizeMoney) {

        int rateOfReturn = prizeMoney / 1000 * 100;

        if (rateOfReturn >= 200) {
            System.out.println("수익률 : " + rateOfReturn + "% 이 득");
            System.out.println("_________________________");
        }
        if (rateOfReturn <= 0) {
            System.out.println("수익률 : " + rateOfReturn + " % 손 해");
            System.out.println("_________________________");
        }
        if (rateOfReturn == 100) {
            System.out.println("수익률 : " + rateOfReturn + " % 본 전");
            System.out.println("_________________________");
        }
    }

    public void printLottoError(String programName, String message) {
        // 예외 발생 시 원하는 출력 방식으로 예외 정보를 표시할 수 있음
        System.out.println(" [" + programName + " 실행 중 에러 발생] " + message);
    }


}

