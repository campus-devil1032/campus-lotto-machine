package lotto_machine;

import java.util.Arrays;

public class LottoView {
    public void Menu() { //메뉴판 뷰
        this.viewLottoHeader("=========<메 뉴>========");
        this.viewLottoHeader("1번을 누르면 로또게임을 시작합니다.");
        this.viewLottoHeader("2번을 누르면 당첨 통계를 확인합니다.");
        this.viewLottoHeader("3번을 누르면 수익률을 확인합니다.");
        this.viewLottoHeader("4번을 누르면 게임 리셋 합니다.");
        this.viewLottoHeader("5번을 누르면 프로그램을 종료합니다.");
        this.viewLottoHeader("======================");
        this.viewLottoHeader("입력:");
    }

    public void viewBoughtLottoTicketCount(int lottoTicketCnt) {
        this.viewLottoHeader("총" + lottoTicketCnt + "장");
    }

    public void gameView(int[] lotto) { // 게임생성 뷰
        for (int i = 0; i < lotto.length; i++) {
            System.out.print(lotto[i] + " ");
        }

        this.viewLottoHeader();
    }

    public void viewManualGameTicketPrint(int passivity, int[][] number, int[] lotto) {    //수동 뷰
        for (int i = 0; i < passivity; i++) {
            Arrays.sort(number[i]);
            System.out.print("[" + (i + 1) + "] ");
            for (int j = 0; j < lotto.length; j++) {
                System.out.print(number[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void auto_view(int auto, int times, int passivity, int[] lotto, int[][] number) {    //자동 뷰

        auto = times - passivity;
        this.viewLottoHeader("자동 " + auto + "장");


        for (int i = 0; i < times - passivity; i++) {
            LottoApplication.randGame(lotto);
            for (int j = 0; j < lotto.length; j++)
                number[i + passivity][j] = lotto[j];
            System.out.print("[" + (i + passivity + 1) + "] ");
            this.gameView(lotto);
        }

    }

    public void viewInvalidUserInput() {
        viewLottoHeader("잘못된 문자를 입력하셨습니다.");
    }

    public void viewLottoIntroMessage() {
        viewLottoHeader("=====<로또 게임>=====");
    }

    public void viewLottoBuyAmountMessage() {
        viewLottoHeader("로또 게임을 진행할 금액을 입력해주세요(로또 한장에 1000원):");
    }

    public void viewNeedMoreAmountMessage() {
        viewLottoHeader("구매 금액이 1000원 단위가 아닙니다.");
    }


    public void viewInvalidAmount() {
        viewLottoHeader("잘못된 입력! 금액을 잘못 입력하셨습니다!");
    }

    public void viewLottoHeader(String printMessage) {
        System.out.println("[Lotto]\t" + printMessage);
    }

    public void viewLottoHeader() {
        System.out.println("[Lotto]\t");
    }

}
