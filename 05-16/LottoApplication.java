package lotto_machine;

import lotto_machine.exceptions.LottoInvalidAmountException;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoApplication {
    private final LottoView lottoView = new LottoView();
    private static Scanner input = new Scanner(System.in);
    private String print;
    private int lotto[];     //로또 당첨 번호
    private int number[][];     //로또  게임을 진행한 금액 만큼 생성될 로또 배열
    private int money;         //로또 게임을 진행할 금액
    private int times;         //로또 게임 총 진행 횟수
    private int passivity;   //수동 게임 진행 횟수
    private int auto;         // 자동 게임 진행 회수
    private int winnerNumberFirst;     // 당첨금 1등
    private int number_5;     // 당첨금 3등
    private int number_4;     // 당첨금 4등
    private int number_3;     // 당첨금 5등
    private int passivity_i; // 수동 로또 행
    private int total_money; // 총 당첨 금액
    private double rateOfReturn;  // 수익률
    private boolean check;     // 당첨 체크

    public LottoApplication() {

        this.passivity_i = 0;
        this.total_money = 0;
        this.winnerNumberFirst = 0;
        this.number_5 = 0;
        this.number_4 = 0;
        this.number_3 = 0;
        this.rateOfReturn = 0.0;
        this.lotto = new int[6];
        this.check = false;
    }

    public String getPrint() {
        // TODO : 이름 변경 -> 프로그램 진입점으로 보임.
        System.out.println("[정상출력] " + print);

        while (true) {

            try {
                selectSwitch();

            } catch (InputMismatchException e) {
                System.out.println("잘못된 문자를 입력했습니다!");
                input = new Scanner(System.in);
            }

        }

    }

    public void setPrint(String print) {
        this.print = print;
    }

    public void selectSwitch() { //메뉴 스위치 함수
        lottoView.Menu();
        int menuNumberByUser = 0;

        while (true) {
            menuNumberByUser = getAnIntByUser();
            switch (menuNumberByUser) {
                case 1:
                    controllerLottoGameStart();
                    break;
                case 2:
                    controllerWinnerStatistic();
                    break;
                case 3:
                    controllerRateOfReturn();
                    break;
                case 4:
                    controllerGameReset();
                    break;
                case 5:
                    exitProgramBy0();
                default:
                    lottoView.viewInvalidUserInput();
                    lottoView.Menu();
            }
        }

    }

    private static void exitProgramBy0() {
        input.close();
        System.out.println("프로그램을 정상적으로 종료!");
        System.exit(0);
    }

    private void controllerGameReset() {
        System.out.println("게임 리셋~!!!");
        this.winnerNumberFirst = 0;
        this.number_5 = 0;
        this.number_4 = 0;
        this.number_3 = 0;
        lottoView.Menu();
    }

    private void controllerRateOfReturn() {
        System.out.println("※이전 게임에 대한 수익률 입니다.");
        System.out.println("※수익률은 다음 게임 마다 초기화 됩니다.");
        System.out.println("수익률: ");
        Money.money_Manage(this.total_money, this.number, this.winnerNumberFirst, this.number_5, this.number_4, this.number_3, this.rateOfReturn, this.times);
        lottoView.Menu();
    }

    private void controllerWinnerStatistic() {
        valueOf(); //당첨 통계
        lottoView.Menu();
    }

    public void valueOf() { // 로또 당첨 통계 뷰
        System.out.println("==========<<당첨 시 금액>>==========");
        System.out.println("3개 일치 시 상금:5,000원");
        System.out.println("4개 일치 시 상금:50,000원");
        System.out.println("5개 일치 시 상금: 1,500,000원");
        System.out.println("6개 일치 상금: 2,000,000,000원 (20억)");
        System.out.println("===============================");

        System.out.println("※프로그램이 돌아가는 동안의 당첨 통계입니다.");
        System.out.println("※게임 메뉴에서 리셋이 가능합니다~!.");
        System.out.println("당첨 통계: ");
        System.out.println("1등 " + this.winnerNumberFirst + "번");
        System.out.println("3등 " + this.number_5 + "번");
        System.out.println("4등 " + this.number_4 + "번");
        System.out.println("5등 " + this.number_3 + "번");
    }


    public static void randGame(int[] lotto) { // 로또 게임 생성기

        for (int i = 0; i < lotto.length; i++) {
            int num = (int) (Math.random() * 45) + 1;
            lotto[i] = num;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }

        }

        Arrays.sort(lotto);        //오름차순 정렬

    }


    public void setRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public void serviceLottoAmountSetting() {        //로또 게임을 진행할 금액을 입력 받는 함수
        setRateOfReturn(0.0);    //수익률 다시 초기화
        while (true) {
            try {
                lottoView.viewLottoBuyAmountMessage();
                this.money = getAnIntByUser();
                if (this.money % 1000 != 0) {
                    lottoView.viewNeedMoreAmountMessage();
                }
                if (this.money % 1000 == 0) {
                    break;
                }
                throw new LottoInvalidAmountException();
            } catch (InputMismatchException e) {
                input = new Scanner(System.in);
                lottoView.viewInvalidAmount();
            }
        }

        this.times = this.money / 1000;
        this.number = new int[this.times][6];
        lottoView.viewBoughtLottoTicketCount(this.times);
        serviceManualGame();

        //duplication_Verification();
        lottoView.viewManualGameTicketPrint(this.passivity, this.number, this.lotto);
        lottoView.auto_view(this.auto, this.times, this.passivity, this.lotto, this.number);
    }

    private static int getAnIntByUser() {
        return input.nextInt();
    }

    public void serviceManualGame() { //수동 게임

        while (true) {
            try {
                input = new Scanner(System.in);

                System.out.println("수동 몇 장?");
                this.passivity = getAnIntByUser();
                System.out.println("수동 " + this.passivity + "장");
                break;
                // input = new Scanner(System.in);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력!");
            }
        }
        passivity_Ex();

    }

    public void passivity_Ex() { //수동 입력 예외 함수

        try {

            for (this.passivity_i = 0; this.passivity_i < this.passivity; this.passivity_i++) {

                if (this.passivity_i >= 0) {

                    System.out.println("[" + (this.passivity_i + 1) + "번째]" + "로또 번호 6개를 입력해 주세요!");
                } else {
                    break;
                }

                for (int j = 0; j < lotto.length; j++) {

                    this.number[this.passivity_i][j] = getAnIntByUser();

                }

                verification(this.passivity_i);

            }

        } catch (InputMismatchException e) {
            input = new Scanner(System.in);
            passivity_Ex();
        }


    }

    public void verification(int k) {  // 검증 함수

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < i; j++) {

                if (this.number[k][j] > 45 || this.number[k][j] <= 0) {
                    System.out.println("1 ~ 45 사이의 숫자만 입력 가능합니다.");

                    this.passivity_i--;

                    //		this.count++;

                    if (i == 5) {
                        this.passivity_i = -1;
                    }

                    break;

                }


                if (this.number[k][i] == this.number[k][j]) {

                    this.passivity_i--;

                    System.out.println("중복된 숫자!");


                    this.passivity_i = -1;

                    break;

                }

            }

        }
    }


    public void compare() {    //비교 함수: 돈으로 구매한 로또와 당첨 로또 번호와 비교

        System.out.println("-----<result>-----");

        int count = 1;

        for (int i = 0; i < this.times; i++) {
            count = 1;
            for (int j = 0; j < lotto.length; j++) {
                if (this.number[i][j] != this.lotto[j]) {
                    //System.out.println("낙첨되셨습니다!");

                    break;
                }


                if (count == 6) {
                    check = true;
                    System.out.println("[" + (i + 1) + "] " + "1등 당첨되셨습니다!");
                    this.winnerNumberFirst++;

                } else if (count == 5) {
                    check = true;
                    System.out.println("[" + (i + 1) + "] " + "3등 당첨되셨습니다!");
                    this.number_5++;
                } else if (count == 4) {
                    check = true;
                    System.out.println("[" + (i + 1) + "] " + "4등 당첨되셨습니다!");
                    this.number_4++;
                } else if (count == 3) {
                    check = true;
                    System.out.println("[" + (i + 1) + "] " + "5등 당첨되셨습니다!");
                    this.number_3++;
                }

                count++;
            }

        }

        if (this.check == false) {
            System.out.println("전부 꽝!!!");
        }
    }


}
		
	
	
