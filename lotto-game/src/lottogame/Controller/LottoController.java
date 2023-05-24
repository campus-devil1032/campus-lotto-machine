package lottogame.Controller;

import lottogame.Model.LottoModel;
import lottogame.View.LottoView;


public class LottoController {

    private LottoModel model;
    private LottoView view;

    public LottoController() {

        this.model = new LottoModel();
        this.view = new LottoView();

    }

    public void run() {

        int money = 0;

        // 사용자에게 로또 금액을 입력 받음
        money = view.getAmount();

        // 입력값이 1000원 단위가 아닐경우
        if (!model.getLottoAmount(money)) {
            view.printLottoError("로또 게임", "1000원 단위로만 구매 가능합니다");
        }
        // 로또번호 생성
        int[] lottoNumbers = model.getRandomLotto();

        // 로또게임 티켓 = 로또 장 수
        int lottoTicket = money / 1000;

        // EX) 3000원 일시 lottoTicket == 3
        for (int i = 0; i < lottoTicket; i++) {

            // 사용자의 로또 입력값
            int[] userLotto = view.getUserNumbers();

            // 유저의 로또번호와 랜덤번호 일치하는 번호 확인
            int count = model.getCount(userLotto, lottoNumbers);

            // 당첨 상금 계산
            int winner = model.lottoPrizeMoney(count);

            // 일치하는 번호 개수 출력
            view.printMatchCount(count);

            // 당첨 상금 출력
            view.printPrizeMoney(winner);

            // 수익률
            view.printRateReturn(winner);
        }


        // 생성된 로또번호 출력
        view.winningNumber(lottoNumbers);


    }
}
