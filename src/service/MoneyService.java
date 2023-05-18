package service;

import exception.IllegalMoneyException;
import exception.LackOfMoneyException;
import model.Player;
import utils.UserInputRouter;
import view.LottoView;

import java.io.IOException;

public class MoneyService {
    private UserInputRouter uir = new UserInputRouter();
    private LottoView lottoView = new LottoView();

    /**
     * 사용자 금액 입력
     * @throws LackOfMoneyException
     * @throws IllegalMoneyException
     * @throws IOException
     */
    public Player doGetMoneyByUser() throws IOException, LackOfMoneyException, IllegalMoneyException {
        int userMoney = uir.getUserMoney();
        int totalLotto = getTotalLottoCount(userMoney);
        int manualLotto = uir.getUserManualLottoCount();
        int autoLotto = totalLotto - manualLotto;

        Player player = new Player(userMoney, totalLotto, manualLotto, autoLotto);

        return player;
    }

    /**
     * 입력받은 금액으로 살 수 있는 총 로또 갯수 구하기
     * @param money
     * @return
     */
    public int getTotalLottoCount(int money){
        return money / 1000;
    }
}
