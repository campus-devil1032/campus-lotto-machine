package lotto_machine;

public class LottoController {
    private final LottoView lottoView = new LottoView();

    private void controllerLottoGameStart() {
        lottoView.viewLottoIntroMessage();
        serviceLottoAmountSetting();

        System.out.println("=======<당청 번호>=====");
        randGame(this.lotto);
        lottoView.gameView(this.lotto);

        compare();
        check = false;
        lottoView.Menu();
    }
}
