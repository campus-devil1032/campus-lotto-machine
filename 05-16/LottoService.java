package lotto_machine;

import lotto_machine.exceptions.LottoInvalidAmountException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoService {

    public void serviceLottoAmountSetting() {        //로또 게임을 진행할 금액을 입력 받는 함수
        setRateOfReturn(0.0);    //수익률 다시 초기화
        while (true) {
            try {
                // TODO : 모든 뷰는 컨트롤러로 책임 이관
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
}
