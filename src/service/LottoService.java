package service;
import exception.IllegalMoneyException;
import exception.LackOfMoneyException;
import model.Lotto;
import model.Player;
import utils.UserInputRouter;
import view.LottoView;

import java.io.IOException;

public class LottoService {
    private UserInputRouter uir = new UserInputRouter();
    private LottoView lottoView = new LottoView();
    private Player player = new Player();

    public void run() throws LackOfMoneyException, IllegalMoneyException, IOException {
        int userMoney = uir.getUserMoney();

        int totalLotto = getTotalLottoCount(userMoney);
        int manualLotto = uir.getUserManualLottoCount();
        int autoLotto = totalLotto - manualLotto;

        System.out.println("totalLotto = " + totalLotto);
        System.out.println("autoLotto = " + autoLotto);
        System.out.println("manualLotto = " + manualLotto);


        player.setMoney(userMoney);
    }

    public int getTotalLottoCount(int money){
        return money / 1000;
    }

}
